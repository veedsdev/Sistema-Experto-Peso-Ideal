package com.example.sepesoideal.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi

import com.example.sepesoideal.screens.StartScreen


@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SeNavGraph(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Start.route) {
            StartScreen(navController = navController)
        }
    }
}