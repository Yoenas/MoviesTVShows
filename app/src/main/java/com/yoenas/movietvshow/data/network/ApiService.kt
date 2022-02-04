package com.yoenas.movietvshow.data.network

import com.yoenas.movietvshow.BuildConfig.API_KEY
import com.yoenas.movietvshow.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("api_key") apiKey: String = API_KEY): MyResponse<MoviesItem>

    @GET("movie/{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ) : MoviesItem

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShows(@Query("api_key") apiKey: String = API_KEY): MyResponse<TvShowsItem>

    @GET("tv/{tv_id}")
    suspend fun getDetailTvShow(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ) : TvShowsItem
}