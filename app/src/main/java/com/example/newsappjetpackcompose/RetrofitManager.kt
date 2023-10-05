package com.example.newsappjetpackcompose

import com.example.newsappjetpackcompose.ApiInterface.MyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getNewsApiService(): MyApi {
        return retrofit.create(MyApi::class.java)
    }

}