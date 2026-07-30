package com.filimonov.stepikclient.feature.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.filimonov.stepikclient.feature.onboarding.presentation.OnboardingScreen

fun NavGraphBuilder.onboardingScreen(
    onNavigate: () -> Unit
) {
    composable<OnboardingRoute> {
        OnboardingScreen(
            onNavigate = onNavigate
        )
    }
}