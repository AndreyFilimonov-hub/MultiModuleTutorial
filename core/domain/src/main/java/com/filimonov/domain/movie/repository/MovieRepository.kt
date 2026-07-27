package com.filimonov.domain.movie.repository

import com.filimonov.domain.Result
import com.filimonov.domain.movie.Movie

interface MovieRepository {

    suspend fun getPopularMovies(): Result<List<Movie>>
}