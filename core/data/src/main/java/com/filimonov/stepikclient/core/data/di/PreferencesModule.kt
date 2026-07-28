package com.filimonov.stepikclient.core.data.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.filimonov.stepikclient.core.data.preferences.AppPreferences
import com.filimonov.stepikclient.core.data.preferences.AppPreferencesImpl
import com.filimonov.stepikclient.core.data.preferences.dataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferencesModule = module {
    single<DataStore<Preferences>> {
        androidContext().dataStore
    }

    single<AppPreferences> { AppPreferencesImpl(get()) }
}