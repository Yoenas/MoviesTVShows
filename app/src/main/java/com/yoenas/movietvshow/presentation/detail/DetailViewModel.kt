package com.yoenas.movietvshow.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoenas.movietvshow.data.model.MoviesItem
import com.yoenas.movietvshow.data.model.TvShowsItem
import com.yoenas.movietvshow.data.repository.DetailRepository
import com.yoenas.movietvshow.utils.EspressoIdlingResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val detailRepository: DetailRepository) :
    ViewModel() {

    private var _movie = MutableLiveData<MoviesItem>()
    val movie: LiveData<MoviesItem> = _movie

    private var _tvShow = MutableLiveData<TvShowsItem>()
    val tvShow: LiveData<TvShowsItem> = _tvShow

    fun getDetailMovie(id: Int) = viewModelScope.launch {
        EspressoIdlingResource.increment()
        _movie.postValue(detailRepository.getDetailMovie(id))
        EspressoIdlingResource.decrement()
    }

    fun getDetailTvShow(id: Int) = viewModelScope.launch {
        EspressoIdlingResource.increment()
        _tvShow.postValue(detailRepository.getDetailTvShow(id))
        EspressoIdlingResource.decrement()
    }

}