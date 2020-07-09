package com.example.cryptocurrency.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cryptocurrency.data.database.DatabaseAgent
import com.example.cryptocurrency.data.network.NetworkAgent
import com.example.cryptocurrency.domain.cryptocurrency.Cryptocurrency
import com.example.cryptocurrency.domain.cryptocurrency.CryptocurrencyRepository
import com.example.cryptocurrency.utils.Result
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Response

class CryptocurrencyRepositoryImpl : CryptocurrencyRepository {

    private val api = NetworkAgent.api
    private val dao = DatabaseAgent.api.cryptocurrencyDao()

    private val _cryptocurrencies = MutableLiveData<List<Cryptocurrency>>()
    override val cryptocurrencies: LiveData<List<Cryptocurrency>> = _cryptocurrencies

    override suspend fun updateAllCryptocurrencies() {
        withContext(IO) {
            when (val result = safeApiResult { api.getCryptocurrencyList() }) {
                is Result.Error ->
                    _cryptocurrencies.postValue(dao.getAll().map { Cryptocurrency.fromEntity(it) })
                is Result.Success ->
                    with(result.data.data.map { Cryptocurrency.fromJson(it) }) {
                        _cryptocurrencies.postValue(this)
                        dao.save(this.map { it.toEntity() })
                    }
            }
        }
    }

    private suspend fun <T : Any> safeApiResult(call: suspend () -> Response<T>): Result<T> = try {
        val response = call.invoke()
        if (response.isSuccessful) Result.Success(response.body()!!)
        else Result.Error(Exception("Error"))
    } catch (e: Exception) {
        Result.Error(e)
    }

}