package com.salhugues.tmdbandroid.data.repository

import com.salhugues.tmdbandroid.common.DataStateWrapper
import com.salhugues.tmdbandroid.data.api.datasource.MovieApiDatasource
import com.salhugues.tmdbandroid.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiMovieDatasource: MovieApiDatasource,
    private val dispatcher: CoroutineDispatcher
) : MovieRepository {

    override suspend fun fetchNowPlayingMoviesAsync(): Deferred<DataStateWrapper<List<Movie>>> {
        return withContext(dispatcher) {
            async {
                apiMovieDatasource.nowPlaying()
            }
        }
    }
}
