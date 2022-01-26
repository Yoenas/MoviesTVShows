package com.yoenas.movietvshow.presentation.home

import androidx.lifecycle.ViewModel
import com.yoenas.movietvshow.data.local.DataDummy
import com.yoenas.movietvshow.data.MovieTvShow

class MainViewModel : ViewModel() {

    fun getListMovie(): List<MovieTvShow> = DataDummy.generateDataMoviesDummy()

    fun getListTvShow(): List<MovieTvShow> = DataDummy.generateDataTvShowsDummy()

}