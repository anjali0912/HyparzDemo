package com.example.hyparzdemo

import android.app.Application
import com.example.data.di.apiModule
import com.example.data.di.mapperModule
import com.example.data.di.repositoryModule
import com.example.data.di.sourceModule
import com.example.domain.di.useCaseModule
import com.example.hyparzdemo.di.networkModule
import com.example.hyparzdemo.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HyparzDemo : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@HyparzDemo)
            modules(
                listOf(
                    apiModule,
                    networkModule,
                    presentationModule,
                    useCaseModule,
                    repositoryModule,
                    sourceModule,
                    mapperModule,
                )
            )
        }
    }
}