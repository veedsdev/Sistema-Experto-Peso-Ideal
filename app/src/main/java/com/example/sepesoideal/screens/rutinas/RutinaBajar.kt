package com.example.sepesoideal.screens.rutinas

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


data class Bajar(var parteCuerpo:String, var ejercicio:String, var serie: Int, var repeticiones: Int)


fun setEjercicioBajar() : Bajar{
    val ejercicios = listOf(
        Bajar("Quadriceps/Gluteo","Leg Press (Prensa)", 4,7),
        Bajar("Biceps Femoral","Maquina de Biceps Femoral", 4,7),
        Bajar("Espalda Superior","Remo con Cable Sentado", 5,7),
        Bajar("Pecho","Pecho en Banco Plano", 4,7),
        Bajar("Hombros","Hombro con Mancuernas", 4,7),
        Bajar("Trapecios ","Encogimiento con Mancuerna", 4,7),
        Bajar("Triceps","Triceps con Cable (Pushdown)", 4,7),
        Bajar("Biceps","Biceps con Barra ", 4,7),
        Bajar("Espalda Baja","Extensiones de Espalda", 4,7),
        Bajar("Pantorillas","Pantorrillas Parado", 4,7),
        Bajar("Ante Brazo","Encogimiento de muñeca con Barra", 3,7),
        Bajar("Abdominales","Encogimientos", 4,7),
    )
    val rnd = (0..ejercicios.size - 1).random()
    return ejercicios.get(rnd)
}








@Composable
fun RutinaBajar(navController: NavHostController){
    var ejercicio = setEjercicioBajar()
    val scrollState = rememberScrollState()
    Box(Modifier.fillMaxSize().verticalScroll(scrollState).padding(bottom = 60.dp)) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp,end=12.dp)
        ) {
            Row(modifier = Modifier.padding(start = 12.dp, top = 20.dp)) {
                Text(
                    text = "Bajar Peso",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = MaterialTheme.colors.primary
                )
            }
            Row(modifier = Modifier.padding(start = 12.dp, top = 20.dp)){
                Image(
                    modifier = Modifier,
                    // .width(250.dp)
                    //.size(550.dp),
                    painter = painterResource(id = R.drawable.bajar),
                    contentDescription = null,
                )
            }

            if(true){
                Row(modifier = Modifier.padding(start = 12.dp, top = 20.dp))
                {
                    Text(text= "Ejercicio a hacer: ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,)
                }
                Row (modifier = Modifier.padding(start = 12.dp)){
                    Text (text = "Parte del cuerpo: ${ejercicio.parteCuerpo} \nEjercicio: ${ejercicio.ejercicio}\n" +
                            "Serie: ${ejercicio.serie}\nRepeticiones:${ejercicio.repeticiones}")
                }
            }

        }

    }
}