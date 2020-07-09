package com.example.cryptocurrency.data.network

data class FiatResponse(
    val data: List<CryptocurrencyJson>,
    val status: Status
)

data class Status(
    var timestamp: String?,
    var error_code: Float,
    var error_message: String?,
    var elapsed: Float,
    var credit_count: Float
)

data class CryptocurrencyJson(
    val id: Long,
    val name: String,
    val sign: String,
    val symbol: String
)