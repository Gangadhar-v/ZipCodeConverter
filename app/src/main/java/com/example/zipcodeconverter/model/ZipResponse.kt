package com.example.zipcodeconverter.model

import com.google.gson.annotations.SerializedName

data class ZipResponse(

    val country: String,
    @SerializedName("country abbreviation")
    val country_abbreviation: String,
    val places: List<Place>,
    val post_code: String
)