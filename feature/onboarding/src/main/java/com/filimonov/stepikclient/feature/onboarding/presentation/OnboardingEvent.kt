package com.filimonov.stepikclient.feature.onboarding.presentation

sealed interface OnboardingEvent {

    data object Completed: OnboardingEvent
}