package com.yoenas.movietvshow.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.MovieTvShowRepository
import com.yoenas.movietvshow.vo.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel

    @Mock
    private lateinit var movieTvShowRepository: MovieTvShowRepository

    @Mock
    private lateinit var observerMovies: Observer<Resource<PagedList<MovieTvShow>>>

    @Mock
    private lateinit var observerTvShows: Observer<Resource<PagedList<MovieTvShow>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieTvShow>

    @Before
    fun setup() {
        viewModel = HomeViewModel(movieTvShowRepository)
    }

    @Test
    fun testGetListMovie() {
        val dummyMovie = Resource.success(pagedList)
        `when`(dummyMovie.data?.size).thenReturn(20)
        val movies = MutableLiveData<Resource<PagedList<MovieTvShow>>>()
        movies.value = dummyMovie

        `when`(movieTvShowRepository.getNowPlayingMovies()).thenReturn(movies)

        val data = viewModel.getListMovie().value?.data
        verify(movieTvShowRepository).getNowPlayingMovies()

        assertNotNull(data)
        data?.let {
            assertEquals(20, data.size)
        }

        viewModel.getListMovie().observeForever(observerMovies)
        verify(observerMovies).onChanged(dummyMovie)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetListTvShow() {
        val dummyTvShow = Resource.success(pagedList)
        `when`(dummyTvShow.data?.size).thenReturn(20)
        val tvShows = MutableLiveData<Resource<PagedList<MovieTvShow>>>()
        tvShows.value = dummyTvShow

        `when`(movieTvShowRepository.getTopRatedTvShows()).thenReturn(tvShows)

        val data = viewModel.getListTvShow().value?.data
        verify(movieTvShowRepository).getTopRatedTvShows()

        assertNotNull(data)
        data?.let {
            assertEquals(20, data.size)
        }

        viewModel.getListTvShow().observeForever(observerTvShows)
        verify(observerTvShows).onChanged(dummyTvShow)
    }
}
