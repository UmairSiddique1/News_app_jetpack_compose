package com.example.newsappjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.newsappjetpackcompose.Model.Articles
import com.example.newsappjetpackcompose.Model.MainModel
import com.example.newsappjetpackcompose.screens.MainScreen
import com.example.newsappjetpackcompose.screens.NewsDetails
import com.example.newsappjetpackcompose.ui.theme.NewsAppJetpackComposeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
ScreenMain()

        }
    }
}

@Composable
fun ScreenMain(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.route) {
        // First route : Home
        composable(Routes.Home.route) {

            MainScreen.MainUi(navController = navController)
        }
        composable(Routes.NewsDetail.route) {
            // Profile Screen
                val result=navController.previousBackStackEntry?.savedStateHandle?.get<Articles>("headlines")
            NewsDetails.NewsDetails(result?.title.toString(),result?.urlToImage.toString(),result?.content.toString()
            ,result?.url.toString())
        }

    }
    }