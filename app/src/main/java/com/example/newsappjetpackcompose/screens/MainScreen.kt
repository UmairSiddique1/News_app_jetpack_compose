package com.example.newsappjetpackcompose.screens

import android.content.Intent
import android.net.Uri
import android.os.Parcelable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.newsappjetpackcompose.Model.Articles
import com.example.newsappjetpackcompose.Routes
import com.example.newsappjetpackcompose.Utils
import kotlinx.parcelize.Parcelize


class MainScreen {
    companion object{
        @Composable
        fun MainUi(navController: NavController){
            val list= remember {
                mutableStateListOf<Articles>()
            }
            Utils.getData(list = list)

            LazyColumn{
                items(list.size){getTopHeadlines->
                    val title= remember { mutableStateOf(list[getTopHeadlines].title) }
                    val author= remember { mutableStateOf(list[getTopHeadlines].author) }
                    val urlImage= remember { mutableStateOf(list[getTopHeadlines].urlToImage) }
                    val content= remember { mutableStateOf(list[getTopHeadlines].content) }
                    val url= remember { mutableStateOf(list[getTopHeadlines].url) }
                    Card(modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .clickable {
                            val article = Articles(author.value, title.value, url.value, urlImage.value, content.value)
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                key = "headlines",
                                value = article
                            )
                            navController.navigate(Routes.NewsDetail.route)
                        }, border = BorderStroke(3.dp, Color.Cyan)
                    ) {
                        AsyncImage(model =urlImage.value, contentDescription = "News Image")
                        Text(text = title.value, fontStyle = FontStyle.Normal
                            , fontWeight = FontWeight(4)
                        )
                        Text(text =content.value, fontStyle = FontStyle.Italic
                            , fontWeight = FontWeight(2)
                        )
                    }
                }
            }
        }

    }
}