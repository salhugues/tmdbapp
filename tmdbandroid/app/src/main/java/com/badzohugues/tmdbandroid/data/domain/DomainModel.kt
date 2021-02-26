package com.badzohugues.tmdbandroid.data.domain

import com.badzohugues.tmdbandroid.common.constants.MediaType
import com.badzohugues.tmdbandroid.data.mapper.DomainMapper

data class TmDbMulti(val id: Int,
                 val gender: Int?,
                 val knownFor: List<TmDbMulti>?,
                 val knownForDepartment: String?,
                 val name: String?,
                 val popularity: Float?,
                 val profilePath: String?,
                 val adult: Boolean?,
                 val backdropPath: String?,
                 val genreIds: List<Int>?,
                 val originCountry: List<String>?,
                 val originalLanguage: String?,
                 val originalTitle: String?,
                 val originalName: String?,
                 val overview: String?,
                 val posterPath: String?,
                 val releaseDate: String?,
                 val firstAirDate: String?,
                 val title: String?,
                 val video: Boolean?,
                 val voteAverage: Float?,
                 val voteCount: Int?,
                 val mediaType: String?
): DomainMapper<TmDbMulti, Movie, Person, Tv> {
    override fun asMovie(item: TmDbMulti): Movie {
        return Movie(id,
                MediaType.MOVIE.type,
                popularity ?: 0.0f,
                adult ?: false,
                backdropPath ?: "",
                genreIds ?: emptyList(),
                originalLanguage ?: "",
                originalTitle ?: "",
                overview ?: "",
                posterPath ?: "",
                releaseDate ?: "",
                title ?: "",
                video ?: false,
                voteAverage ?: 0.0f,
                voteCount ?: 0
        )
    }

    override fun asPerson(item: TmDbMulti): Person {
        return Person(id,
                MediaType.PERSON.type,
                gender ?: 1,
                knownFor?.map { asMovie(it) } ?: emptyList(),
                knownForDepartment ?: "",
                name ?: "",
                popularity ?: 0.0f,
                profilePath ?: "",
                adult ?: false
        )
    }

    override fun asTv(item: TmDbMulti): Tv {
        return Tv(id,
                MediaType.TV.type,
                name ?: "",
                popularity ?: 0.0f,
                profilePath ?: "",
                adult ?: false,
                backdropPath ?: "",
                genreIds ?: emptyList(),
                originCountry ?: emptyList(),
                originalLanguage ?: "",
                originalName ?: "",
                overview ?: "",
                posterPath ?: "",
                firstAirDate ?: "",
                voteAverage ?: 0.0f,
                voteCount ?: 0
        )
    }
}

open class Multi {
    open var id: Int = 0
    open lateinit var mediaType: String
    open var isFavorite: Boolean = false
}

data class Person(override var id: Int,
                  override var mediaType: String = String(),
                  val gender: Int,
                  val knownFor: List<Movie>,
                  val knownForDepartment: String,
                  val name: String,
                  val popularity: Float,
                  val profilePath: String,
                  val adult: Boolean
): Multi()

data class Movie(override var id: Int,
                 override var mediaType: String = String(),
                 val popularity: Float,
                 val adult: Boolean,
                 val backdropPath: String,
                 val genreIds: List<Int>,
                 val originalLanguage: String,
                 val originalTitle: String,
                 val overview: String,
                 val posterPath: String,
                 val releaseDate: String,
                 val title: String,
                 val video: Boolean,
                 val voteAverage: Float,
                 val voteCount: Int
) : Multi()

data class Tv(override var id: Int,
              override var mediaType: String = String(),
              val name: String,
              val popularity: Float,
              val profilePath: String,
              val adult: Boolean,
              val backdropPath: String,
              val genreIds: List<Int>,
              val originCountry: List<String>,
              val originalLanguage: String,
              val originalName: String,
              val overview: String,
              val posterPath: String,
              val firstAirDate: String,
              val voteAverage: Float,
              val voteCount: Int
): Multi()
