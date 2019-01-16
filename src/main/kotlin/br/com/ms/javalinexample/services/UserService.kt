package br.com.ms.javalinexample.services

import br.com.ms.javalinexample.daos.UserDao
import br.com.ms.javalinexample.models.User

object UserService {

    fun save(user: User): User = user.also { it.id = UserDao.save(it).value }
}