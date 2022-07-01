package com.github.architecturepetproject.app

import android.app.Application
import com.github.architecturepetproject.di.appModule
import com.github.architecturepetproject.di.dataModule
import com.github.architecturepetproject.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }

    }
}