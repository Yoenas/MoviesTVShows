package com.yoenas.movietvshow.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.yoenas.movietvshow.LiveDataTestUtil
import com.yoenas.movietvshow.data.local.LocalDataSource
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.remote.RemoteDataSource
import com.yoenas.movietvshow.utils.AppExecutors
import com.yoenas.movietvshow.utils.DataDummy
import com.yoenas.movietvshow.utils.PagedListUtils
import com.yoenas.movietvshow.vo.Resource
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieTvShowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val homeRepository = FakeMovieTvShowRepository(remote, local, appExecutors)

    private val moviesResponse = DataDummy.generateRemoteDataMoviesDummy()
    private val movieId = moviesResponse[0].id
    private val tvShowsResponse = DataDummy.generateRemoteDataTvShowsDummy()
    private val tvShowId = tvShowsResponse[0].id

    @Test
    fun getNowPlayingMovies() {
        val dummyMovies =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieTvShow>
        `when`(local.getListMovies()).thenReturn(dummyMovies)
        homeRepository.getNowPlayingMovies()

        val data =
            Resource.success(PagedListUtils.mockPagedList(DataDummy.generateRemoteDataMoviesDummy()))
        verify(local).getListMovies()

        assertNotNull(data.data)
        assertEquals(moviesResponse.size.toLong(), data.data?.size?.toLong())
    }

    @Test
    fun getTopRatedTvShow() {
        val dummyTvShows =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieTvShow>
        `when`(local.getListTvShows()).thenReturn(dummyTvShows)
        homeRepository.getTopRatedTvShows()

        val data =
            Resource.success(PagedListUtils.mockPagedList(DataDummy.generateRemoteDataTvShowsDummy()))
        verify(local).getListTvShows()

        assertNotNull(data.data)
        assertEquals(tvShowsResponse.size.toLong(), data.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyMovie = MutableLiveData<MovieTvShow>()
        dummyMovie.value = DataDummy.generateDataMoviesDummy()[0]
        `when`(local.getDetailMovie(movieId)).thenReturn(dummyMovie)

        val data = LiveDataTestUtil.getValue(homeRepository.getDetailMovie(movieId)).data
        verify(local).getDetailMovie(movieId)

        assertNotNull(data)
        assertEquals(moviesResponse[0].id, data?.id)
    }

    @Test
    fun getDetailTvShow() {
        val dummyTvShow = MutableLiveData<MovieTvShow>()
        dummyTvShow.value = DataDummy.generateDataTvShowsDummy()[0]
        `when`(local.getDetailTvShow(tvShowId)).thenReturn(dummyTvShow)

        val data = LiveDataTestUtil.getValue(homeRepository.getDetailTvShow(tvShowId)).data
        verify(local).getDetailTvShow(tvShowId)

        assertNotNull(data)
        assertEquals(moviesResponse[0].id, data?.id)
    }

    @Test
    fun getFavoriteMovies() {
        val favoriteMovies =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieTvShow>
        `when`(local.getFavoriteMovies()).thenReturn(favoriteMovies)
        homeRepository.getFavoriteMovies()

        val data = Resource.success(PagedListUtils.mockPagedList(DataDummy.generateDataMoviesDummy()))
        verify(local).getFavoriteMovies()
        assertNotNull(data.data)
        assertEquals(20, data.data?.size)
    }

    @Test
    fun getFavoriteTvShows() {
        val favoriteTvShows =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieTvShow>
        `when`(local.getFavoriteTvShows()).thenReturn(favoriteTvShows)
        homeRepository.getFavoriteTvShows()

        val data = Resource.success(PagedListUtils.mockPagedList(DataDummy.generateDataMoviesDummy()))
        verify(local).getFavoriteTvShows()
        assertNotNull(data.data)
        assertEquals(20, data.data?.size)
    }
}