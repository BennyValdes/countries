package com.example.countries.model

import com.example.countries.model.local.Country
import com.example.countries.model.remote.ApiServices
import java.io.IOException

interface CountryRepository {
    suspend fun getCountries(): Result<List<Country>>
}

class CountryRepositoryImpl(private val api: ApiServices): CountryRepository {
    override suspend fun getCountries(): Result<List<Country>> {
        return api.getCountries().runCatching {
            if (isSuccessful){
                checkNotNull(body()).map {
                    Country(it.name, it.region, it.code, it.capital)
                }
            }
            else {
                throw with(errorBody()){
                    IOException("Fail in api call ${code()}, ${this?.string() ?: message()}")
                }
            }
        }
    }

}