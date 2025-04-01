package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R


@Composable
fun HomeScreen(controleDeNavegacao: NavHostController?) {

    val nomeState = remember {
        mutableStateOf(value = "")
    }
    //Obtendo o contexto da tela atual
    val context = LocalContext.current

    //Abrir ou criar um arquivo SharedPreferences
    val userFile = context
        .getSharedPreferences("user_file", Context.MODE_PRIVATE)

    //Criamos um editor responsavel por editar um arquivo
    val  editor = userFile.edit()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.horizontalGradient(
                listOf(
                   Color(0xFF071A83),
                   Color(0xFF0232FF)

                )
            ))
    ){
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                painter = painterResource(R.drawable.sticker),
                contentDescription = stringResource(R.string.logo),
                modifier = Modifier
                    .padding(vertical = 60.dp)
            )
            Text(
                text = stringResource(R.string.welcome),
                fontSize = 38.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 60.dp)
            )
            Card(
                modifier = Modifier

                    .fillMaxSize()
                    .height(150.dp),
                    shape = RoundedCornerShape(
                        topStart = 48.dp,
                        topEnd = 38.dp
                    )

            ) {

                Column (
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp)
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()

                    ) {
                        Text(
                            text = stringResource(R.string.your_name),
                            fontSize = 24.sp,

                            color = Color.Black
                        )
                        OutlinedTextField(
                            value = nomeState.value,
                            onValueChange = {

                                nomeState.value = it

                            },
                            label = {
                                Text(text = "Digite o seu nome")
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            leadingIcon = {
                               Icon(
                                   imageVector = Icons.Default.Email,
                                   contentDescription = "",
                                   tint = Color(0xFF1644BB)

                               )
                            },
                            trailingIcon = {
                                Icon(
                                    imageVector =  Icons.Default.LocationOn,
                                    contentDescription = "",
                                    tint = Color(0xFF1644BB)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                capitalization = KeyboardCapitalization.Sentences
                            )

                        )
                    }

                    Button(
                        onClick = {
                            editor.putString("user_name", nomeState.value)
                            editor.apply()
                            controleDeNavegacao?.navigate(route = "UserData")
                        },
                        shape = RoundedCornerShape(10.dp)

                        )
                    {
                        Text(text = stringResource(R.string.next))

                    }
                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(null)
}