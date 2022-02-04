package com.yoenas.movietvshow.data.repository

import javax.inject.Inject

class DetailRepository @Inject constructor(private val dataSource: MyDataSource) {

    suspend fun getDetailMovie(id: Int) = dataSource.getDetailMovie(id)
    suspend fun getDetailTvShow(id: Int) = dataSource.getDetailTvShow(id)

}