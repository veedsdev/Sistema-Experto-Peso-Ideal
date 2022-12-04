package com.example.sepesoideal.screens

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sepesoideal.model.Person
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi

var person = Person(0, 0, "")

@Composable
fun StartScreen(
    navController: NavHostController
) {


    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp, top = 20.dp, end = 12.dp)
                .fillMaxWidth()
        ) {
            Row(modifier = Modifier.padding(bottom = 20.dp)) {
                Text(
                    text = "PESO IDEAL",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = MaterialTheme.colors.primary
                )
            }


            var primerPregunta by remember { mutableStateOf(true) }
            var llenarDatos by remember { mutableStateOf(false) }
            var datosRecibidos by remember { mutableStateOf(false) }

            if (primerPregunta) {
                Row {
                    Text(
                        text = "¿Qué deseas realizar?",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(4.dp),
                        color = Color.Black
                    )
                }
                Row {
                    Column {
                        Button({
                            primerPregunta = false
                            llenarDatos = true
                        }) {
                            Text(text = "Bajar de peso")
                        }
                    }
                    Column {
                        Button({
                            primerPregunta = false
                            llenarDatos = true
                        }) {
                            Text(text = "Mantenerse")
                        }
                    }
                    Column {
                        Button({
                            primerPregunta = false
                            llenarDatos = true
                        }) {
                            Text(text = "Tonificar")
                        }
                    }
                }
            }



            if (llenarDatos) {
                datosRecibidos = LlenarDatos()
            }
            if (datosRecibidos) {
                Condiciones()
            }


        }
    }
}

