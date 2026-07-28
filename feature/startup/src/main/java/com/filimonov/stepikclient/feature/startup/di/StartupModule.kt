package com.filimonov.stepikclient.feature.startup.di

import com.filimonov.stepikclient.feature.startup.presentation.StartupViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val startupModule = module {
    viewModel { StartupViewModel(get()) }
}