package com.filimonov.multimoduletutorial

import android.app.Application
import com.filimonov.multimoduletutorial.di.appModule
import com.filimonov.multimoduletutorial.feature.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)

            modules(
                appModule,
                homeModule
            )
        }
    }
}