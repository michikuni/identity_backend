package com.mpcorp.identity.entity.user

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val email: String,

    val age: Int

)