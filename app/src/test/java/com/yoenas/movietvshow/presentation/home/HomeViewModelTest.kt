package com.yoenas.movietvshow.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.yoenas.movietvshow.data.local.DataDummy
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.repository.MovieTvShowRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel

    @Mock
    private lateinit var movieTvShowRepository: MovieTvShowRepository

    @Mock
    private lateinit var observerMovies: Observer<List<MovieTvShow>>

    @Mock
    private lateinit var observerTvShows: Observer<List<MovieTvShow>>

    @Before
    fun setup() {
        viewModel = HomeViewModel(movieTvShowRepository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetListMovie() = runBlocking {
        val dummyMovie = DataDummy.generateDataMoviesDummy()
        val movies = MutableLiveData<List<MovieTvShow>>()
        movies.value = dummyMovie

        `when`(movieTvShowRepository.getNowPlayingMovies()).thenReturn(movies)

        val data = viewModel.getListMovie().value
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
    fun testGetListTvShow() = runBlocking {
        val dummyTvShow = DataDummy.generateDataTvShowsDummy()
        val tvShows = MutableLiveData<List<MovieTvShow>>()
        tvShows.value = dummyTvShow

        `when`(movieTvShowRepository.getTopRatedTvShows()).thenReturn(tvShows)

        val data = viewModel.getListTvShow().value
        verify(movieTvShowRepository).getTopRatedTvShows()

        assertNotNull(data)
        data?.let {
            assertEquals(20, data.size)
        }

        viewModel.getListTvShow().observeForever(observerTvShows)
        verify(observerTvShows).onChanged(dummyTvShow)
    }
}
