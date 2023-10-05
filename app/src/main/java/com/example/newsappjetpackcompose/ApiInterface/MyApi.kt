package com.example.newsappjetpackcompose.ApiInterface

import com.example.newsappjetpackcompose.Model.MainModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

@GET("top-headlines")
fun getTopHeadlines(
    @Query("sources") sources: String = "bbc-news",
    @Query("apiKey") apiKey: String
):Call<MainModel>
}