@OptIn(
    ExperimentalAnimationApi::class, ExperimentalPagerApi::class, ExperimentalMaterialApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun Condiciones() {
    Row(modifier = Modifier.padding(top = 20.dp)) {
        Text(
            text = "Condiciones",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }

    if (person.sexo == "Femenino") {

        if (person.estatura >= 144 && person.estatura <= 150 && person.peso >= 49 && person.peso <= 56) {
            PesoIdeal()
            Mantenerse()
        }

        else if (person.estatura >= 144 && person.estatura <= 150 && person.peso > 56) {
            SobrePeso()
            BajarDePeso()
        }

        else if (person.estatura >= 150 && person.estatura <= 155 && person.peso >= 51 && person.peso <= 59) {
            PesoIdeal()
            Mantenerse()
        }

        else if (person.estatura >= 150 && person.estatura <= 155 && person.peso > 59) {
            SobrePeso()
            BajarDePeso()
        }

        else if (person.estatura >= 156 && person.estatura <= 160 && person.peso >= 54 && person.peso <= 61) {
            PesoIdeal()
            Mantenerse()
        }

        else if (person.estatura >= 156 && person.estatura <= 160 && person.peso >61) {
            SobrePeso()
            BajarDePeso()
        }

        else if (person.estatura >= 161 && person.estatura <= 165 && person.peso >= 56 && person.peso <= 64) {
            PesoIdeal()
            Mantenerse()
        }

        else if (person.estatura >= 161 && person.estatura <= 165 && person.peso >64) {
            SobrePeso()
            BajarDePeso()
        }

        else if (person.estatura >= 166 && person.estatura <= 170 && person.peso >= 59 && person.peso <= 67) {
            PesoIdeal()
            Mantenerse()
        }

        else if (person.estatura >= 166 && person.estatura <= 170 && person.peso >67) {
            SobrePeso()
            BajarDePeso()
        }

        else if (person.estatura >= 171 && person.estatura <= 175 && person.peso >= 62 && person.peso <= 70) {
            PesoIdeal()
            Mantenerse()
        }
        else if (person.estatura >= 171 && person.estatura <= 175 && person.peso >70) {
            SobrePeso()
            BajarDePeso()
        }

        else if (person.estatura >= 176 && person.estatura <= 180 && person.peso >= 60 && person.peso <= 72) {
            PesoIdeal()
            Mantenerse()
        }

        else if (person.estatura >= 176 && person.estatura <= 180 && person.peso >72) {
            SobrePeso()
            BajarDePeso()
        }


    }

}



@Composable
fun SobrePeso(){
    Row() {
        Text(
            text = "Sobre Peso",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }
}

@Composable
fun PesoIdeal(){
    Row() {
        Text(
            text = "Peso Ideal",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }
}

@Composable
fun Mantenerse() {
    Row() {
        Text(
            text = "Rutina Mantenerse",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }
}

@Composable
fun BajarDePeso() {
    Row() {
        Text(
            text = "Rutina Bajar de peso",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }
}


@OptIn(
    ExperimentalAnimationApi::class, ExperimentalPagerApi::class, ExperimentalMaterialApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun LlenarDatos(): Boolean {


    var sexo by remember { mutableStateOf("") }
    var estatura by remember { mutableStateOf(0) }
    var peso by remember { mutableStateOf(0) }

    var showSexo by remember { mutableStateOf(true) }
    var showEstatura by remember { mutableStateOf(false) }
    var showPeso by remember { mutableStateOf(false) }
    var showData by remember { mutableStateOf(false) }
    var datosEnviados by remember { mutableStateOf(false) }

    if (showSexo) {

        Row() {
            Text(
                text = "Seleccione sexo",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(4.dp),
                color = Color.Black
            )
        }

        Row {
            Column {
                Button({
                    sexo = "Masculino"
                    showSexo = false
                    showEstatura = true
                }) {
                    Text(text = "Hombre")
                }
            }
            Column {
                Button({
                    sexo = "Femenino"
                    showSexo = false
                    showEstatura = true
                }) {
                    Text(text = "Mujer")
                }
            }
        }
    }


    if (showEstatura) {
        Row() {
            Text(
                text = "Seleccione estatura",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(4.dp),
                color = Color.Black
            )
        }


        Row {
            Column {


                var options = ArrayList<Int>()
                if (sexo == "Masculino") {
                    for (i in 155..190) {
                        options.add(i)
                    }
                }

                if (sexo == "Femenino") {
                    for (i in 144..180) {
                        options.add(i)
                    }
                }


                var expanded by remember { mutableStateOf(false) }
                var selectedOptionText by remember { mutableStateOf(options[0]) }

                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                    }
                ) {

                    TextField(
                        readOnly = true,
                        value = selectedOptionText.toString(),
                        onValueChange = { },
                        label = { Text("Estatura") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expanded
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        }
                    ) {

                        options.forEach { selectionOption ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedOptionText = selectionOption
                                    estatura = selectionOption
                                    expanded = false
                                }
                            ) {
                                Text(text = selectionOption.toString())
                            }
                        }
                    }
                }


            }
        }
        Row() {
            Button({
                person.sexo = sexo
                person.peso = 0
                Log.d("estatura", estatura.toString())
                person.estatura = estatura
                Log.d("PERSONA", person.toString())
                showEstatura = false
                showPeso = true
            }) {
                Text(text = "Aceptar")
            }
        }
    }




    if (showPeso) {
        Row() {
            Text(
                text = "Seleccione peso",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(4.dp),
                color = Color.Black
            )
        }


        Row {
            Column {


                var optionsPeso = ArrayList<Int>()
                if (sexo == "Femenino") {
                    for (i in 49..72) {
                        optionsPeso.add(i)
                    }
                }

                if (sexo == "Masculino") {
                    for (i in 50..78) {
                        optionsPeso.add(i)
                    }
                }


                var expandedPeso by remember { mutableStateOf(false) }
                var selectedOptionTextPeso by remember { mutableStateOf(optionsPeso[0]) }

                ExposedDropdownMenuBox(
                    expanded = expandedPeso,
                    onExpandedChange = {
                        expandedPeso = !expandedPeso
                    }
                ) {

                    TextField(
                        readOnly = true,
                        value = selectedOptionTextPeso.toString(),
                        onValueChange = { },
                        label = { Text("Estatura") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expandedPeso
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors()
                    )
                    ExposedDropdownMenu(
                        expanded = expandedPeso,
                        onDismissRequest = {
                            expandedPeso = false
                        }
                    ) {

                        optionsPeso.forEach { selectionOption ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedOptionTextPeso = selectionOption
                                    peso = selectionOption
                                    expandedPeso = false
                                }
                            ) {
                                Text(text = selectionOption.toString())
                            }
                        }
                    }
                }


            }
        }
        Row() {
            Button({
                person.sexo = sexo
                person.peso = peso
                person.estatura = estatura
                Log.d("PERSONA", person.toString())
                showData = true
                showPeso = false
                datosEnviados = true
            }) {
                Text(text = "Aceptar")
            }
        }
    }

    if (showData) {

        Row() {
            Text(
                text = "Estatura: " + person.estatura,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(4.dp),
                color = Color.Black
            )
        }
        Row() {
            Text(
                text = "Peso: " + person.peso,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(4.dp),
                color = Color.Black
            )
        }
        Row() {
            Text(
                text = "Sexo: " + person.sexo,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(4.dp),
                color = Color.Black
            )
        }
    }



    return datosEnviados
}


