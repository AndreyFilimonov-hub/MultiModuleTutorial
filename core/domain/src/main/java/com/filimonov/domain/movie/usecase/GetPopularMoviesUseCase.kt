package com.filimonov.domain.movie.usecase

import com.filimonov.domain.Result
import com.filimonov.domain.movie.Movie
import com.filimonov.domain.movie.repository.MovieRepository

class GetPopularMoviesUseCase(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(): Result<List<Movie>> {
        return repository.getPopularMovies()
    }
}