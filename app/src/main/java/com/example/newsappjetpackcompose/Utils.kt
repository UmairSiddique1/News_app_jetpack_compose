package com.example.newsappjetpackcompose

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.newsappjetpackcompose.Model.Articles
import com.example.newsappjetpackcompose.Model.MainModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Utils {
    companion object{
        @Composable
        fun getData(list:MutableList<Articles>){
            val context= LocalContext.current
            val apiKey="aa0af3af8bbb4442a1bada910b60195b"
            RetrofitManager().getNewsApiService().getTopHeadlines(apiKey = apiKey).enqueue(object :
                Callback<MainModel> {
                override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {

                    val data=response.body()
                    if (data != null) {
                        for(item in 0 until data.totalResults){
                            val items=data.articles[item]
                            list.addAll(listOf(Articles(items.author,items.title,items.url, items.urlToImage,items.content)))
                        }
                    }

                    Toast.makeText(context, data!!.totalResults.toString(), Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    Toast.makeText(context,"failure", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}