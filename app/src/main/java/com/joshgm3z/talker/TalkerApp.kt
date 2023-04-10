package com.joshgm3z.talker

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TalkerApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TalkerApp)
            modules(appModule)
        }
    }

}