package com.example.architecture.mvvm

sealed class CalculatorEvent {
    class TextNumberCheck(val txt: String,val id: Int) : CalculatorEvent()
    class SumClicked(val a: String, val b: String) : CalculatorEvent()
    object ClearSumClicked : CalculatorEvent()
}