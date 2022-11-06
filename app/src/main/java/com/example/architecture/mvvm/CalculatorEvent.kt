package com.example.architecture.mvvm

sealed class CalculatorEvent {
    class TextTyped(val txt: String, val id: TextFieldId) : CalculatorEvent()
    class SumClicked(val a: String, val b: String) : CalculatorEvent()
    object ClearSumClicked : CalculatorEvent()
}

enum class TextFieldId{ A,B }