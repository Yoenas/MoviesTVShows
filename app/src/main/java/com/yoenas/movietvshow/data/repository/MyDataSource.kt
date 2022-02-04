package com.yoenas.movietvshow.data.repository

import com.yoenas.movietvshow.data.network.ApiService
import javax.inject.Inject

class MyDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getNowPlayingMovies() = apiService.getNowPlayingMovies().results
    suspend fun getTopRatedTvShows() = apiService.getTopRatedTvShows().results

    suspend fun getDetailMovie(id: Int) = apiService.getDetailMovie(id)
    suspend fun getDetailTvShow(id: Int) = apiService.getDetailTvShow(id)

}