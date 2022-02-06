package com.yoenas.movietvshow.data.remote

import com.yoenas.movietvshow.data.remote.response.MoviesItem
import com.yoenas.movietvshow.data.remote.response.TvShowsItem
import com.yoenas.movietvshow.network.ApiConfig
import com.yoenas.movietvshow.utils.EspressoIdlingResource
import retrofit2.await
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiConfig: ApiConfig) {

    suspend fun getNowPlayingMovies(callback: LoadMovieCallback) {
        EspressoIdlingResource.increment()
        apiConfig.getApiService().getNowPlayingMovies().await().results.let {
            callback.onAllMoviesReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTopRatedTvShows(callback: LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        apiConfig.getApiService().getTopRatedTvShows().await().results.let {
            callback.onAllTvShowsReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getDetailMovie(id: Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        apiConfig.getApiService().getDetailMovie(id).await().let {
            callback.onDetailMovieReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvDetailTvShow(id: Int, callback: LoadDetailTvShowCallback) {
        EspressoIdlingResource.increment()
        apiConfig.getApiService().getDetailTvShow(id).await().let {
            callback.onDetailTvShowReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    interface LoadMovieCallback {
        fun onAllMoviesReceived(moviesItem: List<MoviesItem>?)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowsReceived(tvShowsItem: List<TvShowsItem>?)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(movieItem: MoviesItem)
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowReceived(tvShowItem: TvShowsItem)
    }
}

