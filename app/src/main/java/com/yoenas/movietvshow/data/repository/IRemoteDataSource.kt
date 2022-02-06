package com.yoenas.movietvshow.data.repository

import androidx.lifecycle.LiveData
import com.yoenas.movietvshow.data.model.MovieTvShow

interface IRemoteDataSource {

    fun getNowPlayingMovies(): LiveData<List<MovieTvShow>>
    fun getTopRatedTvShows(): LiveData<List<MovieTvShow>>

    fun getDetailMovie(id: Int): LiveData<MovieTvShow>
    fun getDetailTvShow(id: Int): LiveData<MovieTvShow>
}