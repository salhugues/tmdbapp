package com.salhugues.tmdbandroid.app.domain.model

data class Multi(
    val id: Int,
    val gender: Int?,
    val knownFor: List<Multi>?,
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
)/* : DomainMapper<Multi, Movie, Person, Tv> {
    override fun asMovie(item: Multi): Movie {
        return Movie(
            id,
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

    override fun asPerson(item: Multi): Person {
        return Person(
            id,
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

    override fun asTv(item: Multi): Tv {
        return Tv(
            id,
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
}*/
