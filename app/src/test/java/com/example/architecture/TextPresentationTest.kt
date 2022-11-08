package com.example.architecture

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TextPresentationTest {

    private lateinit var textPresentation: TextPresentation

    @Before
    fun setUp() {
        textPresentation = TextPresentation()
    }

    //Arrange
    //Act
    //Assert

    @Test
    fun `checkNumChangePresent, new txt number, toInt number success`() {
        val current = ""
        val new = "1"

        val result = textPresentation.checkNumChangePresent(new,current)

        assertTrue(result.number == 1)

    }

    @Test
    fun `checkNumChangePresent, new txt number, text updated`() {
        val current = ""
        val new = "1"

        val result = textPresentation.checkNumChangePresent(new,current)

        assertEquals("1",result.text)
    }

    @Test
    fun `checkNumChangePresent, current txt number and new txt dot, current number remains`() {
        val current = "1"
        val new = "."

        val result = textPresentation.checkNumChangePresent(new,current)

        assertTrue(result.number == 1)

    }

    @Test
    fun `checkNumChangePresent, current txt number and new txt dot, current txt remains`() {
        val current = "1"
        val new = "."

        val result = textPresentation.checkNumChangePresent(new,current)

        assertEquals("1",result.text)
    }

    @Test
    fun `checkNumChangePresent, current txt number and new txt char, current number remains`() {
        val current = "1"
        val new = "s"

        val result = textPresentation.checkNumChangePresent(new,current)

        assertTrue(result.number == 1)

    }

    @Test
    fun `checkNumChangePresent, current txt number and new txt char, current txt remains`() {
        val current = "1"
        val new = "s"

        val result = textPresentation.checkNumChangePresent(new,current)

        assertEquals("1",result.text)
    }

    @Test
    fun `checkNumChangePresent, current txt number and new txt empty, current number null`() {
        val current = "1"
        val new = ""

        val result = textPresentation.checkNumChangePresent(new,current)

        assertTrue(result.number == null)

    }

    @Test
    fun `checkNumChangePresent, current txt number and new txt empty, current txt empty`() {
        val current = "1"
        val new = ""

        val result = textPresentation.checkNumChangePresent(new,current)

        assertEquals("",result.text)
    }

}