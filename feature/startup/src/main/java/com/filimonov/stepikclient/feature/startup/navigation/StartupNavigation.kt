package com.filimonov.stepikclient.feature.startup.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.filimonov.stepikclient.feature.startup.presentation.StartupDestination
import com.filimonov.stepikclient.feature.startup.presentation.StartupScreen

fun NavGraphBuilder.startupScreen(
    onNavigate: (StartupDestination) -> Unit
) {
    composable<StartupRoute> {
        StartupScreen(
            onNavigate = onNavigate
        )
    }
}