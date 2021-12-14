package com.salhugues.tmdbandroid.data.repository

import com.salhugues.tmdbandroid.common.DataStateWrapper
import com.salhugues.tmdbandroid.domain.model.Movie
import kotlinx.coroutines.Deferred

interface MovieRepository {
    suspend fun fetchNowPlayingMoviesAsync(): Deferred<DataStateWrapper<List<Movie>>>
}
