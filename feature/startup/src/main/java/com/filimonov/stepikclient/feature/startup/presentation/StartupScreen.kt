package com.filimonov.stepikclient.feature.startup.presentation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun StartupScreen(
    modifier: Modifier = Modifier,
    onNavigate: (StartupDestination) -> Unit,
    viewModel: StartupViewModel = koinViewModel()
) {
    Log.d("AAA", "startupscreen init")
    val destination by viewModel.destination.collectAsStateWithLifecycle()

    LaunchedEffect(destination) {
        if (destination != StartupDestination.Loading) {
            onNavigate(destination)
        }
    }
}