package com.example.architecture

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

@Composable
fun TextNumberField(onNumberChange: (Int) -> Unit) {
    val textVerifier = TextVerifier()
    var txtTyped by remember {
        mutableStateOf("")
    }

    TextField(
        value = txtTyped,
        label = { Text("Enter Number") },
        onValueChange = { newText ->
            textVerifier.checkIntOrEmpty(newText)?.let {
                txtTyped = it.toString()
                onNumberChange(it)
            }
        },
    )
}
