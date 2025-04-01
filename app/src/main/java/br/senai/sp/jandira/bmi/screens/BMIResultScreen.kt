package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun BMIResultScreen(controleDeNavegacao: NavHostController?) {

    val context = LocalContext.current
    val userFile = context.getSharedPreferences("user_file", Context.MODE_PRIVATE)

    // Recuperando os valores salvos no SharedPreferences
    val idade = userFile.getInt("user_age", 0) // Default para 0 caso não tenha sido salvo
    val peso = userFile.getInt("user_weight", 0) // Default para 0
    val altura = userFile.getInt("user_height", 0) // Default para 0

    // Estado para os campos de exibição (valores recuperados do SharedPreferences)
    var idadeState = remember { mutableStateOf(idade.toString()) }
    var pesoState = remember { mutableStateOf(peso.toString()) }
    var alturaState = remember { mutableStateOf(altura.toString()) }

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
                text = stringResource(R.string.result),
                fontSize = 27.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
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
                    Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .weight(1.2f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Card(
                            modifier = Modifier
                                .size(120.dp),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 5.dp,
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        Color(0xFF021EC4),
                                        Color(0xFF3E4E80),
                                        Color(0xFF9C0DD5),
                                    )
                                )
                            )
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(
                                    text = stringResource(R.string.imc),
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Text(
                            text = stringResource(R.string.status),
                            fontSize = 27.sp,
                            modifier = Modifier
                                .padding(15.dp)
                        )
                        Card(
                            modifier = Modifier
                                .height(90.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .weight(1f)
                                ) {
                                    Text(
                                        text = stringResource(R.string.age),
                                        fontSize = 22.sp
                                    )
                                    Text(
                                        text = idadeState.value, // Preenchendo o valor da idade
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 22.sp
                                    )
                                }

                                VerticalDivider()

                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .weight(1f)
                                ) {
                                    Text(
                                        text = stringResource(R.string.W),
                                        fontSize = 22.sp
                                    )
                                    Text(
                                        text = pesoState.value, // Preenchendo o valor do peso
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 22.sp
                                    )
                                }

                                VerticalDivider()

                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .weight(1f)
                                ) {
                                    Text(
                                        text = stringResource(R.string.H),
                                        fontSize = 22.sp
                                    )
                                    Text(
                                        text = alturaState.value, // Preenchendo o valor da altura
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 22.sp
                                    )
                                }
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(0.9f)
                            .background(color = Color.Black)
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                    ) {
                    }

                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )

                    Column(
                        modifier = Modifier
                            .weight(0.7f)
                    ) {
                        Button(
                            onClick = {
                                controleDeNavegacao?.navigate(route = "UserData")
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 40.dp)
                                .height(60.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF133EB9)
                            )
                        ) {
                            Text(
                                text = stringResource(R.string.calc),
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}
