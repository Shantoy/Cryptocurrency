package com.example.cryptocurrency.domain.cryptocurrency

import androidx.lifecycle.LiveData

interface CryptocurrencyRepository {

    val cryptocurrencies: LiveData<List<Cryptocurrency>>

    suspend fun updateAllCryptocurrencies()

}