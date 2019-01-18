package br.com.ms.javalinexample.controllers

import br.com.ms.javalinexample.models.User
import br.com.ms.javalinexample.services.UserService
import io.javalin.Context

object UserController : Controller() {

    fun save(ctx: Context) = response(ctx, UserService.save(ctx.body<User>()), 201)

    fun findAll(ctx: Context) = response(ctx, UserService.findAll(), 200)

    fun findById(ctx: Context) = response(ctx, UserService.findById(ctx.pathParam("id").toInt()), 200)

    fun delete(ctx: Context) = UserService.delete(ctx.pathParam("id").toInt())
        .also { ctx.status(204)}
}