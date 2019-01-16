package br.com.ms.javalinexample.daos

import org.jetbrains.exposed.sql.statements.InsertStatement
import org.jetbrains.exposed.sql.transactions.transaction

interface Dao {

    fun <T> execute(statement: () -> InsertStatement<Number>) = transaction { statement() }
}
