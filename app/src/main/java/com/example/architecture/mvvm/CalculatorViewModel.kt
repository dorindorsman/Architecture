package com.example.architecture.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.architecture.SumProvider

class CalculatorViewModel : ViewModel() {
    var result by mutableStateOf("result")
    var txtA by mutableStateOf(0)
    var txtB by mutableStateOf(0)

    fun handleEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.SumClicked -> handleSumClicked(event.a, event.b)
            is CalculatorEvent.NumberTyped -> handleNumberTyped(event.txt, event.id)
            CalculatorEvent.ClearSumClicked -> result = ""
        }
    }

    private fun handleSumClicked(a: Int, b: Int) {
        result = "${SumProvider().getSum(a, b)}"
    }

    private fun handleNumberTyped(txt: Int, id: TextFieldId) {
        when (id) {
            TextFieldId.A -> txtA = txt
            TextFieldId.B -> txtB = txt
        }
    }

}