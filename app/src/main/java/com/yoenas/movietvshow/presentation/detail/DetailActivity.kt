package com.yoenas.movietvshow.presentation.detail

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yoenas.movietvshow.BuildConfig.IMAGE_BASE_URL
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.databinding.ActivityDetailBinding
import com.yoenas.movietvshow.utils.ExtFunction.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    private var _viewModel: DetailViewModel? = null
    private val viewModel get() = _viewModel as DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getIntExtra(EXTRA_DATA, 0)
        val type = intent.getStringExtra(EXTRA_TYPE)

        binding.collapseToolbarDetail.setExpandedTitleColor(Color.TRANSPARENT)

        _viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        viewModel.apply {
            when (type) {
                TYPE_MOVIE -> {
                    getDetailMovie(id).observe(this@DetailActivity) {
                        showDetailMovieTvShow(it)
                    }
                }

                TYPE_TV -> {
                    getDetailTvShow(id).observe(this@DetailActivity) {
                        showDetailMovieTvShow(it)
                    }
                }
            }
        }
    }

    private fun showDetailMovieTvShow(data: MovieTvShow?) {
        binding.apply {
            if (data != null) {
                tvTitleDetail.text = data.title
                tvReleasedDetail.text = data.releaseDate
                imgDetail.loadImage(IMAGE_BASE_URL + data.backdropPath)
                imgPosterDetail.loadImage(IMAGE_BASE_URL + data.posterPath)

                tvRatingDetail.text = data.voteAverage.toString()
                val dataGenres = data.genres
                val genres = arrayListOf<String>()
                if (dataGenres != null) {
                    for (item in dataGenres) {
                        val genre = item.name
                        genres.add(genre)
                    }
                }
                val convGenres = genres.joinToString()
                tvGenreDetail.text = convGenres

                val duration = data.runtime
                val hour = duration?.div(60)
                val minute = duration?.rem(60)
                val durationFormatted = if (hour == 0) {
                    minute.toString() + "m"
                } else {
                    hour.toString() + "h " + minute.toString() + "m"
                }
                tvDurationDetail.text = durationFormatted
                tvDescDetail.text = data.overview
            } else {
                Toast.makeText(applicationContext, "Something wrong try later.", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val EXTRA_DATA = "data"
        const val EXTRA_TYPE = "type"

        const val TYPE_MOVIE = "movie"
        const val TYPE_TV = "tv"
    }
}