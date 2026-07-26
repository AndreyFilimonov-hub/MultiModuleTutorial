package com.filimonov.multimoduletutorial.feature.home.di

import com.filimonov.multimoduletutorial.feature.home.presentation.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel {
        HomeViewModel()
    }
}