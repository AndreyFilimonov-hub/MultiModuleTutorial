package com.filimonov.stepikclient.feature.startup.presentation

sealed interface StartupDestination {

    data object Loading: StartupDestination

    data object Onboarding: StartupDestination

    data object Authentication: StartupDestination

    data object Home: StartupDestination
}