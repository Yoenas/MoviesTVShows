package com.yoenas.movietvshow.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoenas.movietvshow.data.model.MoviesItem
import com.yoenas.movietvshow.data.model.TvShowsItem
import com.yoenas.movietvshow.data.repository.HomeRepository
import com.yoenas.movietvshow.utils.EspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {

    private var _movies = MutableLiveData<List<MoviesItem>>()
    val movies: LiveData<List<MoviesItem>> = _movies

    private var _tvShows = MutableLiveData<List<TvShowsItem>>()
    val tvShows: LiveData<List<TvShowsItem>> = _tvShows

    fun getListMovie() = viewModelScope.launch {
        EspressoIdlingResource.increment()
        _movies.postValue(homeRepository.getNowPlayingMovies())
        EspressoIdlingResource.decrement()
    }

    fun getListTvShow() = viewModelScope.launch {
        EspressoIdlingResource.increment()
        _tvShows.postValue(homeRepository.getTopRatedTvShows())
        EspressoIdlingResource.decrement()
    }
}