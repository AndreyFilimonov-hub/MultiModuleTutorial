package com.filimonov.stepikclient.core.data.preferences

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

private const val DATASTORE_NAME = "settings"

val Context.dataStore by preferencesDataStore(
    name = DATASTORE_NAME
)