package com.example.sepesoideal.navigation

sealed class Screen(val route : String) {
    object System : Screen(route = "system_screen")
    object Info : Screen(route = "info_screen")
    object Main : Screen(route = "main_screen")


    object Mantenerse : Screen(route = "mantenerse_screen")
    object BajarDePeso : Screen(route = "bajar_screen")
    object Tonificar : Screen(route = "tonificar_screen")

}