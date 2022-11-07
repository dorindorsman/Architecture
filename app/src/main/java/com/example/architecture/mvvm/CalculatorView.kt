package com.example.architecture.mvvm

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.architecture.R
import com.example.architecture.TextNumberField

@Composable
fun CalculatorView(viewModel: CalculatorViewModel) {

    Column {
        TextNumberField(onNumberChange = {viewModel.handleEvent(CalculatorEvent.NumberTyped(it,TextFieldId.A))})

        TextNumberField(onNumberChange =  {viewModel.handleEvent(CalculatorEvent.NumberTyped(it,TextFieldId.B))})

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

//        if (viewModel.isError) {
//            Text(text = stringResource(id = R.string.input_error), color = Color.Red)
//        } else {
//            Text(text = viewModel.result, color = Color.Green)
//        }
    }
}