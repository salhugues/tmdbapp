package com.salhugues.tmdbandroid.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class DbFavorite(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "gender") val gender: Int,
    @ColumnInfo(name = "known_for") val knownFor: List<DbFavorite>,
    @ColumnInfo(name = "known_for_department") val knownForDepartment: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "popularity") val popularity: Float,
    @ColumnInfo(name = "profile_path") val profilePath: String,
    @ColumnInfo(name = "backdrop_path") val backdropPath: String,
    @ColumnInfo(name = "genre_ids") val genreIds: List<Int>,
    @ColumnInfo(name = "origin_country") val originCountry: List<String>,
    @ColumnInfo(name = "original_language") val originalLanguage: String,
    @ColumnInfo(name = "original_title") val originalTitle: String,
    @ColumnInfo(name = "original_name") val originalName: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "poster_path") val posterPath: String,
    @ColumnInfo(name = "release_date") val releaseDate: String,
    @ColumnInfo(name = "first_air_date") val firstAirDate: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "video") val video: Boolean,
    @ColumnInfo(name = "vote_average") val voteAverage: Float,
    @ColumnInfo(name = "vote_count") val voteCount: Int,
    @ColumnInfo(name = "media_type") val mediaType: String,
    @ColumnInfo(name = "is_favorite") val isFavorite: Boolean
)
