package br.com.ms.javalinexample.daos

import br.com.ms.javalinexample.models.User
import br.com.ms.javalinexample.tables.Users
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction

object UserDao : Dao {

    fun save(user: User) = transaction {
        Users.insertAndGetId {
            it[name] = user.name
            it[email] = user.email
            it[password] = user.password
        }
    }

//    fun findById(id: Int) = Users.select {
//        (Users.id eq id) }.

}