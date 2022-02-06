package com.yoenas.movietvshow.presentation.home.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.databinding.FragmentMovieBinding
import com.yoenas.movietvshow.presentation.detail.DetailActivity
import com.yoenas.movietvshow.presentation.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding as FragmentMovieBinding

    private var _homeViewModel: HomeViewModel? = null
    private val homeViewModel get() = _homeViewModel as HomeViewModel

    private val movieAdapter by lazy { MovieAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMovieBinding.inflate(inflater)

        _homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getListMovie().observe(viewLifecycleOwner, {
            movieAdapter.setData(it)
            Log.i("GetListMovies", "onViewCreated: $it")
            binding.rvMovies.apply {
                layoutManager = GridLayoutManager(context, 3)
                adapter = movieAdapter
            }
        })

        movieAdapter.listener = { _: View, item: MovieTvShow, _: Int ->
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, item.id)
            intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.TYPE_MOVIE)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}