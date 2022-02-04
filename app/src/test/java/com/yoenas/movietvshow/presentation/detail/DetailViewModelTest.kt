package com.yoenas.movietvshow.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.yoenas.movietvshow.data.local.DataDummy
import com.yoenas.movietvshow.data.model.MoviesItem
import com.yoenas.movietvshow.data.model.TvShowsItem
import com.yoenas.movietvshow.data.repository.DetailRepository
import com.yoenas.movietvshow.data.repository.MyDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
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
import org.mockito.Mockito.spy
import org.mockito.junit.MockitoJUnitRunner

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Mock
    private lateinit var remote: MyDataSource

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observerMovie: Observer<MoviesItem>

    @Mock
    private lateinit var observerTvShow: Observer<TvShowsItem>

    private var detailRepository: DetailRepository = mock()
    private lateinit var viewModel: DetailViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        remote = Mockito.mock(remote.javaClass)
//        detailRepository = DetailRepository(remote)
        viewModel = spy(DetailViewModel(detailRepository))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getDetailMovieById() = runBlockingTest {
        val dummyMovie = DataDummy.generateDataMoviesDummy()
        val movieId = dummyMovie[0].id
        val movie = MutableLiveData<List<MoviesItem>>()
        if (movieId != null) {
            movie.value = dummyMovie

            val expectedData = dummyMovie[0]
            `when`(detailRepository.getDetailMovie(movieId)).thenReturn(expectedData)
            detailRepository.getDetailMovie(movieId)

            val data = viewModel.movie.value

            data?.let {
                assertNotNull(data)
                assertEquals(expectedData.id, data.id)
                assertEquals(expectedData.title, data.title)
                assertEquals(expectedData.releaseDate, data.releaseDate)
                assertEquals(expectedData.genres, data.genres)
                assertEquals(expectedData.runtime, data.runtime)
                assertEquals(expectedData.voteAverage, data.voteAverage)
                assertEquals(expectedData.overview, data.overview)
                assertEquals(expectedData.posterPath, data.posterPath)
                assertEquals(expectedData.backdropPath, data.backdropPath)
                viewModel.movie.observeForever(observerMovie)
                verify(observerMovie).onChanged(expectedData)
            }
            verify(detailRepository).getDetailMovie(movieId)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getDetailTvShowById() = runBlockingTest {
        val dummyTvShow = DataDummy.generateDataTvShowsDummy()
        val tvShowId = dummyTvShow[0].id
        val tvShow = MutableLiveData<List<TvShowsItem>>()
        if (tvShowId != null) {
            tvShow.value = dummyTvShow

            val expectedData = dummyTvShow[0]
            `when`(detailRepository.getDetailTvShow(tvShowId)).thenReturn(expectedData)
            detailRepository.getDetailTvShow(tvShowId)

            val data = viewModel.tvShow.value

            data?.let {
                assertNotNull(data)
                assertEquals(expectedData.id, data.id)
                assertEquals(expectedData.name, data.name)
                assertEquals(expectedData.firstAirDate, data.firstAirDate)
                assertEquals(expectedData.genres, data.genres)
                assertEquals(expectedData.episodeRunTime, data.episodeRunTime)
                assertEquals(expectedData.voteAverage, data.voteAverage)
                assertEquals(expectedData.overview, data.overview)
                assertEquals(expectedData.posterPath, data.posterPath)
                assertEquals(expectedData.backdropPath, data.backdropPath)
                viewModel.tvShow.observeForever(observerTvShow)
                verify(observerTvShow).onChanged(expectedData)
            }

            verify(detailRepository).getDetailTvShow(tvShowId)
        }
    }
}