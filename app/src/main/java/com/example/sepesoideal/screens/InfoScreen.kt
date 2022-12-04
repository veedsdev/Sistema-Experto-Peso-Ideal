package com.example.sepesoideal.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sepesoideal.navigation.Screen
import com.example.sepesoideal.ui.theme.SEPesoIdealTheme

@Composable
fun InfoScreen(
    navController: NavHostController
) {
    val scrollState = rememberScrollState()
    Scaffold() {
        Box(Modifier.fillMaxSize().verticalScroll(scrollState).padding(bottom = 60.dp)) {
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
            ) {
                Row(modifier = Modifier.padding(start = 12.dp, top = 20.dp)) {
                    Text(
                        text = "Información",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = MaterialTheme.colors.primary
                    )
                }
                //MANTENERSE
                OptionMenu(
                    titleOption = "Rutinas Mantenerse",
                    descriptionOption = "Ejercicios Peso Ideal - Mantenerse",
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 8.dp)
                        .clickable(onClick = {
                            navController.navigate(Screen.Mantenerse.route)
                        })
                        .fillMaxWidth()
                )

                //MANTENERSE
                OptionMenu(
                    titleOption = "Rutinas Bajar Peso",
                    descriptionOption = "Ejercicios Sobre Peso - Bajar Peso",
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 8.dp)
                        .clickable(onClick = {
                            navController.navigate(Screen.BajarDePeso.route)
                        })
                        .fillMaxWidth()
                )
                //MANTENERSE
                OptionMenu(
                    titleOption = "Rutinas Tonificar",
                    descriptionOption = "Ejercicios Peso Ideal - Sacar Músculo",
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 8.dp)
                        .clickable(onClick = {
                            navController.navigate(Screen.Tonificar.route)
                        })
                        .fillMaxWidth()
                )

            }
        }
    }
}

@Composable
fun OptionMenu(
    titleOption: String,
    descriptionOption: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.padding(start = 18.dp)) {
            Row {

                Text(
                    text = titleOption,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )


            }
            Row {
                Text(
                    text = descriptionOption,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun AdminSettingsScreenPreview() {
    SEPesoIdealTheme {
        val navController = rememberNavController()
        InfoScreen(navController)
    }
}