package com.yoenas.movietvshow.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.MovieTvShowRepository
import com.yoenas.movietvshow.utils.DataDummy
import com.yoenas.movietvshow.vo.Resource
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
class DetailViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDataMoviesDummy()[0]
    private val movieId = dummyMovie.movieTvId!!
    private val dummyTvShow = DataDummy.generateDataTvShowsDummy()[0]
    private val tvShowId = dummyTvShow.movieTvId!!

    @Mock
    private lateinit var movieTvShowRepository: MovieTvShowRepository

    @Mock
    private lateinit var observerMovie: Observer<Resource<MovieTvShow>>

    @Mock
    private lateinit var observerTvShow: Observer<Resource<MovieTvShow>>


    @Before
    fun setup() {
        viewModel = DetailViewModel(movieTvShowRepository)
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getDetailMovieById() {
        val dataMovie = Resource.success(dummyMovie)
        val movie = MutableLiveData<Resource<MovieTvShow>>()
        movie.value = dataMovie

        `when`(movieTvShowRepository.getDetailMovie(movieId)).thenReturn(movie)

        val data = viewModel.getDetailMovie(movieId).value?.data as MovieTvShow
        assertNotNull(data)

        assertEquals(dummyMovie.id, data.id)
        assertEquals(dummyMovie.movieTvId, data.movieTvId)
        assertEquals(dummyMovie.title, data.title)
        assertEquals(dummyMovie.releaseDate, data.releaseDate)
        assertEquals(dummyMovie.genres, data.genres)
        assertEquals(dummyMovie.runtime, data.runtime)
        dummyMovie.voteAverage?.let { data.voteAverage?.let { it1 -> assertEquals(it, it1, 0.0) } }
        assertEquals(dummyMovie.overview, data.overview)
        assertEquals(dummyMovie.posterPath, data.posterPath)
        assertEquals(dummyMovie.backdropPath, data.backdropPath)

        viewModel.movieDetail.observeForever(observerMovie)
        verify(observerMovie).onChanged(dataMovie)
    }

    @Test
    fun getDetailTvShowById() {
        val dataTvShow = Resource.success(dummyTvShow)
        val movie = MutableLiveData<Resource<MovieTvShow>>()
        movie.value = dataTvShow

        `when`(movieTvShowRepository.getDetailTvShow(tvShowId)).thenReturn(movie)

        val data = viewModel.getDetailTvShow(tvShowId).value?.data as MovieTvShow
        assertNotNull(data)

        assertEquals(dummyTvShow.id, data.id)
        assertEquals(dummyTvShow.movieTvId, data.movieTvId)
        assertEquals(dummyTvShow.title, data.title)
        assertEquals(dummyTvShow.releaseDate, data.releaseDate)
        assertEquals(dummyTvShow.genres, data.genres)
        assertEquals(dummyTvShow.runtime, data.runtime)
        data.voteAverage?.let { dummyTvShow.voteAverage?.let { it1 -> assertEquals(it1, it, 0.0) } }
        assertEquals(dummyTvShow.overview, data.overview)
        assertEquals(dummyTvShow.posterPath, data.posterPath)
        assertEquals(dummyTvShow.backdropPath, data.backdropPath)

        viewModel.tvShowDetail.observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dataTvShow)
    }
}
