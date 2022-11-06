package com.example.architecture

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

@Composable
fun TextNumberField(txt: String): String {

    var txtTyped by remember {
        mutableStateOf("")
    }

    TextField(
        value = txtTyped,
        label = { Text("Enter Number") },
        onValueChange = { newText ->
            if (checkIntOrEmpty(newText)) {
                txtTyped = newText
            }
        },
    )
    return txtTyped
}

private fun checkIntOrEmpty(txt: String): Boolean {
    if (txt.isEmpty()) {
        return true
    }
    return try {
        txt.toInt()
        true
    } catch (e: NumberFormatException) {
        false
    }
}