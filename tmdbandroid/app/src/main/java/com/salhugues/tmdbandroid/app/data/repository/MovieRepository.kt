package com.salhugues.tmdbandroid.app.data.repository

import com.salhugues.tmdbandroid.app.common.DataState
import com.salhugues.tmdbandroid.app.domain.model.Movie
import kotlinx.coroutines.Deferred

interface MovieRepository {
    suspend fun fetchNowPlayingMoviesAsync(): Deferred<DataState<List<Movie>>>
}
