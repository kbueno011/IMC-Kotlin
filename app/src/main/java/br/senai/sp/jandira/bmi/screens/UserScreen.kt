package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun UserScreen(modifier: Modifier = Modifier) {

    var nomeState = remember {
        mutableStateOf(value = "")
    }

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
            verticalArrangement = Arrangement.SpaceBetween
        ){

            Text(
                text = stringResource(R.string.hi),
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

                Column (
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp)
                ) {

                    Row (
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()

                    ) {
                        Column (
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.woman),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(140.dp)
                                    .padding(15.dp)

                            )
                            Button(
                                onClick = {},
                                shape = RoundedCornerShape(30.dp)
                            )
                            {
                                Text(text = stringResource(R.string.male))
                            }
                        }
                        Column (
                            modifier = Modifier
                                .weight(1f),

                        ) {
                            Image(
                                painter = painterResource(R.drawable.homem),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(140.dp)
                                    .padding(15.dp)

                            )
                            Button(
                                onClick = {},
                                shape = RoundedCornerShape(30.dp),

                            )
                            {
                                Text(text = stringResource(R.string.female))
                            }
                        }

                    }

                    }
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
                        onClick = {},
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .width(300.dp)
                            .height(50.dp)

                    )
                    {
                        Text(
                            text = stringResource(R.string.calculate),
                            fontSize = 26.sp
                        )

                    }
                }

            }
        }
    }






@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    UserScreen()
}
