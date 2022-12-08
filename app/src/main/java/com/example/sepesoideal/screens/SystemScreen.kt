package com.example.sepesoideal.screens

import android.util.Log
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
import com.example.sepesoideal.navigation.Screen

var person = Person(0, 0, "")

@Composable
fun SystemScreen(navController: NavHostController) {

    val scrollState = rememberScrollState()
    Scaffold() {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(bottom = 60.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 12.dp, top = 20.dp, end = 12.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.padding(bottom = 20.dp)) {
                    Text(
                        text = "Peso Ideal",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = MaterialTheme.colors.primary
                    )
                }


                var primerPregunta by remember { mutableStateOf(true) }
                var llenarDatos by remember { mutableStateOf(false) }
                var datosRecibidos by remember { mutableStateOf(false) }

                var mantenerse by remember { mutableStateOf(false) }
                var tonificar by remember { mutableStateOf(false) }


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
                        Column() {
                            Button(   onClick =
                                {
                                primerPregunta = false
                                llenarDatos = true
                            }) {
                                Text(text = "Bajar peso")
                            }
                        }
                        Column (modifier = Modifier.padding(start=6.dp),){
                            Button(onClick = {
                                primerPregunta = false
                                mantenerse = true
                                navController.navigate(Screen.Mantenerse.route)
                                //llenarDatos = true
                            }) {
                                Text(text = "Mantenerse")
                            }
                        }
                        Column (modifier = Modifier.padding(start=6.dp),){
                            Button(onClick = {
                                primerPregunta = false
                                tonificar = true
                                navController.navigate(Screen.Tonificar.route)
                                //llenarDatos = true
                            }) {
                                Text(text = "Tonificar")
                            }
                        }
                    }
                }



                if (tonificar) {
                    SacarMusculos(navController)
                }
                if (mantenerse) {
                    Mantenerse(navController)
                }

                if (llenarDatos) {
                    datosRecibidos = LlenarDatos()
                }
                if (datosRecibidos) {
                    Condicion(navController)
                }


            }
        }
    }
}


