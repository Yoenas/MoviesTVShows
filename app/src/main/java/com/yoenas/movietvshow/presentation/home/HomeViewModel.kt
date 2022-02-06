package com.yoenas.movietvshow.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.repository.MovieTvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieTvShowRepository: MovieTvShowRepository) :
    ViewModel() {

    fun getListMovie(): LiveData<List<MovieTvShow>> = movieTvShowRepository.getNowPlayingMovies()
    fun getListTvShow(): LiveData<List<MovieTvShow>> = movieTvShowRepository.getTopRatedTvShows()

}