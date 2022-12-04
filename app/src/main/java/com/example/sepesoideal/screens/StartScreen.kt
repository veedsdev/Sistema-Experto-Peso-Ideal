package com.example.sepesoideal.screens


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sepesoideal.navigation.Screen
import com.example.sepesoideal.navigation.SeNavGraph
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi


@Composable
fun StartScreen(
) {

    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("SISTEMA EXPERTO")
                },
            )
        },
        bottomBar = {BottomBar(navController)}
    ) {

        SeNavGraph(navController = navController)

    }
}


@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            label = { Text(text = "Inicio") },
            selected = currentDestination?.hierarchy?.any {
                it.route == Screen.System.route
            } == true
            ,

            onClick = {
                selectedIndex.value = 0
                navController.navigate( Screen.System.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })


        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Info,"")
        },
            label = { Text(text = "Info") },
            selected = currentDestination?.hierarchy?.any {
                it.route == Screen.Info.route
            } == true,
            onClick = {
                selectedIndex.value = 1
                navController.navigate( Screen.Info.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    }
}
