package com.example.architecture.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.architecture.SumProvider

class CalculatorViewModel : ViewModel() {
    var result by mutableStateOf("result")
    var txtA : Int? by mutableStateOf(null)
    var txtB  :Int? by mutableStateOf(null)

    fun handleEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.NumberTyped -> handleNumberTyped(event.txt, event.id)
            is CalculatorEvent.SumClicked -> handleSumClicked()
            CalculatorEvent.ClearSumClicked -> result = ""
        }
    }

    private fun handleNumberTyped(txt: Int?, id: TextFieldId) {
        when (id) {
            TextFieldId.A -> txtA = txt
            TextFieldId.B -> txtB = txt
        }
    }

    private fun handleSumClicked() {
        result = "${SumProvider().getSum(txtA?:0,txtB?:0)}"
    }


}