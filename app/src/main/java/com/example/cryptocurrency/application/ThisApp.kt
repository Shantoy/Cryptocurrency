package com.example.cryptocurrency.application

import android.app.Application
import com.example.cryptocurrency.data.repository.CryptocurrencyRepositoryImpl
import com.example.cryptocurrency.domain.cryptocurrency.CryptocurrencyRepository
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ThisApp : Application() {

    companion object {
        lateinit var app: ThisApp
        lateinit var executors: ExecutorService
        lateinit var cryptocurrencyRepository: CryptocurrencyRepository
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        executors = Executors.newCachedThreadPool()
        cryptocurrencyRepository = CryptocurrencyRepositoryImpl()
    }

}