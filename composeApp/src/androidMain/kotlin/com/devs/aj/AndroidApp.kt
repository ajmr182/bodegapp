package com.devs.aj

import android.app.Application
import di.appModule
import di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidApp : Application() {

    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidContext(this@AndroidApp)
            androidLogger()
            modules(appModule, viewmodelModule)
        }
    }
}