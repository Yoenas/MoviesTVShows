package com.yoenas.movietvshow.presentation.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.MovieTvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val movieTvShowRepository: MovieTvShowRepository) :
    ViewModel() {

    fun getFavoriteMovies(): LiveData<PagedList<MovieTvShow>> = movieTvShowRepository.getFavoriteMovies()
    fun getFavoriteTvShows(): LiveData<PagedList<MovieTvShow>> = movieTvShowRepository.getFavoriteTvShows()

    fun setFavorite(movieTvShow: MovieTvShow) {
        val newState = !movieTvShow.isFavorite
        movieTvShowRepository.setMovieTvAsFavorite(movieTvShow, newState)
    }
}