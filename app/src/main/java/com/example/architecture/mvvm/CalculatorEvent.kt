package com.example.architecture.mvvm

sealed class CalculatorEvent {
    class NumberTyped(val txt: Int?, val id: TextFieldId) : CalculatorEvent()
    object SumClicked : CalculatorEvent()
    object ClearSumClicked : CalculatorEvent()
}

enum class TextFieldId{ A,B }