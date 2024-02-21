package com.example.countries.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.model.local.Country
import com.example.countries.R

class CountryAdapter(private var countriesList: List<Country>) : RecyclerView.Adapter<CountryViewHolder>() {

    fun updateDataSet(newDataSet: List<Country>) {
        countriesList = newDataSet
        notifyItemRangeChanged(0, newDataSet.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CountryViewHolder(layoutInflater.inflate(R.layout.item_country, parent, false))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = countriesList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = countriesList.size
}