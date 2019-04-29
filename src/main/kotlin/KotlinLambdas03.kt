fun <T> doInTxContextWithResult(action: TxContext.() -> T): T {
    val tx = TxContext()
    // begin tx
    return runCatching { tx.action() }
        .onSuccess { /* commit tx */ }
        .onFailure { /* rollback tx */ }
        .getOrThrow()
}

fun main() {
    val str = doInTxContextWithResult { "Hello Transaction: $this" }
    println(str)
}