package com.example.cryptocurrency.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cryptocurrency.data.database.cryptocurrency.CryptocurrencyDao
import com.example.cryptocurrency.data.database.cryptocurrency.CryptocurrencyEntity

@Database(
    entities = [CryptocurrencyEntity::class], version = 1
)
abstract class DatabaseApi : RoomDatabase() {
    abstract fun cryptocurrencyDao(): CryptocurrencyDao
}