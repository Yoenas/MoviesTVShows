package com.yoenas.movietvshow.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.verify
import com.yoenas.movietvshow.LiveDataTestUtil
import com.yoenas.movietvshow.data.local.DataDummy
import com.yoenas.movietvshow.data.model.MoviesItem
import com.yoenas.movietvshow.data.model.TvShowsItem
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class DetailRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(MyDataSource::class.java)
    private val detailRepository = FakeDetailRepository(remote)

    private val moviesResponse = DataDummy.generateRemoteDataMoviesDummy()
    private val movieId = moviesResponse[0].id
    private val tvShowsResponse = DataDummy.generateRemoteDataTvShowsDummy()
    private val tvShowId = tvShowsResponse[0].id
    private val dummyMovie = DataDummy.generateDataMoviesDummy()[0]
    private val dummyTvShows = DataDummy.generateDataTvShowsDummy()[0]

    @ExperimentalCoroutinesApi
    @Test
    fun getDetailMovies() = runBlockingTest {
        val dummy = MutableLiveData<MoviesItem>()
        dummy.value = dummyMovie
        `when`(movieId?.let { remote.getDetailMovie(it) }).thenReturn(dummyMovie)

        val entities = MutableLiveData<MoviesItem>()
        entities.value = movieId?.let { detailRepository.getDetailMovie(it) }

        val movieEntities = LiveDataTestUtil.getValue(entities)
        if (movieId != null) {
            verify(remote).getDetailMovie(movieId)
        }
        assertNotNull(movieEntities)
        assertEquals(dummyMovie.id, movieEntities.id)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getDetailTvShow() = runBlockingTest {
        val dummy = MutableLiveData<TvShowsItem>()
        dummy.value = dummyTvShows
        `when`(tvShowId?.let { remote.getDetailTvShow(it) }).thenReturn(dummyTvShows)

        val entities = MutableLiveData<TvShowsItem>()
        entities.value = tvShowId?.let { detailRepository.getDetailTvShow(it) }

        val tvShowEntities = LiveDataTestUtil.getValue(entities)
        if (tvShowId != null) {
            verify(remote).getDetailTvShow(tvShowId)
        }
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShows.id, tvShowEntities.id)
    }
}