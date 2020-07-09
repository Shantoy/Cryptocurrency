package com.example.cryptocurrency.ui.cryptocurrencylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.databinding.CryptocurrencyListedBinding
import com.example.cryptocurrency.domain.cryptocurrency.Cryptocurrency

class CryptocurrencyListAdapter : ListAdapter<Cryptocurrency, CryptocurrencyListAdapter.ViewHolder>(
    CryptocurrencyListedDiffUtilCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        CryptocurrencyListedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        currentList.getOrNull(position)?.let { holder.bind(it) }
    }

    class ViewHolder(private val binding: CryptocurrencyListedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(lap: Cryptocurrency) {
            binding.model = CryptocurrencyListedViewModel(lap)
        }
    }

}