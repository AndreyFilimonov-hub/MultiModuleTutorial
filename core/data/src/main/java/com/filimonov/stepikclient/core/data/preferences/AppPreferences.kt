package com.filimonov.stepikclient.core.data.preferences

interface AppPreferences {

    suspend fun isOnboardingCompleted(): Boolean

    suspend fun completeOnboarding()
}