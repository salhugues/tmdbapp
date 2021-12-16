package com.salhugues.tmdbandroid.data.api.datasource

import com.salhugues.tmdbandroid.BuildConfig
import com.salhugues.tmdbandroid.common.DataState
import com.salhugues.tmdbandroid.data.api.model.ApiMulti
import com.salhugues.tmdbandroid.data.api.service.MovieApiService
import com.salhugues.tmdbandroid.data.api.util.ApiUtil
import com.salhugues.tmdbandroid.domain.DomainMapper
import com.salhugues.tmdbandroid.domain.model.Movie
import javax.inject.Inject

class MovieApiDatasource @Inject constructor(
    private val movieApiService: MovieApiService
) : DomainMapper<ApiMulti, Movie> {
    override fun mapToDomain(item: ApiMulti): Movie {
        return Movie(
            item.id,
            item.mediaType ?: String(),
            item.popularity ?: 0.0f,
            item.backdropPath ?: String(),
            item.genreIds ?: ArrayList(),
            item.originalLanguage ?: String(),
            item.originalTitle ?: String(),
            item.overview ?: String(),
            item.posterPath ?: String(),
            item.releaseDate ?: String(),
            item.title ?: String(),
            item.video ?: false,
            item.voteAverage ?: 0.0f,
            item.voteCount ?: 0
        )
    }

    suspend fun nowPlaying(): DataState<List<Movie>> {
        val result = movieApiService.nowPlaying(BuildConfig.API_KEY)

        return try {
            if (result.isSuccessful) {
                DataState.Success(
                    result.body()?.results?.map {
                        mapToDomain(it)
                    } ?: emptyList()
                )
            } else {
                DataState.Error(ApiUtil.handleApiError(result.code()))
            }
        } catch (cause: Throwable) {
            DataState.Error(message = cause.message)
        }
    }
}
