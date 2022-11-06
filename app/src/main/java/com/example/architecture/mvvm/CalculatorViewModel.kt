package com.example.architecture.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.architecture.SumProvider

class CalculatorViewModel : ViewModel() {

    var isError by mutableStateOf(false)
    var result by mutableStateOf("result")
    var txtA by mutableStateOf("")
    var txtB by mutableStateOf("")

    fun handleEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.SumClicked -> handleSumClicked(event.a, event.b)
            is CalculatorEvent.TextTyped -> handleTextTyped(event.txt, event.id)
            CalculatorEvent.ClearSumClicked -> result = ""
        }
    }

    private fun handleSumClicked(a: String, b: String) {
        if (a.isEmpty() || b.isEmpty()) {
            isError = true
            return
        }
        isError = false
        result = "${SumProvider().getSum(a.toInt(), b.toInt())}"
    }

    private fun handleTextTyped(txt: String, id: TextFieldId) {
        when (id) {
            TextFieldId.A -> txtA = txt
            TextFieldId.B -> txtB = txt
        }
    }

}