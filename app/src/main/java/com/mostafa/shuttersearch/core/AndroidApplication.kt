package com.mostafa.shuttersearch.core

import android.app.Application
import com.mostafa.shuttersearch.core.di.networkModule
import com.mostafa.shuttersearch.core.di.searchModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AndroidApplication)
            modules(listOf(networkModule, searchModule))
        }
    }
}