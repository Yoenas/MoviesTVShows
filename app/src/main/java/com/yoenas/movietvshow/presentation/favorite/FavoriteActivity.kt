package com.yoenas.movietvshow.presentation.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.yoenas.movietvshow.R
import com.yoenas.movietvshow.databinding.ActivityFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {

    private var _binding: ActivityFavoriteBinding? = null
    private val binding get() = _binding as ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            vpFavorite.adapter = FavoriteSectionPagerAdapter(this@FavoriteActivity)

            val tabList = arrayOf(getString(R.string.txt_movies), getString(R.string.txt_tv_shows))
            TabLayoutMediator(tabsFavorite, vpFavorite) { tabs, position ->
                tabs.text = tabList[position]
            }.attach()

            btnNavHome.setOnClickListener { finish() }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}