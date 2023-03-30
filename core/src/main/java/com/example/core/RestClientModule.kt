package com.example.core

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RestClientModule {

    fun build(
        baseUrl: String,
        client: OkHttpClient,
        listConverterFactory: List<Converter.Factory> = listOf(GsonConverterFactory.create())
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .apply { listConverterFactory.forEach { addConverterFactory(it) } }
        .build()

    val loggingInterceptor = HttpLoggingInterceptor()
        .apply { level = HttpLoggingInterceptor.Level.BODY }

    fun getClient(
        timeOut: Long,
        listInterceptor: List<Interceptor> = listOf(loggingInterceptor)
    ): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(timeOut, TimeUnit.SECONDS)
        .writeTimeout(timeOut, TimeUnit.SECONDS)
        .connectTimeout(timeOut, TimeUnit.SECONDS)
        .apply { listInterceptor.forEach { addInterceptor(it) } }
        .build()
}