package com.yoenas.movietvshow.data.repository

class FakeHomeRepository constructor(private val dataSource: MyDataSource) {

    suspend fun getNowPlayingMovies() = dataSource.getNowPlayingMovies()
    suspend fun getTopRatedTvShows() = dataSource.getTopRatedTvShows()

}