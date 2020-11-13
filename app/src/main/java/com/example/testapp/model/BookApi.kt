package com.example.testapp.model


import com.google.gson.annotations.SerializedName

data class BookApi(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)