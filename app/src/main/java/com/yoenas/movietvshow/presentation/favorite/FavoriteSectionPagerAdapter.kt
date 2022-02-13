package com.yoenas.movietvshow.presentation.favorite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yoenas.movietvshow.presentation.favorite.movie.MovieFavoriteFragment
import com.yoenas.movietvshow.presentation.favorite.tv.TvShowFavoriteFragment

class FavoriteSectionPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MovieFavoriteFragment()
            1 -> TvShowFavoriteFragment()
            else -> MovieFavoriteFragment()
        }
    }
}