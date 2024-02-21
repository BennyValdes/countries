package com.example.countries.model.remote

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServices {

    companion object {
        val service: ApiServices by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServices::class.java)
        }
    }

    @GET(END_POINT)
    suspend fun getCountries(): Response<List<CountriesResponse>>
}