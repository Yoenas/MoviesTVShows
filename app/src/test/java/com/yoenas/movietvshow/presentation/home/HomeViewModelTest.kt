package com.yoenas.movietvshow.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.yoenas.movietvshow.data.local.DataDummy
import com.yoenas.movietvshow.data.model.MoviesItem
import com.yoenas.movietvshow.data.model.TvShowsItem
import com.yoenas.movietvshow.data.repository.HomeRepository
import com.yoenas.movietvshow.data.repository.MyDataSource
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Mock
    private lateinit var remote: MyDataSource

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observerMovies: Observer<List<MoviesItem>>

    @Mock
    private lateinit var observerTvShows: Observer<List<TvShowsItem>>

    private val homeRepository: HomeRepository = mock()
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        remote = Mockito.mock(remote.javaClass)
        viewModel = HomeViewModel(homeRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetListMovie() = runBlocking {
        val dummyMovie = DataDummy.generateDataMoviesDummy()
        val movies = MutableLiveData<List<MoviesItem>>()
        movies.value = dummyMovie

        `when`(homeRepository.getNowPlayingMovies()).thenReturn(dummyMovie)
        homeRepository.getNowPlayingMovies()

        val data = viewModel.movies.value
        verify(homeRepository).getNowPlayingMovies()

        assertNotNull(data)
        data?.let {
            assertEquals(1, data.size)
        }

        viewModel.movies.observeForever(observerMovies)
        verify(observerMovies).onChanged(dummyMovie)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetListTvShow() = runBlocking {
        val dummyTvShow = DataDummy.generateDataTvShowsDummy()
        val tvShows = MutableLiveData<List<TvShowsItem>>()
        tvShows.value = dummyTvShow

        `when`(homeRepository.getTopRatedTvShows()).thenReturn(dummyTvShow)
        viewModel.getListTvShow()

        val data = viewModel.tvShows.value
        verify(homeRepository).getTopRatedTvShows()

        assertNotNull(data)
        data?.let {
            assertEquals(1, data.size)
        }

        viewModel.tvShows.observeForever(observerTvShows)
        verify(observerTvShows).onChanged(dummyTvShow)
    }
}