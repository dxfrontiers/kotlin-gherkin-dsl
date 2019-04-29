fun doInTransaction(action: () -> Unit) {
    // begin tx
    try {
        action()
        // commit tx
    } catch (t: Throwable) {
        // rollback tx
        throw t
    }
}

fun main() {
    val txAction: () -> Unit = {
        println("Hello Transaction!")
    }
    doInTransaction(txAction)

    doInTransaction {
        println("Hello Transaction!")
    }
}