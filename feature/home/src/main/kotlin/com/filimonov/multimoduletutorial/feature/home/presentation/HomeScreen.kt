package com.filimonov.multimoduletutorial.feature.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    when(val currentState = state) {
        is HomeUiState.Error -> TODO()
        HomeUiState.Idle -> Unit
        HomeUiState.Loading -> TODO()
        is HomeUiState.Success -> TODO()
    }
}