package com.example.newsappjetpackcompose.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Articles(val author:String,val title:String,val url:String, val urlToImage: String
,val content:String) : Parcelable
