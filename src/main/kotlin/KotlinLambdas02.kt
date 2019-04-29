class TxContext { /* ... */ }

fun <T> doInTransactionWithResult(action: (TxContext) -> T): T {
    val tx = TxContext()
    // begin tx
    return runCatching { action(tx) }
        .onSuccess { /* commit tx */ }
        .onFailure { /* rollback tx */ }
        .getOrThrow()
}

fun main() {
    val str = doInTransactionWithResult { "Hello Transaction: $it" }
    println(str)
}