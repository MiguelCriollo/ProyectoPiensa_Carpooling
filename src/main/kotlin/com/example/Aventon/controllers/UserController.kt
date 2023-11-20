package com.example.Aventon.controllers

import com.example.Aventon.models.User
import com.example.Aventon.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/user")
class UserController {
    @Autowired
    lateinit var userService: UserService
    @GetMapping
    fun list (): ResponseEntity<*> {
        return ResponseEntity(userService.list(), HttpStatus.OK)
    }
    @PostMapping
    fun save (@RequestBody modelo:User): ResponseEntity<User> {
        return ResponseEntity(userService.save(modelo), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody modelo:User): ResponseEntity<User> {
        return ResponseEntity(userService.update(modelo), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody modelo:User): ResponseEntity<User> {
        return ResponseEntity(userService.updateName(modelo), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*> {
        println("Entered Get BY ID")
        return ResponseEntity(userService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):String?{
        println("Entered Delete By ID")
        return userService.delete(id)
    }
}