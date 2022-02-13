package com.yoenas.movietvshow.presentation.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yoenas.movietvshow.BuildConfig.IMAGE_BASE_URL
import com.yoenas.movietvshow.R
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.databinding.ActivityDetailBinding
import com.yoenas.movietvshow.utils.loadImage
import com.yoenas.movietvshow.vo.Resource
import com.yoenas.movietvshow.vo.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    private var _viewModel: DetailViewModel? = null
    private val viewModel get() = _viewModel as DetailViewModel

    private var movie: Resource<MovieTvShow>? = null
    private var tvShow: Resource<MovieTvShow>? = null

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
                    setSelectedMovie(id)
                    movieDetail.observe(this@DetailActivity) {
                        movie = it
                        showDetailMovieTvShow(it)
                    }
                }

                TYPE_TV -> {
                    setSelectedTvShow(id)
                    tvShowDetail.observe(this@DetailActivity) {
                        tvShow = it
                        showDetailMovieTvShow(it)
                    }
                }
            }
        }

        binding.fabFavorite.setOnClickListener {
            when (type) {
                TYPE_MOVIE -> setFavoriteMovie()
                TYPE_TV -> setFavoriteTvShow()
            }
        }
    }

    private fun setFavoriteTvShow() {
        if (tvShow?.data?.isFavorite == false) {
            viewModel.setAsFavoriteTvShow()
            Toast.makeText(this, "Add to Favorite.", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.setAsFavoriteTvShow()
            Toast.makeText(this, "Remove from Favorite", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setFavoriteMovie() {
        if (movie?.data?.isFavorite == false) {
            viewModel.setAsFavoriteMovie()
            Toast.makeText(this, "Add to Favorite.", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.setAsFavoriteMovie()
            Toast.makeText(this, "Remove from Favorite.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDetailMovieTvShow(data: Resource<MovieTvShow>?) {
        binding.apply {
            data?.let {
                when (data.status) {
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        appBarDetail.visibility = View.INVISIBLE
                        layoutDetail.visibility = View.INVISIBLE
                        fabFavorite.visibility = View.INVISIBLE
                    }
                    Status.SUCCESS -> {
                        loadData(data.data)
                        val state = data.data?.isFavorite
                        setFavoriteIcon(state)
                        progressBar.visibility = View.GONE
                        appBarDetail.visibility = View.VISIBLE
                        layoutDetail.visibility = View.VISIBLE
                        fabFavorite.visibility = View.VISIBLE
                    }
                    Status.ERROR -> {
                        progressBar.visibility = View.GONE
                        Toast.makeText(
                            applicationContext,
                            "Something wrong here, we try to fix it.",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    }
                }
            }
        }
    }

    private fun setFavoriteIcon(state: Boolean?) {
        binding.apply {
            if (state == true) {
                fabFavorite.loadImage(R.drawable.ic_favorite)
            } else {
                fabFavorite.loadImage(R.drawable.ic_favorite_border)
            }
        }
    }

    private fun loadData(data: MovieTvShow?) {
        binding.apply {
            data?.let {
                tvTitleDetail.text = data.title
                tvReleasedDetail.text = data.releaseDate
                imgDetail.loadImage(IMAGE_BASE_URL + data.backdropPath)
                imgPosterDetail.loadImage(IMAGE_BASE_URL + data.posterPath)

                tvRatingDetail.text = data.voteAverage.toString()
                tvGenreDetail.text = data.genres

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