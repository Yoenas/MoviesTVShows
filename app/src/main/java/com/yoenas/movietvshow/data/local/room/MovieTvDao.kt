package com.yoenas.movietvshow.data.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.yoenas.movietvshow.data.model.MovieTvShow

@Dao
interface MovieTvDao {

    @Query("SELECT * FROM movietv_table WHERE isTvShow = 0")
    fun getListMovies(): DataSource.Factory<Int, MovieTvShow>

    @Query("SELECT * FROM movietv_table WHERE isTvShow = 1")
    fun getListTvShows(): DataSource.Factory<Int, MovieTvShow>

    @Transaction
    @Query("SELECT * FROM movietv_table WHERE movieTvId = :movieId")
    fun getMovieById(movieId: Int): LiveData<MovieTvShow>

    @Transaction
    @Query("SELECT * FROM movietv_table WHERE movieTvId = :tvShowId")
    fun getTvShowById(tvShowId: Int): LiveData<MovieTvShow>

    @Insert(entity = MovieTvShow::class, onConflict = OnConflictStrategy.REPLACE)
    fun addToFavorite(listMovieTvShow: List<MovieTvShow>)

    @Update(entity = MovieTvShow::class)
    fun updateMovieTvShow(movieTvShow: MovieTvShow)

    @Query("UPDATE movietv_table SET genres = :genres, runtime = :runtime WHERE movieTvId = :movieTvId")
    fun updateMovieTvShowById(genres: String, runtime: Int, movieTvId: Int)

    @Query("SELECT * FROM movietv_table WHERE isFavorite = 1 AND isTvShow = 0")
    fun getFavoriteMovies(): DataSource.Factory<Int, MovieTvShow>

    @Query("SELECT * FROM movietv_table WHERE isFavorite = 1 AND isTvShow = 1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, MovieTvShow>
}