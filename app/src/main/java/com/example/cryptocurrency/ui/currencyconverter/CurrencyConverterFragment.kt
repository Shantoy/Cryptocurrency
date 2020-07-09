package com.example.cryptocurrency.ui.currencyconverter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.cryptocurrency.R
import com.example.cryptocurrency.ui.CryptocurrencyViewModel
import kotlinx.android.synthetic.main.fragment_currency_converter.*

class CurrencyConverterFragment : Fragment() {

    private val viewModel: CryptocurrencyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_currency_converter, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        addTextChangedListener(etCryptocurrencyFirst)
        addTextChangedListener(etCryptocurrencySecond)
        createSpinnerAdapter(spinnerCurrencyConverterFirst)
        createSpinnerAdapter(spinnerCurrencyConverterSecond)
        ivCurrencyConverterArrow.setOnClickListener {
            etCryptocurrencyFirst.text = etCryptocurrencySecond.text.also {
                etCryptocurrencySecond.text = etCryptocurrencyFirst.text
            }
            val spinnerPosition = spinnerCurrencyConverterFirst.selectedItemPosition
            spinnerCurrencyConverterFirst.setSelection(spinnerCurrencyConverterSecond.selectedItemPosition)
            spinnerCurrencyConverterSecond.setSelection(spinnerPosition)
            spinnerCurrencyConverterSecond
        }
    }

    private fun addTextChangedListener(editText: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(str: CharSequence, start: Int, before: Int, count: Int) {
                if (str.isNotEmpty())
                    if (!str.contains(".")) editText.setText("$str.00")
            }

            override fun afterTextChanged(originalStr: Editable) {
                val rawStr = originalStr.toString()
                val indexRawStr = rawStr.indexOf(".")
                if (indexRawStr != -1) {
                    val tmpStr = rawStr.substring(indexRawStr)
                    if (tmpStr.length == 4)
                        originalStr.delete(originalStr.length - 1, originalStr.length)
                }
            }
        })
    }

    private fun createSpinnerAdapter(spinner: Spinner) {
        val adapter =
            ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                viewModel.cryptocurrencies.value!!.map { it.symbol }
            )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

}