package com.example.zipcodeconverter

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    var retrofitService:RetrofitService
    init{

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.zippopotam.us/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitService = retrofit.create(RetrofitService::class.java)
    }
}