package com.example.architecture.mvvm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.architecture.R

@Composable
fun CalculatorView(viewModel: CalculatorViewModel) {

    Column {
        TextField(
            value = viewModel.txtA,
            label = { Text("Enter Number") },
            onValueChange = { newText ->
                viewModel.handleEvent(CalculatorEvent.TextNumberCheck(newText, 1))
            },
        )
        TextField(
            value = viewModel.txtB,
            label = { Text("Enter Number") },
            onValueChange = { newText ->
                viewModel.handleEvent(CalculatorEvent.TextNumberCheck(newText,2))
            }
        )
        Button(onClick = {
            viewModel.handleEvent(CalculatorEvent.SumClicked(viewModel.txtA, viewModel.txtB))
        }) {
            Text(text = "Sum")
        }

        Button(onClick = {
            viewModel.handleEvent(CalculatorEvent.ClearSumClicked)
        }) {
            Text(text = "Clear Sum")
        }

        if (viewModel.isError) {
            Text(text = stringResource(id = R.string.input_error), color = Color.Red)
        } else {
            Text(text = viewModel.result, color = Color.Green)
        }
    }
}