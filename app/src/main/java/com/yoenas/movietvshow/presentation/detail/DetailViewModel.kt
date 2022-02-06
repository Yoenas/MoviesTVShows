package com.yoenas.movietvshow.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.repository.MovieTvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val movieTvShowRepository: MovieTvShowRepository) :
    ViewModel() {

    fun getDetailMovie(id: Int): LiveData<MovieTvShow> = movieTvShowRepository.getDetailMovie(id)
    fun getDetailTvShow(id: Int): LiveData<MovieTvShow> = movieTvShowRepository.getDetailTvShow(id)
}