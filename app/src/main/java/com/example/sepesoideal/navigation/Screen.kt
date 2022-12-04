package com.example.sepesoideal.navigation

sealed class Screen(val route : String) {
    object Start : Screen(route = "start_screen")
}