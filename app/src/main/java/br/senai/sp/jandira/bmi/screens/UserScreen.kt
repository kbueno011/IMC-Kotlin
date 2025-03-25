package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.size
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


                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Row (
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()

                    ) {
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card (
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
                                onClick = {},
                                shape = RoundedCornerShape(30.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF9C0DD5),

                                )

                            )
                            {
                                Text(text = stringResource(R.string.male))
                            }
                        }
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card (
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
                                onClick = {},
                                shape = RoundedCornerShape(30.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF051788),
                                )
                                )
                            {
                                Text(text = stringResource(R.string.female))
                            }
                        }
                        }

                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        {
                            OutlinedTextField(
                                value = "",
                                onValueChange = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 20.dp),
                                shape = RoundedCornerShape(16.dp),
                                label = {
                                    Text(
                                        text = stringResource(R.string.age)
                                    )
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
                                value = "",
                                onValueChange = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 20.dp),
                                shape = RoundedCornerShape(16.dp),
                                label = {
                                    Text(
                                        text = stringResource(R.string.width)
                                    )
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
                                value = "",
                                onValueChange = {},
                                modifier = Modifier
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp),
                                label = {
                                    Text(
                                        text = stringResource(R.string.heigth)
                                    )
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

                    Button(
                        onClick = {
                            controleDeNavegacao?.navigate(route = "BMIresult")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF133EB9),

                            )
                    ) {
                        Text(
                            text = stringResource(R.string.calculate)
                        )
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
