package com.salhugues.tmdbandroid.domain.usecase

import com.salhugues.tmdbandroid.common.DataStateWrapper
import com.salhugues.tmdbandroid.domain.model.Movie
import kotlinx.coroutines.Deferred

interface HomeUseCase {
    suspend fun getNowPlayingMovies(): Deferred<DataStateWrapper<List<Movie>>>
}
