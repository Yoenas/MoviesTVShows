package com.yoenas.movietvshow.network

import com.yoenas.movietvshow.BuildConfig.API_KEY
import com.yoenas.movietvshow.data.model.MyResponse
import com.yoenas.movietvshow.data.remote.response.MoviesItem
import com.yoenas.movietvshow.data.remote.response.TvShowsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/now_playing")
    fun getNowPlayingMovies(@Query("api_key") apiKey: String = API_KEY): Call<MyResponse<MoviesItem>>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): Call<MoviesItem>

    @GET("tv/top_rated")
    fun getTopRatedTvShows(@Query("api_key") apiKey: String = API_KEY): Call<MyResponse<TvShowsItem>>

    @GET("tv/{tv_id}")
    fun getDetailTvShow(
        @Path("tv_id") tvId: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): Call<TvShowsItem>
}