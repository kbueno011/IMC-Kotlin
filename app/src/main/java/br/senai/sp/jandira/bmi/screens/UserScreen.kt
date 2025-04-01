package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun UserScreen(controleDeNavegacao: NavHostController?) {

    val context = LocalContext.current
    val userFile = context.getSharedPreferences("user_file", Context.MODE_PRIVATE)
    val editor = userFile.edit()

    val userName = userFile.getString("user_name", "User not found")

    // States para os campos de entrada
    var nomeState = remember { mutableStateOf("") }
    var idadeState = remember { mutableStateOf("") }
    var pesoState = remember { mutableStateOf("") }
    var alturaState = remember { mutableStateOf("") }

    val selectedColorState = remember { mutableStateOf(Color(0xFF0232FF)) }
    val unselectedColorState = remember { mutableStateOf(Color.LightGray) }
    val isMaleClicked = remember { mutableStateOf(false) }
    val isFemaleClicked = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.horizontalGradient(
                listOf(
                    Color(0xFF071A83),
                    Color(0xFF0232FF)
                )
            ))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "${stringResource(R.string.hi)}, $userName!",
                fontSize = 27.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(30.dp)
                    .weight(1f)
            )

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .height(150.dp)
                    .weight(9f),
                shape = RoundedCornerShape(
                    topStart = 48.dp,
                    topEnd = 38.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Coluna para imagem do usuário feminino
                        Column(
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(120.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    width = 2.dp,
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            Color(0xFF021EC4),
                                            Color(0xFFCFD0D9),
                                            Color(0xFF9C0DD5),
                                        )
                                    )
                                )
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.homem),
                                    contentDescription = "",
                                    modifier = Modifier
                                )
                            }

                            Button(
                                onClick = {
                                    isMaleClicked.value = true
                                    isFemaleClicked.value = false
                                    // Salvando o nome do usuário
                                    editor.putString("user_name", nomeState.value)
                                    editor.apply()
                                },
                                shape = RoundedCornerShape(30.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isMaleClicked.value)selectedColorState.value else unselectedColorState.value)

                            ) {
                                Text(text = stringResource(R.string.male))
                            }
                        }
                        // Coluna para imagem do usuário masculino
                        Column(
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(120.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    width = 2.dp,
                                    brush = Brush.horizontalGradient(
                                        listOf(
                                            Color(0xFF021EC4),
                                            Color(0xFFCFD0D9),
                                            Color(0xFF9C0DD5),
                                        )
                                    )
                                )
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.woman),
                                    contentDescription = "",
                                    modifier = Modifier
                                )
                            }

                            Button(
                                onClick = {
                                    isMaleClicked.value = false
                                    isFemaleClicked.value = true
                                },
                                shape = RoundedCornerShape(30.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (isFemaleClicked.value)selectedColorState.value else unselectedColorState.value)
                            ) {
                                Text(text = stringResource(R.string.female))
                            }
                        }
                    }

                    // Campos de entrada
                    Column(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = idadeState.value,
                            onValueChange = { idadeState.value = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 20.dp),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(text = stringResource(R.string.age))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = "",
                                    tint = Color.Blue
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )

                        OutlinedTextField(
                            value = pesoState.value,
                            onValueChange = { pesoState.value = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 20.dp),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(text = stringResource(R.string.width))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = Color.Blue
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )

                        OutlinedTextField(
                            value = alturaState.value,
                            onValueChange = { alturaState.value = it },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(text = stringResource(R.string.heigth))
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "",
                                    tint = Color.Blue
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )
                        )
                    }

                    // Botão para calcular e salvar as informações
                    Button(
                        onClick = {
                            // Salvando todas as informações inseridas
                            editor.putInt("user_age", idadeState.value.toInt())
                            editor.putInt("user_weight", pesoState.value.toInt())
                            editor.putInt("user_height", alturaState.value.toInt())
                            editor.apply()

                            // Navegar para a próxima tela
                            controleDeNavegacao?.navigate(route = "BMIresult")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF133EB9)
                        )
                    ) {
                        Text(text = stringResource(R.string.calculate))
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    UserScreen(null)
}
