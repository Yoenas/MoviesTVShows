package com.yoenas.movietvshow.presentation.detail

import androidx.lifecycle.ViewModel
import com.yoenas.movietvshow.data.local.DataDummy
import com.yoenas.movietvshow.data.MovieTvShow

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    fun setMovieId(movieId: String){
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String){
        this.tvShowId = tvShowId
    }

    fun getDetailMovieById() : MovieTvShow {
        lateinit var movies: MovieTvShow
        val listMovies = DataDummy.generateDataMoviesDummy()
        for (data in listMovies) {
            if (data.id == movieId) {
                movies = data
                break
            }
        }
        return movies
    }

    fun getDetailTvShowById() : MovieTvShow {
        lateinit var tvShows: MovieTvShow
        val listTvShows = DataDummy.generateDataTvShowsDummy()
        for (data in listTvShows) {
            if (data.id == tvShowId) {
                tvShows = data
                break
            }
        }
        return tvShows
    }
}