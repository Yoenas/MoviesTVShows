package com.yoenas.movietvshow.data.repository

import javax.inject.Inject

class HomeRepository @Inject constructor(private val dataSource: MyDataSource) {

    suspend fun getNowPlayingMovies() = dataSource.getNowPlayingMovies()
    suspend fun getTopRatedTvShows() = dataSource.getTopRatedTvShows()

}
