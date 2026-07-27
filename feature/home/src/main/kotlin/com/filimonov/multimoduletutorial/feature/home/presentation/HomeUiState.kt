package com.filimonov.multimoduletutorial.feature.home.presentation

import com.filimonov.domain.NetworkError
import com.filimonov.domain.movie.Movie

sealed interface HomeUiState {

    data object Idle : HomeUiState

    data object Loading : HomeUiState

    data class Success(val movies: List<Movie>) : HomeUiState

    data class Error(val error: NetworkError) : HomeUiState
}
