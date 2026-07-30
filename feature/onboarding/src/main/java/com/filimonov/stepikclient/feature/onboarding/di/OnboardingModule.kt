package com.filimonov.stepikclient.feature.onboarding.di

import com.filimonov.stepikclient.feature.onboarding.presentation.OnboardingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val onboardingModule = module {
    viewModel { OnboardingViewModel(get()) }
}