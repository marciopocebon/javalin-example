package br.com.ms.javalinexample.daos

import br.com.ms.javalinexample.models.User
import br.com.ms.javalinexample.tables.Users
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object UserDao {

    fun save(user: User) = transaction {
        Users.insertAndGetId {
            it[name] = user.name
            it[email] = user.email
            it[password] = user.password
        }
            .let { user.apply { id = it.value } }
    }

    fun findAll() = transaction {
        Users.selectAll()
            .map {
                User(it[Users.name], it[Users.email], it[Users.password]).apply { id = it[Users.id].value }
            }
    }

    fun findById(id: Int) = transaction {
        Users.select { Users.id eq id }.firstOrNull()
    }?.let {
        User(it[Users.name], it[Users.email], it[Users.password]).apply { this.id = it[Users.id].value }
    }

    fun delete(id: Int): Unit = transaction {
        Users.deleteWhere { Users.id eq id }
    }
}