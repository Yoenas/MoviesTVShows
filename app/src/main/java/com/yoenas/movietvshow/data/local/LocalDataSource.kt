package com.yoenas.movietvshow.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.yoenas.movietvshow.data.local.room.MovieTvDao
import com.yoenas.movietvshow.data.model.MovieTvShow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: MovieTvDao) {

    fun getListMovies(): DataSource.Factory<Int, MovieTvShow> = dao.getListMovies()
    fun getListTvShows(): DataSource.Factory<Int, MovieTvShow> = dao.getListTvShows()

    fun addMoviesTvShows(moviesTvShows: List<MovieTvShow>) = dao.addToFavorite(moviesTvShows)

    fun getDetailMovie(id: Int): LiveData<MovieTvShow> = dao.getMovieById(id)
    fun getDetailTvShow(id: Int): LiveData<MovieTvShow> = dao.getTvShowById(id)

    fun updateMovieTvShowById(genres: String, runtime: Int, movieTvId: Int) = dao.updateMovieTvShowById(genres, runtime, movieTvId)

    fun setMovieTvAsFavorite(movieTvShow: MovieTvShow, state: Boolean) {
        movieTvShow.isFavorite = state
        dao.updateMovieTvShow(movieTvShow)
    }

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieTvShow> = dao.getFavoriteMovies()

    fun getFavoriteTvShows(): DataSource.Factory<Int, MovieTvShow> = dao.getFavoriteTvShows()
}