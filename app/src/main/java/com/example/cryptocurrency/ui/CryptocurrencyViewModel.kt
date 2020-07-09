package com.example.cryptocurrency.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.application.ThisApp
import com.example.cryptocurrency.domain.cryptocurrency.Cryptocurrency
import kotlinx.coroutines.launch

class CryptocurrencyViewModel : ViewModel() {

    private val _cryptocurrencies = ThisApp.cryptocurrencyRepository.cryptocurrencies
    val cryptocurrencies: LiveData<List<Cryptocurrency>> = _cryptocurrencies

    init {
        updateAllCryptocurrencies()
    }

    private fun updateAllCryptocurrencies() {
        viewModelScope.launch {
            ThisApp.cryptocurrencyRepository.updateAllCryptocurrencies()
        }
    }

}