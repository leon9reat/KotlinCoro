package com.medialink.kotlincoro

import android.app.Application
import com.medialink.kotlincoro.injek.netModule
import com.medialink.kotlincoro.injek.retrofitServiceModule
import com.medialink.kotlincoro.injek.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(arrayListOf(viewModelModule, retrofitServiceModule, netModule))
        }
    }
}