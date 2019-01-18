package br.com.ms.javalinexample.configs.db

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.LoggerFactory

object DatabaseComposer {

    private val logger = LoggerFactory.getLogger(DatabaseComposer::class.java)

    fun createTables(vararg tables: Table) {
        val tableNames = tables.map { it::class.simpleName }.joinToString(",", "[", "]")

        logger.info("Creating tables $tableNames if not exists.")

        transaction { tables.forEach { SchemaUtils.create(it) } }
    }
}