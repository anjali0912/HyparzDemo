package com.example.hyparzdemo.di

import com.example.core.REST_CLIENT_MODULE
import com.example.core.RestClientModule
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal const val BASE_URL = "https://randomuser.me/"
const val TIME_OUT = 45L

val networkModule = module {

    single(named(REST_CLIENT_MODULE)) {
        RestClientModule.build(
            BASE_URL,
            RestClientModule.getClient(TIME_OUT)
        )
    }
}