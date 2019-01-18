package br.com.ms.javalinexample.configs

import br.com.ms.javalinexample.controllers.UserController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

object ApplicationManager {

    fun start(): Javalin = Javalin
        .create()
        .start(7000)
        .routes {
            path("users") {
                post { UserController.save(it) }
                get { UserController.findAll(it) }
                path(":id") {
                    get { UserController.findById(it) }
                    delete { UserController.delete(it) }
                }
            }
        }
}