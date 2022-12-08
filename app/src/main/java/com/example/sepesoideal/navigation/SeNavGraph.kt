package com.example.sepesoideal.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.sepesoideal.screens.InfoScreen
import com.google.accompanist.pager.ExperimentalPagerApi

import com.example.sepesoideal.screens.StartScreen
import com.example.sepesoideal.screens.SystemScreen
import com.example.sepesoideal.screens.info.BajarInfoScreen
import com.example.sepesoideal.screens.info.MantenerseInfoScreen
import com.example.sepesoideal.screens.info.TonificarInfoScreen
import com.example.sepesoideal.screens.rutinas.RutinTonificar
import com.example.sepesoideal.screens.rutinas.RutinaBajar
import com.example.sepesoideal.screens.rutinas.RutinaMantenerse


@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SeNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.System.route
    ) {
        composable(route = Screen.System.route) {
            SystemScreen(navController = navController)
        }
        composable(route = Screen.Info.route) {
            InfoScreen(navController = navController)
        }
        composable(route = Screen.Main.route) {
            StartScreen()
        }


        composable(route = Screen.Mantenerse.route) {
            RutinaMantenerse(navController = navController)
        }
        composable(route = Screen.BajarDePeso.route) {
            RutinaBajar(navController = navController)
        }
        composable(route = Screen.Tonificar.route) {
            RutinTonificar(navController = navController)
        }


        composable(route = Screen.MantenerseInfo.route) {
            MantenerseInfoScreen(navController = navController)
        }
        composable(route = Screen.TonificarInfo.route) {
            TonificarInfoScreen(navController = navController)
        }
        composable(route = Screen.BajarDePesoInfo.route) {
            BajarInfoScreen(navController = navController)
        }



    }
}