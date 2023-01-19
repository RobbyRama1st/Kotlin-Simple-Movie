package com.sweet.cloves.simplemovie

import android.app.Application
import com.sweet.cloves.simplemovie.di.appModules
import com.sweet.cloves.simplemovie.di.networkModules
import com.sweet.cloves.simplemovie.di.repositoryModules
import com.sweet.cloves.simplemovie.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        // TODO: start koin here and load all koin modules
        startKoin {
            androidContext(this@App)
            modules(listOf(
                appModules,
                viewModelModules,
                networkModules,
                repositoryModules
            ))
        }
    }

}