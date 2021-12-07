package com.salhugues.tmdbandroid.data.net.model

import com.google.gson.annotations.SerializedName
import com.salhugues.tmdbandroid.data.Mapper
import com.salhugues.tmdbandroid.data.domain.Multi

data class ApiError(
    @SerializedName("status_code") val statusCode: Int,
    @SerializedName("status_message") val statusMessage: String,
    @SerializedName("success") val success: Boolean,
)

data class ApiResult(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<ApiMulti>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)

data class ApiMulti(
    @SerializedName("id") val id: Int,
    @SerializedName("gender") val gender: Int?,
    @SerializedName("known_for") val knownFor: List<ApiMulti>?,
    @SerializedName("known_for_department") val knownForDepartment: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("popularity") val popularity: Float?,
    @SerializedName("profile_path") val profilePath: String?,
    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("genre_ids") val genreIds: List<Int>?,
    @SerializedName("origin_country") val originCountry: List<String>?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("original_title") val originalTitle: String?,
    @SerializedName("original_name") val originalName: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("first_air_date") val firstAirDate: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("video") val video: Boolean?,
    @SerializedName("vote_average") val voteAverage: Float?,
    @SerializedName("vote_count") val voteCount: Int?,
    @SerializedName("media_type") val mediaType: String?
) : Mapper<ApiMulti, Multi> {
    override fun transform(item: ApiMulti): Multi {
        return Multi(
            id,
            gender,
            knownFor?.map { transform(it) },
            knownForDepartment,
            name,
            popularity,
            profilePath,
            adult,
            backdropPath,
            genreIds,
            originCountry,
            originalLanguage,
            originalTitle,
            originalName,
            overview,
            posterPath,
            releaseDate,
            firstAirDate,
            title,
            video,
            voteAverage,
            voteCount,
            mediaType
        )
    }

    override fun revert(item: Multi): ApiMulti {
        TODO("Not yet implemented")
    }
}
