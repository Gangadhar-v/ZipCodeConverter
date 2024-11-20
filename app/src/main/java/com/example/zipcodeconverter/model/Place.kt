package com.example.zipcodeconverter.model

import com.google.gson.annotations.SerializedName

data class Place(
    val latitude: String,
    val longitude: String,
    @SerializedName("place name")
    val place_name: String,
    val state: String,
    @SerializedName("state abbreviation")
    val state_abbreviation: String
)