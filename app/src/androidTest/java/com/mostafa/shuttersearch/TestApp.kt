package com.mostafa.shuttersearch

import android.app.Application
import com.mostafa.shuttersearch.di.roomTestModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TestApp)
            modules(roomTestModule)
        }
    }

}