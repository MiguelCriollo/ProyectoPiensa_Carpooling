package com.example.Aventon.repositories
import com.example.Aventon.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository:JpaRepository<User,Long?> {
    fun findById (id: Long?): User?
}