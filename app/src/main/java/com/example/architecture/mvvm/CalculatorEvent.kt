package com.example.architecture.mvvm

sealed class CalculatorEvent {
    class NumberTyped(val txt: Int, val id: TextFieldId) : CalculatorEvent()
    class SumClicked(val a: Int, val b: Int) : CalculatorEvent()
    object ClearSumClicked : CalculatorEvent()
}

enum class TextFieldId{ A,B }