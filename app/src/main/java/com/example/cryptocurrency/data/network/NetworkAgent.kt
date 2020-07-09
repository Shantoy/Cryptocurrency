package com.example.cryptocurrency.data.network

import com.example.cryptocurrency.application.ThisApp
import com.example.cryptocurrency.utils.Serdes
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkAgent {

    private const val MAIN_SERVER_URL = "https://pro-api.coinmarketcap.com/v1/"

    private val rawOkHttpClient: OkHttpClient = OkHttpClient.Builder()
        .dispatcher(Dispatcher(ThisApp.executors))
        .build()

    val api: MainServerApi by lazy {
        val client = rawOkHttpClient.newBuilder()
            .addInterceptor {
                val requestBuilder = it.request().newBuilder()
                requestBuilder.addHeader(
                    "X-CMC_PRO_API_KEY",
                    "cf88a3c8-067d-4925-89f0-78c2261dad8c"
                )
                it.proceed(requestBuilder.build())
            }
            .build()
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(MAIN_SERVER_URL)
            .addConverterFactory(MoshiConverterFactory.create(Serdes.moshi))
            .build()
        return@lazy retrofit.create(MainServerApi::class.java)
    }

}