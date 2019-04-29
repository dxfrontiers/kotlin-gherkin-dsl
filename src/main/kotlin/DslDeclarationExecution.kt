object Users: Table("USERS") {
    val name: String = column("NAME")
    val surname: String = column("SURNAME")
    val age: Int = column("AGE")
}

fun main() {
    val statement = from(Users).where {
            Users::name eq "Hugo"
            Users::age gt 18
        }.select {
            Users::name alias "name"
            Users::surname alias "nachname"
        }
    statement.execute(myDb("jdbc:mysql:localhost:12356/test"))
}