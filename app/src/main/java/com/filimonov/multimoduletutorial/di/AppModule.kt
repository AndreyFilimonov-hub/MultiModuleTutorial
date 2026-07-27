package com.filimonov.multimoduletutorial.di

import com.filimonov.data.repository.MovieRepositoryImpl
import com.filimonov.domain.movie.repository.MovieRepository
import com.filimonov.domain.movie.usecase.GetPopularMoviesUseCase
import org.koin.dsl.module

val appModule = module {

    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }

    factory {
        GetPopularMoviesUseCase(get())
    }
}