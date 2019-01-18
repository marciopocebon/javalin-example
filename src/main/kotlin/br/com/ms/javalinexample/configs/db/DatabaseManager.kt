package br.com.ms.javalinexample.configs.db

import br.com.ms.javalinexample.tables.Users
import org.jetbrains.exposed.sql.Database

object DatabaseManager {

    fun start(){
        Database.connect(DataSourceProvider.datasource)
        DatabaseComposer.createTables(Users)
    }
}