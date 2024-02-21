package com.example.countries.model.remote

import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    @SerializedName("capital")
    val capital: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("currency")
    val currency: CurrencyData,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("language")
    val language: LanguageData
)
data class CurrencyData(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)
data class LanguageData(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String
)
