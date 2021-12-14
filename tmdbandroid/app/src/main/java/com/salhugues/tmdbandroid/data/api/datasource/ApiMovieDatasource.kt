package com.salhugues.tmdbandroid.data.api.datasource

import com.salhugues.tmdbandroid.data.api.model.ApiMulti
import com.salhugues.tmdbandroid.data.api.service.MovieApiService
import com.salhugues.tmdbandroid.data.domain.DomainMapper
import com.salhugues.tmdbandroid.data.domain.Movie
import javax.inject.Inject

class ApiMovieDatasource @Inject constructor(
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
}
