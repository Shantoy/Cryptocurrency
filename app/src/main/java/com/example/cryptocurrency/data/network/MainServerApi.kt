package com.example.cryptocurrency.data.network

import retrofit2.Response
import retrofit2.http.GET

interface MainServerApi {

    @GET("fiat/map")
    suspend fun getCryptocurrencyList(): Response<FiatResponse>

}