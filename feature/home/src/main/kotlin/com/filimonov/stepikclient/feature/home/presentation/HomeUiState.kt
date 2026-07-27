package com.filimonov.stepikclient.feature.home.presentation

import com.filimonov.core.domain.NetworkError
import com.filimonov.core.domain.course.Course

sealed interface HomeUiState {

    data object Idle : HomeUiState

    data object Loading : HomeUiState

    data class Success(val courses: List<Course>) : HomeUiState

    data class Error(val error: NetworkError) : HomeUiState
}
