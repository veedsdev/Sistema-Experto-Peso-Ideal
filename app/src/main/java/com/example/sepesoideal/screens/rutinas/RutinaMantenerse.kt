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



data class Mantener(var parteCuerpo:String, var ejercicio:String, var serie: Int, var repeticiones: Int)


fun setEjercicioMantener() : Mantener{
    val ejercicios = listOf(
        Mantener("Quadriceps/Gluteo","Leg Press (Prensa)", 3,5),
        Mantener("Biceps Femoral","Maquina de Biceps Femoral", 3,5),
        Mantener("Espalda Superior","Remo con Cable Sentado", 3,5),
        Mantener("Pecho","Pecho en Banco Plano", 3,5),
        Mantener("Hombros","Hombro con Mancuernas", 3,5),
        Mantener("Trapecios ","Encogimiento con Mancuerna", 3,5),
        Mantener("Triceps","Triceps con Cable (Pushdown)", 3,5),
        Mantener("Biceps","Biceps con Barra ", 3,5),
        Mantener("Espalda Baja","Extensiones de Espalda", 3,5),
        Mantener("Pantorillas","Pantorrillas Parado", 3,5),
        Mantener("Ante Brazo","Encogimiento de muñeca con Barra", 3,5),
        Mantener("Abdominales","Encogimientos", 3,5),
    )
    val rnd = (0..ejercicios.size - 1).random()
    return ejercicios.get(rnd)
}



@Composable
fun RutinaMantenerse(navController: NavHostController){
    var ejercicio = setEjercicioMantener()
    val scrollState = rememberScrollState()
    Box(Modifier.fillMaxSize().verticalScroll(scrollState).padding(bottom = 60.dp)) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp,end=12.dp)
        ) {
            Row(modifier = Modifier.padding(start = 12.dp, top = 20.dp)) {
                Text(
                    text = "Mantenerse",
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
                    painter = painterResource(id = R.drawable.mantenerse),
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