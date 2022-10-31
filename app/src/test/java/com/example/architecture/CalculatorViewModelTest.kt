package com.example.architecture

import com.example.architecture.mvvm.CalculatorEvent
import com.example.architecture.mvvm.CalculatorViewModel
import org.junit.Before
import org.junit.Test

class CalculatorViewModelTest {

    //Arrange
    //Act
    //Assert

    private lateinit var calculatorViewModel: CalculatorViewModel

    @Before
    fun setUp() {
        calculatorViewModel = CalculatorViewModel()
    }

    //SumClicked

    @Test
    fun `sumClicked, when A is empty, isError true`() {
        val a = ""
        val b = "5"

        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked(a, b))

        assert(calculatorViewModel.isError)
    }

    @Test
    fun `sumClicked, when B is empty, isError true`() {
        val a = "5"
        val b = ""

        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked(a, b))

        assert(calculatorViewModel.isError)
    }


    @Test
    fun `sumClicked, when A and B are integers, isError false`() {
        val a = "4"
        val b = "5"

        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked(a, b))

        //assert(calculatorViewModel.result=="9")
        assert(!calculatorViewModel.isError)
    }

    //TextNumberCheck - never-mind A or B

    @Test
    fun `TextNumberCheck, when new A string, current A remains`() {
        val current = calculatorViewModel.txtA
        val a = "str"

        calculatorViewModel.handleEvent(CalculatorEvent.TextNumberCheck(a, 1))

        assert(calculatorViewModel.txtA == current)
    }

    @Test
    fun `TextNumberCheck, when new A char, current A remains`() {
        val current = calculatorViewModel.txtA
        val a = "c"

        calculatorViewModel.handleEvent(CalculatorEvent.TextNumberCheck(a, 1))

        assert(calculatorViewModel.txtA == current)
    }

    @Test
    fun `TextNumberCheck, when new A decimal, current A remains`() {
        val current = calculatorViewModel.txtA
        val a = "4.5"

        calculatorViewModel.handleEvent(CalculatorEvent.TextNumberCheck(a, 1))

        assert(calculatorViewModel.txtA == current)
    }

    @Test
    fun `TextNumberCheck, when new A empty, current A updated`() {
        calculatorViewModel.txtA="123"
        val a = ""

        calculatorViewModel.handleEvent(CalculatorEvent.TextNumberCheck(a, 1))

        assert(calculatorViewModel.txtA.isEmpty())
    }

    @Test
    fun `TextNumberCheck, when new A integer, current A updated`() {
        val a = "123"

        calculatorViewModel.handleEvent(CalculatorEvent.TextNumberCheck(a, 1))

        assert(calculatorViewModel.txtA == "123")
    }

    //ClearSumClicked

    @Test
    fun `ClearSumClicked, always, result clear`(){
        calculatorViewModel.result="error"

        calculatorViewModel.handleEvent(CalculatorEvent.ClearSumClicked)

        assert(calculatorViewModel.result.isEmpty())
    }
}