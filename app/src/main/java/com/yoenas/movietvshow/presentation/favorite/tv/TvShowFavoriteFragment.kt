package com.yoenas.movietvshow.presentation.favorite.tv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.databinding.FragmentTvShowFavoriteBinding
import com.yoenas.movietvshow.presentation.detail.DetailActivity
import com.yoenas.movietvshow.presentation.favorite.FavoriteAdapter
import com.yoenas.movietvshow.presentation.favorite.FavoriteItemClickCallback
import com.yoenas.movietvshow.presentation.favorite.FavoriteViewModel
import com.yoenas.movietvshow.presentation.favorite.SwipeToDelete
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFavoriteFragment : Fragment(), FavoriteItemClickCallback {
    private var _binding: FragmentTvShowFavoriteBinding? = null
    private val binding get() = _binding as FragmentTvShowFavoriteBinding

    private var _viewModel: FavoriteViewModel? = null
    private val viewModel get() = _viewModel as FavoriteViewModel

    private val favoriteAdapter by lazy { FavoriteAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTvShowFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _viewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]

        binding.apply {
            progressBar.visibility = View.VISIBLE

            viewModel.getFavoriteTvShows().observe(viewLifecycleOwner) {
                Log.i("GetFavoriteMovies", "onViewCreated: get favoriteMovies $it")
                progressBar.visibility = View.GONE
                favoriteAdapter.submitList(it)

                rvFavTvShows.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = favoriteAdapter
                    swipeToDelete(this)
                }
            }
        }
    }

    private fun swipeToDelete(recyclerView: RecyclerView) {
        val swipeToDeleteCallback = object : SwipeToDelete(0) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val deletedItem = favoriteAdapter.getSwipeData(viewHolder.adapterPosition)
                deletedItem?.let {
                    viewModel.setFavorite(it)
                    restoreDeletedData(view, deletedItem)
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun restoreDeletedData(view: View?, deletedItem: MovieTvShow) {
        val snackBar = Snackbar.make(
            view as View, "Deleted: '${deletedItem.title}'",
            Snackbar.LENGTH_LONG
        )
        snackBar.setAction("Undo") {
            viewModel.setFavorite(deletedItem)
        }
        snackBar.show()
    }

    override fun onItemClicked(data: MovieTvShow) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_DATA, data.movieTvId)
        intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.TYPE_TV)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}