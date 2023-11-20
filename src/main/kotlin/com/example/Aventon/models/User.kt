package com.example.Aventon.models

import jakarta.persistence.*
@Entity
@Table(name = "users")
class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="first_name")
    var firstName: String? = null
    @Column(name="last_name")
    var lastName: String?= null
    @Column(name="cell_number")
    var cellNumber: String? =null
    var email:String?=null
    var password:String?=null
    @Column(name="id_driver")
    var idDriver:Boolean?=false
    var identificacion:String?=null
}