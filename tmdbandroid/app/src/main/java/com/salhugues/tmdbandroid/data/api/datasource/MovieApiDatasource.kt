package com.salhugues.tmdbandroid.data.api.datasource

import com.salhugues.tmdbandroid.BuildConfig
import com.salhugues.tmdbandroid.common.DataStateWrapper
import com.salhugues.tmdbandroid.data.api.model.ApiMulti
import com.salhugues.tmdbandroid.data.api.service.MovieApiService
import com.salhugues.tmdbandroid.domain.DomainMapper
import com.salhugues.tmdbandroid.domain.model.Movie
import java.lang.Exception
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

    suspend fun nowPlaying(): DataStateWrapper<List<Movie>> {
        val result = movieApiService.nowPlaying(
            BuildConfig.API_KEY,
            "fr-FR"
        )

        return try {
            if (result.isSuccessful) {
                DataStateWrapper.Success(
                    result.body()?.results?.map {
                        mapToDomain(it)
                    } ?: emptyList()
                )
            } else {
                DataStateWrapper.Success(emptyList())
            }
        } catch (exception: Exception) {
            DataStateWrapper.Error(exception, null)
        }
    }
}
