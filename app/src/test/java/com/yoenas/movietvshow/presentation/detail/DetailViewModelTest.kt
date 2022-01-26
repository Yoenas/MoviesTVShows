package com.yoenas.movietvshow.presentation.detail

import com.yoenas.movietvshow.data.local.DataDummy
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDataMoviesDummy()[0]
    private val movieId = dummyMovie.id
    private val dummyTvShow = DataDummy.generateDataTvShowsDummy()[0]
    private val tvShowId = dummyTvShow.id

    @Before
    fun setup() {
        viewModel = DetailViewModel()
        viewModel.setMovieId(movieId)
        viewModel.setTvShowId(tvShowId)
    }

    @Test
    fun getDetailMovieById() {
        val movieEntities = viewModel.getDetailMovieById()
        assertNotNull(movieEntities)
        assertEquals(dummyMovie.id, movieEntities.id)
        assertEquals(dummyMovie.title, movieEntities.title)
        assertEquals(dummyMovie.released, movieEntities.released)
        assertEquals(dummyMovie.genre, movieEntities.genre)
        assertEquals(dummyMovie.duration, movieEntities.duration)
        assertEquals(dummyMovie.rating, movieEntities.rating)
        assertEquals(dummyMovie.desc, movieEntities.desc)
        assertEquals(dummyMovie.poster, movieEntities.poster)
    }

    @Test
    fun getDetailTvShowById() {
        val tvShowEntities = viewModel.getDetailTvShowById()
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.id, tvShowEntities.id)
        assertEquals(dummyTvShow.title, tvShowEntities.title)
        assertEquals(dummyTvShow.released, tvShowEntities.released)
        assertEquals(dummyTvShow.genre, tvShowEntities.genre)
        assertEquals(dummyTvShow.duration, tvShowEntities.duration)
        assertEquals(dummyTvShow.rating, tvShowEntities.rating)
        assertEquals(dummyTvShow.desc, tvShowEntities.desc)
        assertEquals(dummyTvShow.poster, tvShowEntities.poster)
    }
}