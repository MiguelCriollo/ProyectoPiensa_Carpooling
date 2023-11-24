package com.example.Aventon.models

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "users")
class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="first_name")
    var firstName: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="last_name")
    var lastName: String?= null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name="cell_number")
    var cellNumber: String? =null
    @Email(message="Correo Valido???Noze")
    var email:String?=null
    @NotBlank(message="Campo obligatorio") //validate
    var password:String?=null
    @Column(name="id_driver")
    var idDriver:Boolean?=false
    var identificacion:String?=null
}