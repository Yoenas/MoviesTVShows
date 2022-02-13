package com.yoenas.movietvshow.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.MovieTvShowRepository
import com.yoenas.movietvshow.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val movieTvShowRepository: MovieTvShowRepository) :
    ViewModel() {

    private val movieId = MutableLiveData<Int>()
    private val tvShowId = MutableLiveData<Int>()

    fun getDetailMovie(id: Int): LiveData<Resource<MovieTvShow>> = movieTvShowRepository.getDetailMovie(id)
    fun getDetailTvShow(id: Int): LiveData<Resource<MovieTvShow>> = movieTvShowRepository.getDetailTvShow(id)

    fun setSelectedMovie(id: Int) {
        this.movieId.value = id
    }

    fun setSelectedTvShow(id: Int) {
        this.tvShowId.value = id
    }

    var movieDetail: LiveData<Resource<MovieTvShow>> =
        Transformations.switchMap(movieId) {
            movieTvShowRepository.getDetailMovie(it)
        }

    var tvShowDetail: LiveData<Resource<MovieTvShow>> =
        Transformations.switchMap(tvShowId) {
            movieTvShowRepository.getDetailTvShow(it)
        }

    fun setAsFavoriteMovie() {
        val movieResource = movieDetail.value?.data
        if (movieResource != null) {
            val newState = !movieResource.isFavorite
            movieTvShowRepository.setMovieTvAsFavorite(movieResource, newState)
        }
    }

    fun setAsFavoriteTvShow() {
        val tvShowResource = tvShowDetail.value?.data
        if (tvShowResource != null) {
            val newState = !tvShowResource.isFavorite
            movieTvShowRepository.setMovieTvAsFavorite(tvShowResource, newState)
        }
    }
}