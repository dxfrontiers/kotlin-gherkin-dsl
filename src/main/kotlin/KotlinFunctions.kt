fun greet(to: String): String {
    return "Hello $to!"
}

fun divide(a: Int, b: Int) = a / b

fun String.printGreeting() {
    this.let(::greet).run(::println)
}

fun main() {
    println(greet("Frank"))
    println(divide(a = 4, b = 2))
    "Frank"
        .let(::greet)
        .run(::println)
    "Hugo".printGreeting()
}
