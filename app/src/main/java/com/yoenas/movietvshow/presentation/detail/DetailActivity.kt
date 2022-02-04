package com.yoenas.movietvshow.presentation.detail

import com.yoenas.movietvshow.BuildConfig.IMAGE_BASE_URL
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yoenas.movietvshow.data.model.MoviesItem
import com.yoenas.movietvshow.data.model.TvShowsItem
import com.yoenas.movietvshow.databinding.ActivityDetailBinding
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
                    getDetailMovie(id)
                    movie.observe(this@DetailActivity) {
                        showDetailMovieTvShow(it, null)
                    }
                }

                TYPE_TV -> {
                    getDetailTvShow(id)
                    tvShow.observe(this@DetailActivity) {
                        showDetailMovieTvShow(null, it)
                    }
                }
            }
        }
    }

    private fun showDetailMovieTvShow(movie: MoviesItem?, tvShow: TvShowsItem?) {
        binding.apply {
            if (movie != null && tvShow == null) {
                tvTitleDetail.text = movie.title
                tvReleasedDetail.text = movie.releaseDate
                imgDetail.loadImage(IMAGE_BASE_URL+movie.backdropPath)
                imgPosterDetail.loadImage(IMAGE_BASE_URL+movie.posterPath)

                tvRatingDetail.text = movie.voteAverage.toString()
                val dataGenres = movie.genres
                val genres = arrayListOf<String>()
                for (item in dataGenres) {
                    val genre = item.name
                    if (genre != null) {
                        genres.add(genre)
                    }
                }
                val convGenres = genres.joinToString()
                tvGenreDetail.text = convGenres

                val duration = movie.runtime
                val hour = duration?.div(60)
                val minute = duration?.rem(60)
                val durationFormatted = if (hour == 0) {
                    minute.toString() + "m"
                } else {
                    hour.toString() + "h " + minute.toString() + "m"
                }
                tvDurationDetail.text = durationFormatted
                tvDescDetail.text = movie.overview
            } else if (tvShow != null && movie == null) {
                tvTitleDetail.text = tvShow.name
                tvReleasedDetail.text = tvShow.firstAirDate
                imgDetail.loadImage(IMAGE_BASE_URL+tvShow.backdropPath)
                imgPosterDetail.loadImage(IMAGE_BASE_URL+tvShow.posterPath)

                tvRatingDetail.text = tvShow.voteAverage.toString()
                val dataGenres = tvShow.genres
                val genres = arrayListOf<String>()
                for (item in dataGenres) {
                    val genre = item.name
                    if (genre != null) {
                        genres.add(genre)
                    }
                }
                val convGenres = genres.joinToString()
                tvGenreDetail.text = convGenres

                val duration = tvShow.episodeRunTime[0]
                val hour = duration.div(60)
                val minute = duration.rem(60)
                val durationFormatted = if (hour == 0) {
                    minute.toString() + "m"
                } else {
                    hour.toString() + "h " + minute.toString() + "m"
                }
                tvDurationDetail.text = durationFormatted
                tvDescDetail.text = tvShow.overview
            } else {
                Toast.makeText(applicationContext, "Something wrong with API.", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    private fun ImageView.loadImage(url: String?) {
        Glide.with(this.context)
            .load(url)
            .apply(RequestOptions().override(500, 500))
            .centerCrop()
            .into(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val EXTRA_DATA = "data"
        const val EXTRA_TYPE = "type"

        const val TYPE_MOVIE = "movie"
        const val TYPE_TV = "tv"
    }
}