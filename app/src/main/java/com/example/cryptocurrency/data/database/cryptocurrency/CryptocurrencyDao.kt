package com.example.cryptocurrency.data.database.cryptocurrency

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CryptocurrencyDao {

    @Query("SELECT * FROM cryptocurrencyEntity")
    suspend fun getAll(): List<CryptocurrencyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(cryptocurrencies: Collection<CryptocurrencyEntity>)

}