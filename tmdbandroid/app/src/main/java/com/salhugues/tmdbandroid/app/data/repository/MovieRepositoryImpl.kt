package com.salhugues.tmdbandroid.app.data.repository

import com.salhugues.tmdbandroid.app.common.DataState
import com.salhugues.tmdbandroid.app.data.api.datasource.MovieApiDatasource
import com.salhugues.tmdbandroid.app.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiMovieDatasource: MovieApiDatasource,
    private val dispatcher: CoroutineDispatcher
) : MovieRepository {

    override suspend fun fetchNowPlayingMoviesAsync(): Deferred<DataState<List<Movie>>> {
        return withContext(dispatcher) {
            async {
                apiMovieDatasource.nowPlaying()
            }
        }
    }
}
