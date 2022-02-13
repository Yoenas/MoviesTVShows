package com.yoenas.movietvshow.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yoenas.movietvshow.data.local.LocalDataSource
import com.yoenas.movietvshow.data.model.MovieTvShow
import com.yoenas.movietvshow.data.remote.ApiResponse
import com.yoenas.movietvshow.data.remote.RemoteDataSource
import com.yoenas.movietvshow.data.remote.response.MoviesItem
import com.yoenas.movietvshow.data.remote.response.TvShowsItem
import com.yoenas.movietvshow.utils.AppExecutors
import com.yoenas.movietvshow.vo.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieTvShowRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IRemoteDataSource {

    override fun getNowPlayingMovies(): LiveData<Resource<PagedList<MovieTvShow>>> {
        return object :
            NetworkBoundResource<PagedList<MovieTvShow>, List<MoviesItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieTvShow>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieTvShow>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MoviesItem>>> =
                remoteDataSource.getNowPlayingMovies()

            override fun saveCallResult(data: List<MoviesItem>) {
                val listMovie = ArrayList<MovieTvShow>()
                for (response in data) {

                    val dataDetailMovie = remoteDataSource.getDetailMovie(response.id)
                    val genresMovie = dataDetailMovie.value?.body?.genres
                    val genres = arrayListOf<String>()
                    if (genresMovie != null) {
                        for (item in genresMovie) {
                            val genre = item.name
                            genres.add(genre)
                        }
                    }
                    val convGenres = genres.joinToString()

                    val movie = MovieTvShow(
                        null,
                        response.id,
                        response.title,
                        response.releaseDate,
                        convGenres,
                        null,
                        response.voteAverage,
                        response.overview,
                        response.posterPath,
                        response.backdropPath,
                        isFavorite = false,
                        isTvShow = false
                    )
                    listMovie.add(movie)
                }
                localDataSource.addMoviesTvShows(listMovie)
            }
        }.asLiveData()
    }

    override fun getTopRatedTvShows(): LiveData<Resource<PagedList<MovieTvShow>>> {
        return object :
            NetworkBoundResource<PagedList<MovieTvShow>, List<TvShowsItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieTvShow>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieTvShow>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowsItem>>> =
                remoteDataSource.getTopRatedTvShows()

            override fun saveCallResult(data: List<TvShowsItem>) {
                val listTvShow = ArrayList<MovieTvShow>()
                for (response in data) {

                    val movie = MovieTvShow(
                        null,
                        response.id,
                        response.name,
                        response.firstAirDate,
                        null,
                        null,
                        response.voteAverage,
                        response.overview,
                        response.posterPath,
                        response.backdropPath,
                        isFavorite = false,
                        isTvShow = true
                    )
                    listTvShow.add(movie)
                }
                localDataSource.addMoviesTvShows(listTvShow)
            }

        }.asLiveData()
    }

    override fun getDetailMovie(id: Int): LiveData<Resource<MovieTvShow>> {
        return object : NetworkBoundResource<MovieTvShow, MoviesItem>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieTvShow> = localDataSource.getDetailMovie(id)

            override fun shouldFetch(data: MovieTvShow?): Boolean {
                return if (data?.genres?.isEmpty() == true || data?.runtime == null) {
                    true
                } else data.genres == "" || data.runtime == 0
            }

            override fun createCall(): LiveData<ApiResponse<MoviesItem>> =
                remoteDataSource.getDetailMovie(id)

            override fun saveCallResult(data: MoviesItem) {
                val dataGenres = data.genres
                val genres = arrayListOf<String>()
                for (item in dataGenres) {
                    val genre = item.name
                    genres.add(genre)
                }
                val convGenres = genres.joinToString()
                localDataSource.updateMovieTvShowById(convGenres, data.runtime, id)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(id: Int): LiveData<Resource<MovieTvShow>> {
        return object : NetworkBoundResource<MovieTvShow, TvShowsItem>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieTvShow> = localDataSource.getDetailTvShow(id)

            override fun shouldFetch(data: MovieTvShow?): Boolean {
                return if (data?.genres?.isEmpty() == true || data?.runtime == null) {
                    true
                } else data.genres == "" || data.runtime == 0
            }

            override fun createCall(): LiveData<ApiResponse<TvShowsItem>> =
                remoteDataSource.getTvDetailTvShow(id)

            override fun saveCallResult(data: TvShowsItem) {
                val dataGenres = data.genres
                val genres = arrayListOf<String>()
                for (item in dataGenres) {
                    val genre = item.name
                    genres.add(genre)
                }
                val convGenres = genres.joinToString()

                val runtime: Int? = if (data.episodeRunTime.isEmpty()) {
                    null
                } else {
                    data.episodeRunTime[0]
                }
                runtime?.let { localDataSource.updateMovieTvShowById(convGenres, it, id) }
            }
        }.asLiveData()
    }

    override fun setMovieTvAsFavorite(movieTvShow: MovieTvShow, state: Boolean) {
        return appExecutors.diskIO().execute {
            localDataSource.setMovieTvAsFavorite(movieTvShow, state)
        }
    }

    override fun getFavoriteMovies(): LiveData<PagedList<MovieTvShow>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<MovieTvShow>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }
}