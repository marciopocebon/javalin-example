package br.com.ms.javalinexample.controllers

import io.javalin.Context

abstract class Controller {

    fun response(ctx: Context, value: Any, statusCode: Int) = ctx.apply {
        status(statusCode)
        json(value)
    }
}