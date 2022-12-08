package com.example.sepesoideal.screens.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sepesoideal.R

@Composable
fun TonificarInfoScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    Box(
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(bottom = 60.dp)) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
        ) {
            Row(modifier = Modifier.padding(start = 12.dp, top = 20.dp)) {
                Text(
                    text = "Tonificar",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = MaterialTheme.colors.primary
                )
            }
            Row(modifier = Modifier.padding(start = 12.dp, top = 20.dp)) {
                Image(
                    modifier = Modifier,
                    // .width(250.dp)
                    //.size(550.dp),
                    painter = painterResource(id = R.drawable.tonificar),
                    contentDescription = null,
                )
            }

        }

    }
}