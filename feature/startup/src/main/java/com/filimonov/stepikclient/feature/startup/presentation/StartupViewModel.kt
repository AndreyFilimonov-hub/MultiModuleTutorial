package com.filimonov.stepikclient.feature.startup.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filimonov.stepikclient.core.data.preferences.AppPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StartupViewModel(
    private val appPreferences: AppPreferences
) : ViewModel() {

    private val _destination = MutableStateFlow<StartupDestination>(StartupDestination.Loading)
    val destination = _destination.asStateFlow()

    init {
        determineStartDestination()
    }

    private fun determineStartDestination() {
        viewModelScope.launch {
            if (appPreferences.isOnboardingCompleted()) {
                Log.d("AAA", "Home")
                _destination.value = StartupDestination.Home
            } else {
                Log.d("AAA", "Onboarding")
                _destination.value = StartupDestination.Onboarding
            }
        }
    }
}