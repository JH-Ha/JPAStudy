package com.example.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Hello {
    @Id @GeneratedValue
    var id: Long? = null
}