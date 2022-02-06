package com.yoenas.movietvshow.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yoenas.movietvshow.presentation.home.movie.MovieFragment
import com.yoenas.movietvshow.presentation.home.tv.TvShowFragment

class MainSectionPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MovieFragment()
            1 -> TvShowFragment()
            else -> MovieFragment()
        }
    }
}