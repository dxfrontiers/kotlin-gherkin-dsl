package de.digitalfrontiers.kotlin.gherkin

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Calculator {

    fun add(a: Int, b: Int) =
        a + b
}

class CalculatorTest {

    @Test
    fun `adds up numbers (gherkin)`() {
        given {
            Calculator()
        }.on {
            add(2, 3)
        }.thenAssert {
            isEqualTo(5)
        }
    }



    @Test
    fun `adds up numbers (classic)`() {
        // given
        val subject = Calculator()

        // when
        val result = subject.add(2, 3)

        // then
        assertThat(result)
            .isEqualTo(5)
    }
}