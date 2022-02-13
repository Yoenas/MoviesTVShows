package com.yoenas.movietvshow.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.yoenas.movietvshow.R
import com.yoenas.movietvshow.databinding.ActivityMainBinding
import com.yoenas.movietvshow.presentation.favorite.FavoriteActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            vpMain.adapter = MainSectionPagerAdapter(this@MainActivity)

            val tabList = arrayOf(getString(R.string.txt_movies), getString(R.string.txt_tv_shows))
            TabLayoutMediator(tabs, vpMain) { tabs, position ->
                tabs.text = tabList[position]
            }.attach()

            btnNavFavorite.setOnClickListener {
                startActivity(Intent(this@MainActivity, FavoriteActivity::class.java))
            }
        }
    }
}