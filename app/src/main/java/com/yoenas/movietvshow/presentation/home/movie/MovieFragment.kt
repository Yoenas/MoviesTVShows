package com.yoenas.movietvshow.presentation.home.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.yoenas.movietvshow.data.MovieTvShow
import com.yoenas.movietvshow.databinding.FragmentMovieBinding
import com.yoenas.movietvshow.presentation.home.MainViewModel
import com.yoenas.movietvshow.presentation.home.MovieTvAdapter
import com.yoenas.movietvshow.presentation.detail.DetailActivity
import com.yoenas.movietvshow.utils.OnItemClickCallback

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding as FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMovieBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            val viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            ).get(MainViewModel::class.java)

            val movieAdapter = MovieTvAdapter()
            movieAdapter.setData(viewModel.getListMovie())

            movieAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClicked(data: MovieTvShow) {
                    val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, data.id)
                    startActivity(intent)
                }
            })

            binding.rvMovies.apply {
                layoutManager = GridLayoutManager(it, 3)
                adapter = movieAdapter
            }

        }
    }
}