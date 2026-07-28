package com.filimonov.stepikclient.core.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class AppPreferencesImpl(
    val dataStore: DataStore<Preferences>
) : AppPreferences {

    companion object {
        val ONBOARDING_COMPLETE = booleanPreferencesKey("onboarding_completed")
    }

    override suspend fun isOnboardingCompleted(): Boolean {
        return dataStore.data
            .map { preferences ->
                preferences[ONBOARDING_COMPLETE] ?: false
            }
            .first()
    }

    override suspend fun completeOnboarding() {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[ONBOARDING_COMPLETE] = true
        }
    }
}