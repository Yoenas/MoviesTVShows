package com.yoenas.movietvshow.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.yoenas.movietvshow.data.local.DataDummy
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.repository.MovieTvShowRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
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
class DetailViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailViewModel

    @Mock
    private lateinit var movieTvShowRepository: MovieTvShowRepository

    @Mock
    private lateinit var observerMovie: Observer<MovieTvShow>

    @Mock
    private lateinit var observerTvShow: Observer<MovieTvShow>


    @Before
    fun setup() {
        viewModel = DetailViewModel(movieTvShowRepository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getDetailMovieById() = runBlockingTest {
        val dummyMovie = DataDummy.generateDataMoviesDummy()[0]
        val movieId = dummyMovie.id

        val movie = MutableLiveData<MovieTvShow>()
        movie.value = dummyMovie

        `when`(movieTvShowRepository.getDetailMovie(movieId)).thenReturn(movie)

        val data = viewModel.getDetailMovie(movieId).value as MovieTvShow
        assertNotNull(data)

        assertEquals(dummyMovie.id, data.id)
        assertEquals(dummyMovie.title, data.title)
        assertEquals(dummyMovie.releaseDate, data.releaseDate)
        assertEquals(dummyMovie.genres, data.genres)
        assertEquals(dummyMovie.runtime, data.runtime)
        assertEquals(dummyMovie.voteAverage, data.voteAverage, 0.0)
        assertEquals(dummyMovie.overview, data.overview)
        assertEquals(dummyMovie.posterPath, data.posterPath)
        assertEquals(dummyMovie.backdropPath, data.backdropPath)

        viewModel.getDetailMovie(movieId).observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getDetailTvShowById() = runBlockingTest {
        val dummyTvShow = DataDummy.generateDataTvShowsDummy()[0]
        val tvShowId = dummyTvShow.id

        val movie = MutableLiveData<MovieTvShow>()
        movie.value = dummyTvShow

        `when`(movieTvShowRepository.getDetailTvShow(tvShowId)).thenReturn(movie)

        val data = viewModel.getDetailTvShow(tvShowId).value as MovieTvShow
        assertNotNull(data)

        assertEquals(dummyTvShow.id, data.id)
        assertEquals(dummyTvShow.title, data.title)
        assertEquals(dummyTvShow.releaseDate, data.releaseDate)
        assertEquals(dummyTvShow.genres, data.genres)
        assertEquals(dummyTvShow.runtime, data.runtime)
        assertEquals(dummyTvShow.voteAverage, data.voteAverage, 0.0)
        assertEquals(dummyTvShow.overview, data.overview)
        assertEquals(dummyTvShow.posterPath, data.posterPath)
        assertEquals(dummyTvShow.backdropPath, data.backdropPath)

        viewModel.getDetailTvShow(tvShowId).observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)

    }
}
