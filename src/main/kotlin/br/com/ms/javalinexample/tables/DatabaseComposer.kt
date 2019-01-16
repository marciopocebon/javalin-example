package br.com.ms.javalinexample.tables

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseComposer {

    fun start(vararg tables: Table) {
        println("Creating tables [${tables::class.simpleName}] if not exists.")
        transaction { tables.forEach { SchemaUtils.create(it) } }
    }
}