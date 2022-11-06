package com.example.architecture.mvvm

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.architecture.R
import com.example.architecture.TextNumberField

@Composable
fun CalculatorView(viewModel: CalculatorViewModel) {

    Column {
        val txtA = TextNumberField(viewModel.txtA)

        val txtB = TextNumberField(viewModel.txtB)

        Button(onClick = {
            viewModel.handleEvent(CalculatorEvent.SumClicked(txtA, txtB))
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