package com.example.countries.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.model.local.Country
import com.example.countries.databinding.ItemCountryBinding

class CountryViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val binding = ItemCountryBinding.bind(view)

    fun render(countryModel: Country){
        binding.tvCountry.text = countryModel.name
        binding.tvRegion.text = countryModel.region
        binding.tvCode.text = countryModel.code
        binding.tvCapital.text = countryModel.capital
    }
}