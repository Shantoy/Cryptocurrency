package com.example.cryptocurrency.ui.cryptocurrencylist

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.cryptocurrency.domain.cryptocurrency.Cryptocurrency

class CryptocurrencyListedViewModel(val cryptocurrency: Cryptocurrency) : ViewModel() {

    fun onCryptocurrencyClick(view: View) {
        Navigation.findNavController(view).navigate(
            CryptocurrencyListFragmentDirections.actionToCryptocurrencyDetailedFragment(
                cryptocurrency
            )
        )
    }

}