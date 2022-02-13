package com.yoenas.movietvshow.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yoenas.movietvshow.data.remote.response.MoviesItem
import com.yoenas.movietvshow.data.remote.response.TvShowsItem
import com.yoenas.movietvshow.network.ApiConfig
import com.yoenas.movietvshow.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiConfig: ApiConfig) {

    fun getNowPlayingMovies(): LiveData<ApiResponse<List<MoviesItem>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MoviesItem>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiConfig.getApiService().getNowPlayingMovies().await()
                resultMovies.postValue(ApiResponse.success(response.results))
            } catch (e: IOException) {
                e.printStackTrace()
                resultMovies.postValue(ApiResponse.error(e.message.toString(), mutableListOf()))
            }
        }
        EspressoIdlingResource.decrement()
        return resultMovies
    }

    fun getTopRatedTvShows(): LiveData<ApiResponse<List<TvShowsItem>>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowsItem>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiConfig.getApiService().getTopRatedTvShows().await()
                resultTvShows.postValue(ApiResponse.success(response.results))
            } catch (e: IOException) {
                e.printStackTrace()
                resultTvShows.postValue(ApiResponse.error(e.message.toString(), mutableListOf()))
            }
        }
        EspressoIdlingResource.decrement()
        return resultTvShows
    }

    fun getDetailMovie(id: Int): LiveData<ApiResponse<MoviesItem>> {
        EspressoIdlingResource.increment()
        val resultDetailMovie = MutableLiveData<ApiResponse<MoviesItem>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiConfig.getApiService().getDetailMovie(id).await()
                resultDetailMovie.postValue(ApiResponse.success(response))
            } catch (e: IOException) {
                e.printStackTrace()
                resultDetailMovie.postValue(ApiResponse.error(e.message.toString(), MoviesItem()))
            }
        }
        EspressoIdlingResource.decrement()
        return resultDetailMovie
    }

    fun getTvDetailTvShow(id: Int): LiveData<ApiResponse<TvShowsItem>> {
        EspressoIdlingResource.increment()
        val resultDetailTvShow = MutableLiveData<ApiResponse<TvShowsItem>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiConfig.getApiService().getDetailTvShow(id).await()
                resultDetailTvShow.postValue(ApiResponse.success(response))
            } catch (e: IOException) {
                e.printStackTrace()
                resultDetailTvShow.postValue(ApiResponse.error(e.message.toString(), TvShowsItem()))
            }
        }
        EspressoIdlingResource.decrement()
        return resultDetailTvShow
    }
}

