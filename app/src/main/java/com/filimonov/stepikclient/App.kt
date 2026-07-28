package com.filimonov.stepikclient

import android.app.Application
import com.filimonov.stepikclient.di.appModule
import com.filimonov.stepikclient.feature.home.di.homeModule
import com.filimonov.core.stepikclient.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)

            modules(
                appModule,
                homeModule,
                networkModule
            )
        }
    }
}