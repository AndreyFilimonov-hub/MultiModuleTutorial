package com.filimonov.stepikclient.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filimonov.core.domain.Result
import com.filimonov.core.domain.course.usecase.GetCoursesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCoursesUseCase: GetCoursesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Idle)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadCourses()
    }

    private fun loadCourses() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading

            when (val result = getCoursesUseCase()) {
                is Result.Error -> _uiState.value = HomeUiState.Error(result.error)
                is Result.Success -> {
                    _uiState.value = HomeUiState.Success(result.data)
                }
            }
        }
    }
}