package com.filimonov.multimoduletutorial.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filimonov.domain.Result
import com.filimonov.domain.movie.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    init {
        loadMovies()
    }

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Idle)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private fun loadMovies() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading

            when (val result = getPopularMoviesUseCase()) {
                is Result.Error -> _uiState.value = HomeUiState.Error(result.error)
                is Result.Success -> {
                    _uiState.value = HomeUiState.Success(result.data)
                }
            }
        }
    }
}