package com.example.zipcodeconverter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zipcodeconverter.databinding.ActivityMainBinding
import com.example.zipcodeconverter.model.ZipResponse

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countriesMap = mapOf(
            "Bharat" to "IN",
            "Paapistan" to	"PK",
            "Bondadesh"	to "BD",
            "Russia" to	"RU",
            "United States"	to "US",
            "New Zealand" to 	"NZ",
            "Australia"	to "AU",

        )

        val countryNames = countriesMap.keys.toList()
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,
            countryNames)

        binding.countriesSp.adapter = adapter

        binding.btn.setOnClickListener {

            val selectedCountry = binding.countriesSp.selectedItem.toString()
            val countryId = countriesMap[selectedCountry]
            val zipcode = binding.editText.text.toString().trim()
            if(!zipcode.isNullOrEmpty()){

                if (countryId != null) {
                    getDetails(countryId,zipcode)
                }
            }else{
                binding.editText.error = "please fill this field"
            }
        }


    }
    fun getDetails( countryId:String,zipCode:String) {
        val call = RetrofitInstance.retrofitService.getData(countryId,zipCode)
        call.enqueue(object : retrofit2.Callback<ZipResponse> {
            override fun onResponse(
                call: retrofit2.Call<ZipResponse>,
                response: retrofit2.Response<ZipResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()
                    val places = data?.places
                    if (places != null) {
                        val adapter = ZipAdapter(places)
binding.recylcerView.adapter = adapter
                        binding.recylcerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<ZipResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Error: ${t.message}",Toast.LENGTH_SHORT).show()
            }
        })

}
    }