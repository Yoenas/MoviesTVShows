package com.yoenas.movietvshow.presentation.detail

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yoenas.movietvshow.R
import com.yoenas.movietvshow.data.MovieTvShow
import com.yoenas.movietvshow.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    private var data: MovieTvShow? = null
    private var viewModel: DetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.collapseToolbarDetail.setExpandedTitleColor(Color.TRANSPARENT)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(DetailViewModel::class.java)

        val id = intent.getStringExtra(EXTRA_DATA)

        viewModel?.apply {
            when {
                id?.startsWith('m', false) == true -> {
                    setMovieId(id)
                    data = getDetailMovieById()
                }

                id?.startsWith('t', false) == true -> {
                    setTvShowId(id)
                    data = getDetailTvShowById()
                }
            }
        }
        showDetailMovieTvShow()
    }

    private fun showDetailMovieTvShow() {
        binding.apply {
            imgDetail.loadImage(data?.poster)
            imgPosterDetail.loadImage(data?.poster)

            tvTitleDetail.text = data?.title
            tvRatingDetail.text = data?.rating
            tvReleasedDetail.text = data?.released
            tvGenreDetail.text = data?.genre
            tvDurationDetail.text = data?.duration
            tvDescDetail.text = data?.desc
        }
    }

    fun ImageView.loadImage(url: String?) {
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
    }
}