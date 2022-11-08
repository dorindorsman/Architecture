package com.example.architecture

import androidx.lifecycle.viewmodel.compose.viewModel
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


    //TextTyped A

    @Test
    fun `handleNumberTyped, when new A , current A updated`() {
        val a = 1

        calculatorViewModel.handleEvent(CalculatorEvent.NumberTyped(a, TextFieldId.A))

        assertEquals(a, calculatorViewModel.txtA)
    }

    @Test
    fun `handleNumberTyped, when new A , B remains`() {
        val currentB = calculatorViewModel.txtB
        val a = 1

        calculatorViewModel.handleEvent(CalculatorEvent.NumberTyped(a, TextFieldId.A))

        assertTrue(currentB == calculatorViewModel.txtB)
    }

    //TextTyped B

    @Test
    fun `handleNumberTyped, when new B , current B updated`() {
        val b = 1

        calculatorViewModel.handleEvent(CalculatorEvent.NumberTyped(b, TextFieldId.B))

        assertEquals(b, calculatorViewModel.txtB)
    }

    @Test
    fun `handleNumberTyped, when new B , A remains`() {
        val currentA = calculatorViewModel.txtA
        val b = 1

        calculatorViewModel.handleEvent(CalculatorEvent.NumberTyped(b, TextFieldId.B))

        assertTrue(currentA == calculatorViewModel.txtA)
    }


    //SumClicked

    @Test
    fun `sumClicked, when A and B null, result 0`() {
        calculatorViewModel.txtA = null
        calculatorViewModel.txtB = null


        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked)

        assertEquals("0",calculatorViewModel.result )
    }

    @Test
    fun `sumClicked, when A null and B number, result  is A`() {
        calculatorViewModel.txtA = null
        calculatorViewModel.txtB = 1

        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked)

        assertEquals("1",calculatorViewModel.result )
    }

    @Test
    fun `sumClicked, when A number and B null, result  is B`() {
        calculatorViewModel.txtA = 1
        calculatorViewModel.txtB = null

        calculatorViewModel.handleEvent(CalculatorEvent.SumClicked)

        assertEquals("1",calculatorViewModel.result)
    }


    //ClearSumClicked
    @Test
    fun `ClearSumClicked, always, result clear`() {
        calculatorViewModel.result = "9"

        calculatorViewModel.handleEvent(CalculatorEvent.ClearSumClicked)

        assert(calculatorViewModel.result.isEmpty())
    }
}