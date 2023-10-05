package com.example.newsappjetpackcompose

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object NewsDetail : Routes("newsDetail")
}
