package com.yoenas.movietvshow.presentation.home.tv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.databinding.FragmentTvShowBinding
import com.yoenas.movietvshow.presentation.detail.DetailActivity
import com.yoenas.movietvshow.presentation.home.HomeAdapter
import com.yoenas.movietvshow.presentation.home.HomeViewModel
import com.yoenas.movietvshow.presentation.home.HomeItemClickCallback
import com.yoenas.movietvshow.utils.HelperFunction
import com.yoenas.movietvshow.vo.Resource
import com.yoenas.movietvshow.vo.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : Fragment(), HomeItemClickCallback {

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding as FragmentTvShowBinding

    private var _homeViewModel: HomeViewModel? = null
    private val homeViewModel get() = _homeViewModel as HomeViewModel

    private val homeAdapter by lazy { HomeAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeViewModel.getListTvShow().observe(viewLifecycleOwner, tvShowObserver)
    }

    private val tvShowObserver = Observer<Resource<PagedList<MovieTvShow>>> {
        binding.apply {
            if (it != null) {
                when (it.status) {
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        rvTvShows.visibility = View.GONE
                    }

                    Status.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        Log.i("GetListTvShows", "onViewCreated: $it")
                        with(rvTvShows) {
                            homeAdapter.submitList(it.data)
                            visibility = View.VISIBLE
                            layoutManager = GridLayoutManager(context, 3)
                            adapter = homeAdapter
                        }
                    }

                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                        HelperFunction.showErrorConnectionAlert(activity)
                    }
                }
            }
        }
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