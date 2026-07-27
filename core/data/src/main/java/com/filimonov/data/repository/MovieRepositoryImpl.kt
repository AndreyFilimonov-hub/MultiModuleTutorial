package com.filimonov.data.repository

import com.filimonov.data.mapper.toDomainMovies
import com.filimonov.data.remote.api.KinopoiskApi
import com.filimonov.data.remote.model.CollectionsType
import com.filimonov.data.remote.safeApiCall
import com.filimonov.domain.Result
import com.filimonov.domain.movie.Movie
import com.filimonov.domain.movie.repository.MovieRepository

class MovieRepositoryImpl(
    private val api: KinopoiskApi
) : MovieRepository {

    override suspend fun getPopularMovies(): Result<List<Movie>> {
        return safeApiCall { api.getMovies(CollectionsType.TOP_POPULAR_ALL.value).toDomainMovies() }
    }
}