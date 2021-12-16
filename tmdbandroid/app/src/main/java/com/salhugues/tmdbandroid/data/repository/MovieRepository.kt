package com.salhugues.tmdbandroid.data.repository

import com.salhugues.tmdbandroid.common.DataState
import com.salhugues.tmdbandroid.domain.model.Movie
import kotlinx.coroutines.Deferred

interface MovieRepository {
    suspend fun fetchNowPlayingMoviesAsync(): Deferred<DataState<List<Movie>>>
}
