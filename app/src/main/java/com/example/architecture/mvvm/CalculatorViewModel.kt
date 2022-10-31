package com.example.architecture.mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
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
            is CalculatorEvent.TextNumberCheck -> handleTextNumberCheck(event.txt, event.id)
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

    private fun handleTextNumberCheck(txt: String, id: Int) {
        if (checkIntOrEmpty(txt)) {
            when (id) {
                1 -> txtA = txt
                2 -> txtB = txt
            }
        }
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
}