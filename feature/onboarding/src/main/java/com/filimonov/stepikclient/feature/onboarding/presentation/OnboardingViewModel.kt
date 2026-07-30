package com.filimonov.stepikclient.feature.onboarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.filimonov.stepikclient.core.data.preferences.AppPreferences
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class OnboardingViewModel(private val appPreferences: AppPreferences) : ViewModel() {

    private val _events = MutableSharedFlow<OnboardingEvent>()
    val events = _events.asSharedFlow()

    fun completeOnboarding() {
        viewModelScope.launch {
            appPreferences.completeOnboarding()
            _events.emit(OnboardingEvent.Completed)
        }
    }
}