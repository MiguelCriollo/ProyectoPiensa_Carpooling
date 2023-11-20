package com.example.Aventon.services

import com.example.Aventon.models.User
import com.example.Aventon.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository


    fun list ():List<User>{
        return userRepository.findAll()
    }
    fun save(modelo: User): User{
        try {
            userRepository.save(modelo)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,ex.message,ex)
        }
        try{
            return userRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(modelo: User): User{
        try {

            userRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")

            return userRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(modelo:User): User{
        try{
            val response = userRepository.findById(modelo.id)
                ?: throw Exception("ID no existe")
            response.apply {
                firstName=modelo.firstName
            }
            return userRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):User?{
        return userRepository.findById(id)
    }

    fun delete (id: Long?):String?{
        try{
            val response = userRepository.findById(id)
                ?: throw Exception("ID no existe")
            userRepository.deleteById(id!!)
            return "ID eliminado Correctamente!!!"
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}