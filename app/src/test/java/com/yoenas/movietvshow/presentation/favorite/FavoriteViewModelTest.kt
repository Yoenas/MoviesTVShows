package com.yoenas.movietvshow.presentation.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.MovieTvShowRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieTvShowRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieTvShow>>

    @Mock
    private lateinit var pagedList: PagedList<MovieTvShow>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(movieRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(2)
        val movie = MutableLiveData<PagedList<MovieTvShow>>()
        movie.value = dummyMovies

        `when`(movieRepository.getFavoriteMovies()).thenReturn(movie)
        val movieEntities = viewModel.getFavoriteMovies().value
        verify(movieRepository).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(2, movieEntities?.size)

        viewModel.getFavoriteMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getFavoriteTvShow() {
        val dummyTvShow = pagedList
        `when`(dummyTvShow.size).thenReturn(2)
        val tvShow = MutableLiveData<PagedList<MovieTvShow>>()
        tvShow.value = dummyTvShow

        `when`(movieRepository.getFavoriteTvShows()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getFavoriteTvShows().value
        verify(movieRepository).getFavoriteTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(2, tvShowEntities?.size)

        viewModel.getFavoriteTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}