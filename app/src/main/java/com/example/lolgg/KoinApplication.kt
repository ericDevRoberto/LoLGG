package com.example.lolgg

import android.app.Application
import com.example.lolgg.di.dataModule
import com.example.lolgg.di.domainModule
import com.example.lolgg.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApplication)

            modules(
                listOf(
                    presentationModule,
                    dataModule,
                    domainModule,
                )
            )
        }
    }
}