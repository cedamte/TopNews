package com.example.topnews.app

import android.app.Application
import com.example.topnews.BuildConfig
import com.example.topnews.di.AppComponent
import com.example.topnews.di.DaggerAppComponent
import timber.log.Timber


class TopNewsApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        appComponent.inject(this)
    }
}