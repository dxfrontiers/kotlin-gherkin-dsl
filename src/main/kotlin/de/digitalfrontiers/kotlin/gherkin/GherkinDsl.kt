package de.digitalfrontiers.kotlin.gherkin

import assertk.Assert
import assertk.assertAll
import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.endsWith
import assertk.assertions.startsWith

typealias given<S> = Given<S>
class Given<S>(private val setup: () -> S) {

    fun <R> on(test: S.() -> R): Result<R> =
        Result { setup().test() }
}

class Result<R>(private val result: () -> R) {

    fun thenAssert(assert: Assert<R>.() -> Unit) {
        assertThat(result()).assert()
    }

    fun then(assert: Assertions.(R) -> Unit) {
        val assertions = Assertions()
        assertAll {
            assertions.assert(result())
        }
    }
}

class Assertions {
    infix fun <T> T.should(asserter: Asserter<T>) {
        asserter.assertValue(this)
    }
}

interface Asserter<T> {
    fun assertValue(t: T)
}


typealias startWith = StartsWithAsserter
class StartsWithAsserter(val expected: String): Asserter<String> {
    override fun assertValue(t: String) {
        assertThat(t).startsWith(expected)
    }
}

typealias contain = ContainsAsserter
class ContainsAsserter(val expected: String): Asserter<String> {
    override fun assertValue(t: String) {
        assertThat(t).contains(expected)
    }
}

typealias endWith = EndsWithAsserter
class EndsWithAsserter(val expected: String): Asserter<String> {
    override fun assertValue(t: String) {
        assertThat(t).endsWith(expected)
    }
}
