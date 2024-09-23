package com.example.helloworld

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Valuuttamuunnin() {
    var enteredValue by remember { mutableStateOf("") }
    var value = 0.0
    val euroDollariSuhde = 1.1

    Column {
        Row (
            Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth()) {
            TextField(
                value = enteredValue,
                onValueChange = { enteredValue = it },
                modifier = Modifier
                    .padding(start = 20.dp)
                    .border(2.dp, Color.Black)
                    .fillMaxWidth(0.3F)
            )
            Text(
                text = "€ = $" + value.toString(),
                modifier = Modifier.fillMaxWidth(0.7F),
                fontSize = 45.sp
            )
        }

        Button(onClick = {
            var input = enteredValue.toDoubleOrNull() ?: 0.0
            input *= euroDollariSuhde
            value = input
                         },
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Muuta", fontSize = 15.sp)
        }
    }
}