package com.example.sepesoideal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.sepesoideal.screens.StartScreen
import com.example.sepesoideal.ui.theme.SEPesoIdealTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SEPesoIdealTheme {
                //val navController = rememberNavController()
                StartScreen()
            }
        }
    }

}
