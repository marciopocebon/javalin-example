package br.com.ms.javalinexample.tables

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column

object Users : IntIdTable() {

    val name: Column<String> = varchar("name", 50)
    val email: Column<String> = varchar("email", 50)
    val password: Column<String> = varchar("password", 50)
}