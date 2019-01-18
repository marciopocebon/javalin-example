package br.com.ms.javalinexample

import br.com.ms.javalinexample.configs.ApplicationManager
import br.com.ms.javalinexample.configs.db.DatabaseManager

fun main(args: Array<String>) {
    DatabaseManager.start()
    ApplicationManager.start()
}

