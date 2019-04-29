interface Database {
    // be sure to close
    fun connect(): Connection
    fun close(c: Connection)

    interface Connection {
        fun <T> queryFor(query: String): T
    }
}

fun boilerPlated() {
    val db = myDb("jdbc:mysql:localhost:12356/test")
    val connection = db.connect()
    try {
        val result = connection.queryFor<Int>("SELECT ....")

        // ....

    } finally {
        db.close(connection)
    }
}

fun noMoreBoilerPlated() {
    myDb("jdbc:mysql:localhost:12356/test").withConnection {
        val result = queryFor<Int>("SELECT ....")

        // ....
    }
}