package com.example.cryptocurrency.domain.cryptocurrency

import com.example.cryptocurrency.data.database.cryptocurrency.CryptocurrencyEntity
import com.example.cryptocurrency.data.network.CryptocurrencyJson
import java.io.Serializable

data class Cryptocurrency(val id: Long, val name: String, val symbol: String) : Serializable {

    companion object {
        fun fromJson(cryptocurrencyJson: CryptocurrencyJson) =
            with(cryptocurrencyJson) { Cryptocurrency(id, name, symbol) }

        fun fromEntity(cryptocurrencyEntity: CryptocurrencyEntity) =
            with(cryptocurrencyEntity) { Cryptocurrency(id, name, symbol) }
    }

    fun toEntity() = CryptocurrencyEntity(id, name, symbol)

}