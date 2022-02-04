package com.yoenas.movietvshow.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.yoenas.movietvshow.data.local.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class HomeRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(MyDataSource::class.java)
    private val homeRepository = FakeHomeRepository(remote)

    private val moviesResponse = DataDummy.generateRemoteDataMoviesDummy()
    private val tvShowsResponse = DataDummy.generateRemoteDataTvShowsDummy()

    @ExperimentalCoroutinesApi
    @Test
    fun getNowPlayingMovies() = runBlockingTest {
        whenever(homeRepository.getNowPlayingMovies()).thenReturn(moviesResponse)
        val data = homeRepository.getNowPlayingMovies()
        verify(remote).getNowPlayingMovies()

        assertNotNull(data)
        assertEquals(1, data.size)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getTopRatedTvShow() = runBlockingTest {
        whenever(homeRepository.getTopRatedTvShows()).thenReturn(tvShowsResponse)
        val data = homeRepository.getTopRatedTvShows()
        verify(remote).getTopRatedTvShows()

        assertNotNull(data)
        assertEquals(1, data.size)
    }
}