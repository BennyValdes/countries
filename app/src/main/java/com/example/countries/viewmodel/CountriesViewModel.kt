package com.example.countries.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.model.CountryRepository
import com.example.countries.model.CountryRepositoryImpl
import com.example.countries.model.local.Country
import com.example.countries.model.remote.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.annotations.VisibleForTesting

class CountriesViewModel : ViewModel() {

    val service: ApiServices by lazy {
        ApiServices.service
    }

    val repository: CountryRepository by lazy {
        CountryRepositoryImpl(service)
    }

    private val _countryData: MutableLiveData<List<Country>> = MutableLiveData()
    val countryData: LiveData<List<Country>>
        get() = _countryData

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            val result = repository.getCountries()
            println("This is the error: ${result.getOrNull()}")
            when (result.getOrNull()) {
                null -> throw Exception()
                else -> _countryData.value = result.getOrNull()
            }
        }
    }
}