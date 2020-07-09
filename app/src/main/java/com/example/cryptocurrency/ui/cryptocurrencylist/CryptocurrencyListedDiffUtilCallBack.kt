package com.example.cryptocurrency.ui.cryptocurrencylist

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptocurrency.domain.cryptocurrency.Cryptocurrency

class CryptocurrencyListedDiffUtilCallBack : DiffUtil.ItemCallback<Cryptocurrency>() {

    // TODO: add implementation
    override fun areItemsTheSame(old: Cryptocurrency, new: Cryptocurrency) = false

    override fun areContentsTheSame(old: Cryptocurrency, new: Cryptocurrency) = false

}