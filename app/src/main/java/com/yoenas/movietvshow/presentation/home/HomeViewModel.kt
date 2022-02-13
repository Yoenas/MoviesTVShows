package com.yoenas.movietvshow.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.MovieTvShowRepository
import com.yoenas.movietvshow.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieTvShowRepository: MovieTvShowRepository) :
    ViewModel() {

    fun getListMovie(): LiveData<Resource<PagedList<MovieTvShow>>> = movieTvShowRepository.getNowPlayingMovies()
    fun getListTvShow(): LiveData<Resource<PagedList<MovieTvShow>>> = movieTvShowRepository.getTopRatedTvShows()

}