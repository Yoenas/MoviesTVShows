package com.yoenas.movietvshow.presentation.home.tv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.yoenas.movietvshow.data.model.TvShowsItem
import com.yoenas.movietvshow.databinding.FragmentTvShowBinding
import com.yoenas.movietvshow.presentation.home.HomeViewModel
import com.yoenas.movietvshow.presentation.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding as FragmentTvShowBinding

    private var _homeViewModel: HomeViewModel? = null
    private val homeViewModel get() = _homeViewModel as HomeViewModel

    private val tvAdapter by lazy { TvAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(inflater)

        _homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getListTvShow()
        homeViewModel.tvShows.observe(viewLifecycleOwner, {
            tvAdapter.setData(it)
            Log.i("GetListTvShows", "onViewCreated: $it")
            binding.rvTvShows.apply {
                layoutManager = GridLayoutManager(context, 3)
                adapter = tvAdapter
            }
        })

        tvAdapter.listener = { _: View, item: TvShowsItem, _: Int ->
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, item.id)
            intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.TYPE_TV)
            startActivity(intent)
        }
    }
}