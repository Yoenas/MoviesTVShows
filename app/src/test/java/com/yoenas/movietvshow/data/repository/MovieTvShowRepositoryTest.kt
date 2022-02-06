package com.yoenas.movietvshow.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.yoenas.movietvshow.LiveDataTestUtil
import com.yoenas.movietvshow.utils.DataDummy
import com.yoenas.movietvshow.data.remote.RemoteDataSource
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class MovieTvShowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val homeRepository = FakeMovieTvShowRepository(remote)

    private val moviesResponse = DataDummy.generateRemoteDataMoviesDummy()
    private val movieId = moviesResponse[0].id
    private val tvShowsResponse = DataDummy.generateRemoteDataTvShowsDummy()
    private val tvShowId = tvShowsResponse[0].id

    private val dummyMovie = DataDummy.generateRemoteDataMoviesDummy()[0]
    private val dummyTvShows = DataDummy.generateRemoteDataTvShowsDummy()[0]

    @ExperimentalCoroutinesApi
    @Test
    fun getNowPlayingMovies() = runBlockingTest {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadMovieCallback).onAllMoviesReceived(
                moviesResponse
            )
            null
        }.`when`(remote).getNowPlayingMovies(any())

        val data = LiveDataTestUtil.getValue(homeRepository.getNowPlayingMovies())
        verify(remote).getNowPlayingMovies(any())

        assertNotNull(data)
        assertEquals(1, data.size)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getTopRatedTvShow() = runBlockingTest {
        doAnswer {
            (it.arguments[0] as RemoteDataSource.LoadTvShowCallback).onAllTvShowsReceived(
                tvShowsResponse
            )
            null
        }.`when`(remote).getTopRatedTvShows(any())

        val data = LiveDataTestUtil.getValue(homeRepository.getTopRatedTvShows())
        verify(remote).getTopRatedTvShows(any())

        assertNotNull(data)
        assertEquals(1, data.size)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getDetailMovies() = runBlockingTest {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback).onDetailMovieReceived(
                dummyMovie
            )
            null
        }.`when`(remote).getDetailMovie(eq(movieId), any())

        val data = LiveDataTestUtil.getValue(homeRepository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(eq(movieId), any())

        assertNotNull(data)
        assertEquals(dummyMovie.id, data.id)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getDetailTvShow() = runBlockingTest {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvShowCallback).onDetailTvShowReceived(
                dummyTvShows
            )
            null
        }.`when`(remote).getTvDetailTvShow(eq(tvShowId), any())

        val data = LiveDataTestUtil.getValue(homeRepository.getDetailTvShow(tvShowId))
        verify(remote).getTvDetailTvShow(eq(tvShowId), any())

        assertNotNull(data)
        assertEquals(dummyTvShows.id, data.id)
    }
}