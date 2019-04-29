import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0

fun myDb(url: String): Database {
    TODO("for demonstration purposes only")
}

fun <T> Database.withConnection(block: Database.Connection.() -> T): T {
    val c = connect()
    try {
        return c.block()
    } finally {
        close(c)
    }
}

abstract class Table(val tableName: String) {
    fun <T> column(name: String): T = TODO("for demonstration purposes only")
}

typealias from = From
class From(val table: Table) {
    fun where(block: Where.() -> Unit) = Where()

    inner class Where {
        infix fun <T> KProperty<T>.eq(t: T) {
            TODO("for demonstration purposes only")
        }

        infix fun <T: Number> KProperty<T>.gt(t: T) {
            TODO("for demonstration purposes only")
        }

        fun select(block: Select.() -> Unit) = Select()
    }

    inner class Select {
        infix fun <T> KProperty<T>.alias(name: String) {
            TODO("for demonstration purposes only")
        }

        fun execute(db: Database): Unit = TODO("for demonstration purposes only")
    }
}