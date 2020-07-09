package com.example.cryptocurrency.ui.cryptocurrencydetailed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.cryptocurrency.R
import kotlinx.android.synthetic.main.fragment_cryptocurrency_detailed.*

class CryptocurrencyDetailedFragment : Fragment() {

    private val args: CryptocurrencyDetailedFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_cryptocurrency_detailed, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(args.cryptocurrency) {
            tvCryptocurrencyId.text = getString(R.string.cryptocurrency_id, id)
            tvCryptocurrencyName.text = getString(R.string.cryptocurrency_name, name)
            tvCryptocurrencySymbol.text = getString(R.string.cryptocurrency_symbol, symbol)
        }
    }

}