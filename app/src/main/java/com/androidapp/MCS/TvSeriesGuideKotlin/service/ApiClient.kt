package com.androidapp.MCS.TvSeriesGuideKotlin.service

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {


    val WRITE_TIMEOUT = 60
    val READ_TIMEOUT = 30
    val CONNECT_TIMEOUT = 30

    private val GIT_API_URL = "http://www.omdbapi.com/"

    val imdbApi: IMDBApi by lazy { buildRetrofitWithInterceptors().create(IMDBApi::class.java) }

    private fun buildRetrofitWithInterceptors(): Retrofit {
        val okBuilder = OkHttpClient.Builder()
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)

        val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            Log.v(ApiClient::class.java.simpleName, message)
        })
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okBuilder.addInterceptor(loggingInterceptor)

        val okHttpClient = okBuilder.build()

        val builder = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(GIT_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        return builder.build()
    }
}