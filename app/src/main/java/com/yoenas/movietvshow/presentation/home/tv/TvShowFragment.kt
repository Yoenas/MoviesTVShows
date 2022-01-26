package com.yoenas.movietvshow.presentation.home.tv

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.yoenas.movietvshow.data.MovieTvShow
import com.yoenas.movietvshow.databinding.FragmentTvShowBinding
import com.yoenas.movietvshow.presentation.home.MainViewModel
import com.yoenas.movietvshow.presentation.home.MovieTvAdapter
import com.yoenas.movietvshow.presentation.detail.DetailActivity
import com.yoenas.movietvshow.utils.OnItemClickCallback

class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding as FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            val viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            ).get(MainViewModel::class.java)

            val tvShowAdapter = MovieTvAdapter()
            tvShowAdapter.setData(viewModel.getListTvShow())

            binding.rvTvShows.apply {
                layoutManager = GridLayoutManager(it, 3)
                adapter = tvShowAdapter
            }

            tvShowAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClicked(data: MovieTvShow) {
                    val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, data.id)
                    startActivity(intent)
                }
            })
        }
    }
}