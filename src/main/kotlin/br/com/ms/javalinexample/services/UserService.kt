package br.com.ms.javalinexample.services

import br.com.ms.javalinexample.daos.UserDao
import br.com.ms.javalinexample.models.User
import java.lang.RuntimeException

object UserService {

    fun save(user: User): User = UserDao.save(user)

    fun findById(id: Int) = UserDao.findById(id) ?: throw RuntimeException("NAO ACHOU ESSE MALUCO")

    fun findAll() = UserDao.findAll()

    fun delete(id: Int) = UserDao.delete(id)
}