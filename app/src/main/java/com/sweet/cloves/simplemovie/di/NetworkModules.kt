package com.sweet.cloves.simplemovie.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.sweet.cloves.simplemovie.BuildConfig
import com.sweet.cloves.simplemovie.network.ApiService
import com.sweet.cloves.simplemovie.network.interceptor.NoConnectionInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModules = module {
    val baseUrl = BuildConfig.BASE_URL

    singleOf(::NoConnectionInterceptor)
    singleOf(::provideHttpLoggingInterceptor)
    singleOf(::provideHttpClient)

    single {
        createService<ApiService>(
            get(),
            baseUrl
        )
    }
}

private fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor, connectionInterceptor: NoConnectionInterceptor): OkHttpClient {
    val client = OkHttpClient.Builder()
    client.connectTimeout(60, TimeUnit.SECONDS)
    client.writeTimeout(60, TimeUnit.SECONDS)
    client.readTimeout(60, TimeUnit.SECONDS)
    if (BuildConfig.DEBUG) client.addInterceptor(loggingInterceptor)
    client.addInterceptor(connectionInterceptor)

    return client.addInterceptor {
        val original = it.request()
        val requestBuilder = original.newBuilder()
        requestBuilder.header("Content-Type", "application/json")
        requestBuilder.header("Accept", "application/json")
        val request = requestBuilder
            .method(original.method, original.body)
            .build()
        return@addInterceptor it.proceed(request)
    }.build()
}

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
}

/**
 * create service use retrofit
 */
inline fun <reified T> createService(okHttpClient: OkHttpClient, baseUrl: String): T {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}