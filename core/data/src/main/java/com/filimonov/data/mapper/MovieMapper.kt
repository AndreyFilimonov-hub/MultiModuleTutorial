package com.filimonov.data.mapper

import com.filimonov.data.remote.dto.MovieDto
import com.filimonov.data.remote.dto.MovieResponseDto
import com.filimonov.domain.movie.Movie

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = nameRu ?: nameOriginal ?: "Без названия",
        year = year,
        posterUrl = posterUrlPreview
    )
}

fun MovieResponseDto.toDomainMovies(): List<Movie> {
    return movies.map(MovieDto::toDomain)
}