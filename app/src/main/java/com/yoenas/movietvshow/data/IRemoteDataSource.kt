package com.yoenas.movietvshow.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.vo.Resource

interface IRemoteDataSource {

    fun getNowPlayingMovies(): LiveData<Resource<PagedList<MovieTvShow>>>
    fun getTopRatedTvShows(): LiveData<Resource<PagedList<MovieTvShow>>>

    fun getDetailMovie(id: Int): LiveData<Resource<MovieTvShow>>
    fun getDetailTvShow(id: Int): LiveData<Resource<MovieTvShow>>

    fun setMovieTvAsFavorite(movieTvShow: MovieTvShow, state: Boolean)

    fun getFavoriteMovies(): LiveData<PagedList<MovieTvShow>>
    fun getFavoriteTvShows(): LiveData<PagedList<MovieTvShow>>
}