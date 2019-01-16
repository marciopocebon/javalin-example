package br.com.ms.javalinexample

import DataSourceProvider
import br.com.ms.javalinexample.models.User
import br.com.ms.javalinexample.services.UserService
import br.com.ms.javalinexample.tables.DatabaseComposer
import br.com.ms.javalinexample.tables.Users
import io.javalin.Javalin
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>) {

    Database.connect(DataSourceProvider.datasource)
    DatabaseComposer.start(Users)

    val app = Javalin
        .create()
        .start(7000)

    val user: User = User("Mário", "mario.alvial@gmail.com", "1234")



    app.get("/") { it.json(UserService.save(user))}

}
