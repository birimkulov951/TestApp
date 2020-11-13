package com.example.testapp.model


import com.google.gson.annotations.SerializedName

data class RetailPriceX(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currencyCode")
    val currencyCode: String
)