package com.example.zipcodeconverter

import com.example.zipcodeconverter.model.ZipResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService{


     @GET("{country}/{zipcode}")
     fun getData(@Path("country") country:String, @Path("zipcode") zipcode:String): Call<ZipResponse>


}