@Composable
fun Condicion(navController: NavHostController) {
    Row(modifier = Modifier.padding(top = 20.dp)) {
        Text(
            text = "Condición: ",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }

    if (person.sexo == "Femenino") {

        if (person.estatura >= 144 && person.estatura <= 150 && person.peso >= 49 && person.peso <= 56) {
            PesoIdeal(navController)
        } else if (person.estatura >= 144 && person.estatura <= 150 && person.peso > 56) {
            SobrePeso(navController)
        } else if (person.estatura >= 150 && person.estatura <= 155 && person.peso >= 51 && person.peso <= 59) {
            PesoIdeal(navController)
        } else if (person.estatura >= 150 && person.estatura <= 155 && person.peso > 59) {
            SobrePeso(navController)
        } else if (person.estatura >= 156 && person.estatura <= 160 && person.peso >= 54 && person.peso <= 61) {
            PesoIdeal(navController)
        } else if (person.estatura >= 156 && person.estatura <= 160 && person.peso > 61) {
            SobrePeso(navController)
        } else if (person.estatura >= 161 && person.estatura <= 165 && person.peso >= 56 && person.peso <= 64) {
            PesoIdeal(navController)
        } else if (person.estatura >= 161 && person.estatura <= 165 && person.peso > 64) {
            SobrePeso(navController)
        } else if (person.estatura >= 166 && person.estatura <= 170 && person.peso >= 59 && person.peso <= 67) {
            PesoIdeal(navController)
        } else if (person.estatura >= 166 && person.estatura <= 170 && person.peso > 67) {
            SobrePeso(navController)
        } else if (person.estatura >= 171 && person.estatura <= 175 && person.peso >= 62 && person.peso <= 70) {
            PesoIdeal(navController)
        } else if (person.estatura >= 171 && person.estatura <= 175 && person.peso > 70) {
            SobrePeso(navController)
        } else if (person.estatura >= 176 && person.estatura <= 180 && person.peso >= 60 && person.peso <= 72) {
            PesoIdeal(navController)
        } else if (person.estatura >= 176 && person.estatura <= 180 && person.peso > 72) {
            SobrePeso(navController)
        }
    }


    if (person.sexo == "Masculino") {

        if (person.estatura >= 144 && person.estatura <= 160 && person.peso >= 49 && person.peso <= 56) {
            PesoIdeal(navController)
        } else if (person.estatura >= 144 && person.estatura <= 160 && person.peso > 56) {
            SobrePeso(navController)
        } else if (person.estatura >= 161 && person.estatura <= 165 && person.peso >= 53 && person.peso <= 60) {
            PesoIdeal(navController)
        } else if (person.estatura >= 161 && person.estatura <= 165 && person.peso > 60) {
            SobrePeso(navController)
        } else if (person.estatura >= 166 && person.estatura <= 170 && person.peso >= 56 && person.peso <= 63) {
            PesoIdeal(navController)
        } else if (person.estatura >= 166 && person.estatura <= 170 && person.peso > 63) {
            SobrePeso(navController)
        } else if (person.estatura >= 171 && person.estatura <= 175 && person.peso >= 60 && person.peso <= 67) {
            PesoIdeal(navController)
        } else if (person.estatura >= 171 && person.estatura <= 175 && person.peso > 67) {
            SobrePeso(navController)
        } else if (person.estatura >= 176 && person.estatura <= 180 && person.peso >= 63 && person.peso <= 71) {
            PesoIdeal(navController)
        } else if (person.estatura >= 176 && person.estatura <= 180 && person.peso > 71) {
            SobrePeso(navController)
        } else if (person.estatura >= 181 && person.estatura <= 185 && person.peso >= 67 && person.peso <= 75) {
            PesoIdeal(navController)
        } else if (person.estatura >= 181 && person.estatura <= 185 && person.peso > 75) {
            SobrePeso(navController)
        } else if (person.estatura >= 186 && person.estatura <= 190 && person.peso >= 71 && person.peso <= 78) {
            PesoIdeal(navController)
        } else if (person.estatura >= 186 && person.estatura <= 190 && person.peso > 78) {
            SobrePeso(navController)
        }


    }


}


@Composable
fun SobrePeso(navController: NavHostController) {
    Row() {
        Text(
            text = "Sobre Peso",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }



    Row {
        Text(
            text = "¿Desea Bajar Peso?",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }

    var mantenerse by remember { mutableStateOf(true) }
    var mostrarRutina by remember { mutableStateOf(false) }
    if (mantenerse)
        Row {
            Column {
                Button({
                    mantenerse = false
                    RestartApp(navController)
                }) {
                    Text(text = "Salir")
                }
            }
            Column (modifier = Modifier.padding(start=6.dp),){
                Button({
                    mantenerse = false
                    mostrarRutina = true
                    navController.navigate(Screen.BajarDePeso.route)
                }) {
                    Text(text = "Bajar Peso")
                }
            }
        }
    if (mostrarRutina) {
        BajarDePeso(navController)
    }


}

@Composable
fun BajarDePeso(navController: NavHostController) {
    Row() {
        Text(
            text = "Rutina Bajar de peso",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }
    Row {
        Column (modifier = Modifier.padding(start=6.dp),){
            Button({
                RestartApp(navController)
            }) {
                Text(text = "Salir")
            }
        }
    }
}


@Composable
fun PesoIdeal(navController: NavHostController) {
    Row() {
        Text(
            text = "Peso Ideal",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }

    Row() {
        Text(
            text = "¿Qué desea realizar?",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }

    var mantenerse by remember { mutableStateOf(true) }
    var mantenerseRutina by remember { mutableStateOf(false) }
    var musculosRutina by remember { mutableStateOf(false) }
    if (mantenerse)
        Row {
            Column {
                Button({
                    mantenerse = false
                    RestartApp(navController)
                }) {
                    Text(text = "Salir")
                }
            }
            Column (modifier = Modifier.padding(start=6.dp),){
                Button({
                    mantenerse = false
                    mantenerseRutina = true
                    navController.navigate(Screen.Mantenerse.route)
                }) {
                    Text(text = "Mantenerse")
                }
            }
            Column (modifier = Modifier.padding(start=6.dp),){
                Button({
                    mantenerse = false
                    musculosRutina = true
                    navController.navigate(Screen.Tonificar.route)
                }) {
                    Text(text = "Sacar músculos")
                }
            }
        }
    if (mantenerseRutina) {
        Mantenerse(navController)

    }
    if (musculosRutina) {
        SacarMusculos(navController)
    }
}

fun RestartApp(navController: NavHostController) {
    navController.navigate(Screen.System.route)
    {
        //popUpTo(navController.graph.findStartDestination().id)
        //launchSingleTop = true
    }
}


@Composable
fun SacarMusculos(navController: NavHostController) {
    Row() {
        Text(
            text = "Rutina Sacar Músculos",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }
    Row {
        Column {
            Button({
                RestartApp(navController)
            }) {
                Text(text = "Salir")
            }
        }
    }
}

@Composable
fun Mantenerse(navController: NavHostController) {
    Row() {
        Text(
            text = "Rutina Mantenerse",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(4.dp),
            color = Color.Black
        )
    }
    Row {
        Column {
            Button({
                RestartApp(navController)
            }) {
                Text(text = "Salir")
            }
        }
    }
}


@OptIn(
    ExperimentalMaterialApi::class
)
@Composable
fun LlenarDatos(): Boolean {

    val options = listOf(144, 145, 146, 147, 148,149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168,169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188,189, 190)
    var sexo by remember { mutableStateOf("") }
    var estatura by remember { mutableStateOf(144) }
    var peso by remember { mutableStateOf(49) }

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
            Column(modifier = Modifier.padding(start=6.dp),) {
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


                var selectedOptionText by remember { mutableStateOf(options[0]) }
                var expanded by remember { mutableStateOf(false) }



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


                val optionsPeso = ArrayList<Int>()
                if (sexo == "Femenino") {
                    for (i in 49..100) {
                        optionsPeso.add(i)
                    }
                }

                if (sexo == "Masculino") {
                    for (i in 49..100) {
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
                        label = { Text("Peso") },
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

fun llenarComboEstatura(sexo: String): ArrayList<Int> {
    val options = ArrayList<Int>()
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
    return options
}

