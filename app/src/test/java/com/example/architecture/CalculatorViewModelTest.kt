package com.example.architecture

import com.example.architecture.mvvm.CalculatorEvent
import com.example.architecture.mvvm.CalculatorViewModel
import com.example.architecture.mvvm.TextFieldId
import org.junit.Assert.*
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
    fun `sumClicked, when A and B empty, isError true`() {
        val a = ""
        val b = ""

        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked(a, b))

        assertTrue(calculatorViewModel.isError)
    }

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
    fun `sumClicked, when A and B are integer numbers, isError false and result updated`() {
        val a = "4"
        val b = "5"

        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked(a, b))

        //separate to 2 methods
        assertFalse(calculatorViewModel.isError)
        assertEquals("9", calculatorViewModel.result)
    }

    //TextTyped A

    @Test
    fun `TextNumberCheck, when new A is letter, current A remains`() {
        val current = calculatorViewModel.txtA
        val a = "s"

        calculatorViewModel.handleEvent(CalculatorEvent.TextTyped(a, TextFieldId.A))

        assertEquals(current, calculatorViewModel.txtA)
    }

    @Test
    fun `TextNumberCheck, when new A is dot, current A remains`() {
        val current = calculatorViewModel.txtA
        val a = "."

        calculatorViewModel.handleEvent(CalculatorEvent.TextTyped(a, TextFieldId.A))

        assert(calculatorViewModel.txtA == current)
    }

    @Test
    fun `TextNumberCheck, when new A empty, current A updated`() {
        calculatorViewModel.txtA = "1"
        val a = ""

        calculatorViewModel.handleEvent(CalculatorEvent.TextTyped(a, TextFieldId.A))

        assert(calculatorViewModel.txtA.isEmpty())
    }

    @Test
    fun `TextNumberCheck, when new A integer, current A updated`() {
        val a = "123"

        calculatorViewModel.handleEvent(CalculatorEvent.TextTyped(a, TextFieldId.A))

        assert(calculatorViewModel.txtA == "123")
    }

    //TextTyped B
    //todo

    @Test
    fun `TextNumberCheck, when new B is letter, current B remains`() {
        val current = calculatorViewModel.txtB
        val b = "s"

        calculatorViewModel.handleEvent(CalculatorEvent.TextTyped(b, TextFieldId.B))

        assertEquals(current, calculatorViewModel.txtB)
    }


    @Test
    fun `TextNumberCheck, when new B is dot, current B remains`() {
        val current = calculatorViewModel.txtB
        val b = "."

        calculatorViewModel.handleEvent(CalculatorEvent.TextTyped(b, TextFieldId.B))

        assertEquals(current, calculatorViewModel.txtB)
    }

    @Test
    fun `TextNumberCheck, when new B empty, current B updated`() {
        calculatorViewModel.txtB = "1"
        val b = ""

        calculatorViewModel.handleEvent(CalculatorEvent.TextTyped(b, TextFieldId.B))

        assertTrue(calculatorViewModel.txtB.isEmpty())
    }

    @Test
    fun `TextNumberCheck, when new B integer, current B updated`() {
        val b = "123"

        calculatorViewModel.handleEvent(CalculatorEvent.TextTyped(b, TextFieldId.B))

        assertEquals(b, calculatorViewModel.txtB)
    }

    //ClearSumClicked

    @Test
    fun `ClearSumClicked, always, result clear`() {
        calculatorViewModel.result = "error"

        calculatorViewModel.handleEvent(CalculatorEvent.ClearSumClicked)

        assert(calculatorViewModel.result.isEmpty())
    }
}