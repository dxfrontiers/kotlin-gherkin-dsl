package de.digitalfrontiers.kotlin.gherkin

import org.junit.jupiter.api.Test
import java.util.*

class Greeter(localeProvider: () -> Locale = Locale::getDefault) {

    private val greeting: String = when (localeProvider.invoke().language) {
        "en" -> "Hello"
        "de" -> "Hallo"
        "fr" -> "Bonjour"
        else -> TODO("not yet implemented")
    }

    fun sayHello(name: String) = "$greeting $name!"
}

class GreeterTest {

    @Test
    fun `greets using given locale`() {
        given {
            Greeter { Locale.FRANCE }
        }.on {
            sayHello("Frank")
        }.then {
            it should startWith("Bonjour")
            it should contain("Frank")
            it should endWith("!")
        }
    }
}