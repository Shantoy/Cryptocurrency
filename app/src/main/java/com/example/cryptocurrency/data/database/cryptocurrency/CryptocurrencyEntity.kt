package com.example.cryptocurrency.data.database.cryptocurrency

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cryptocurrencyentity")
data class CryptocurrencyEntity(@PrimaryKey val id: Long, val name: String, val symbol: String)