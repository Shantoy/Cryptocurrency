package com.example.cryptocurrency.ui.cryptocurrencylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptocurrency.R
import com.example.cryptocurrency.ui.CryptocurrencyViewModel
import kotlinx.android.synthetic.main.fragment_cryptocurrency_list.*

class CryptocurrencyListFragment : Fragment() {

    private val viewModel: CryptocurrencyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_cryptocurrency_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvCryptocurrencyList.setHasFixedSize(true)
        val adapter = CryptocurrencyListAdapter()
        rvCryptocurrencyList.adapter = adapter
        rvCryptocurrencyList.layoutManager = LinearLayoutManager(context)
        viewModel.cryptocurrencies.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

}