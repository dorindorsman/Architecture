package com.example.architecture

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

@Composable
fun TextNumberField(onNumberChange: (Int?) -> Unit) {
    val textPresentation = TextPresentation()
    var txtTyped by remember {
        mutableStateOf("")
    }

    TextField(
        value = txtTyped,
        label = { Text("Enter Number") },
        onValueChange = { newText ->
            textPresentation.checkNumChangePresent(newText,txtTyped).let {
                txtTyped = it.text
                onNumberChange(it.number)
            }
        },
    )
}
