package com.yoenas.movietvshow.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.remote.RemoteDataSource
import com.yoenas.movietvshow.data.remote.response.MoviesItem
import com.yoenas.movietvshow.data.remote.response.TvShowsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieTvShowRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    IRemoteDataSource {

    override fun getNowPlayingMovies(): LiveData<List<MovieTvShow>> {
        val listMovieResult = MutableLiveData<List<MovieTvShow>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getNowPlayingMovies(object : RemoteDataSource.LoadMovieCallback {
                override fun onAllMoviesReceived(moviesItem: List<MoviesItem>?) {
                    val listMovie = ArrayList<MovieTvShow>()
                    if (moviesItem != null) {
                        for (data in moviesItem) {
                            val movie = MovieTvShow(
                                data.id,
                                data.title,
                                data.releaseDate,
                                listOf(),
                                data.runtime,
                                data.voteAverage,
                                data.overview,
                                data.posterPath,
                                data.backdropPath
                            )
                            listMovie.add(movie)
                        }
                    }
                    listMovieResult.postValue(listMovie)
                }
            })
        }
        return listMovieResult
    }

    override fun getTopRatedTvShows(): LiveData<List<MovieTvShow>> {
        val listTvShowResult = MutableLiveData<List<MovieTvShow>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTopRatedTvShows(object : RemoteDataSource.LoadTvShowCallback {
                override fun onAllTvShowsReceived(tvShowsItem: List<TvShowsItem>?) {
                    val listTvShow = ArrayList<MovieTvShow>()
                    if (tvShowsItem != null) {
                        for (data in tvShowsItem) {
                            val movie = MovieTvShow(
                                data.id,
                                data.name,
                                data.firstAirDate,
                                listOf(),
                                0,
                                data.voteAverage,
                                data.overview,
                                data.posterPath,
                                data.backdropPath
                            )
                            listTvShow.add(movie)
                        }
                    }
                    listTvShowResult.postValue(listTvShow)
                }
            })
        }
        return listTvShowResult
    }

    override fun getDetailMovie(id: Int): LiveData<MovieTvShow> {
        val movieResult = MutableLiveData<MovieTvShow>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getDetailMovie(id, object : RemoteDataSource.LoadDetailMovieCallback {
                override fun onDetailMovieReceived(movieItem: MoviesItem) {
                    val movie = MovieTvShow(
                        movieItem.id,
                        movieItem.title,
                        movieItem.releaseDate,
                        movieItem.genres,
                        movieItem.runtime,
                        movieItem.voteAverage,
                        movieItem.overview,
                        movieItem.posterPath,
                        movieItem.backdropPath
                    )
                    movieResult.postValue(movie)
                }
            })
        }
        return movieResult
    }

    override fun getDetailTvShow(id: Int): LiveData<MovieTvShow> {
        val tvShowResult = MutableLiveData<MovieTvShow>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTvDetailTvShow(
                id,
                object : RemoteDataSource.LoadDetailTvShowCallback {
                    override fun onDetailTvShowReceived(tvShowItem: TvShowsItem) {
                        val listRuntime = tvShowItem.episodeRunTime
                        val runtime : Int? = if (listRuntime.isEmpty()){
                            null
                        } else {
                            tvShowItem.episodeRunTime[0]
                        }
                        val movie = MovieTvShow(
                            tvShowItem.id,
                            tvShowItem.name,
                            tvShowItem.firstAirDate,
                            tvShowItem.genres,
                            runtime,
                            tvShowItem.voteAverage,
                            tvShowItem.overview,
                            tvShowItem.posterPath,
                            tvShowItem.backdropPath
                        )
                        tvShowResult.postValue(movie)
                    }
                })
        }
        return tvShowResult
    }

}
