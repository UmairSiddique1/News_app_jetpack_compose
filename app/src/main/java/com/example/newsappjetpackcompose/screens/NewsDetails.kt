package com.example.newsappjetpackcompose.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

class NewsDetails {
    companion object{
        @Composable
        fun NewsDetails(title:String,urlImage:String,content:String,url:String){
            val getTitle= remember{ mutableStateOf(title) }
            val getUrlImg= remember{ mutableStateOf(urlImage) }
            val getContent= remember{ mutableStateOf(content) }
            val context= LocalContext.current
Card(modifier = Modifier
    .fillMaxSize()
    .padding(10.dp)) {
    AsyncImage(model = getUrlImg.value, contentDescription = "")
Text(text = getTitle.value)
    Text(text = getContent.value)
    Button(onClick = {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        context.startActivity(intent)
    }, modifier = Modifier.padding(5.dp)) {
        Text(text = "Go to website")
    }
}
        }
    }
}