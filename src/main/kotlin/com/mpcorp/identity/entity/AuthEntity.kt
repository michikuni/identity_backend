package com.mpcorp.identity.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "auth")
data class AuthEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(name = "email")
    var email: String,

    @Column(name = "phone")
    var phone: String,

    @Column(name = "password")
    var password: String?,

    @Column(name = "role")
    var role: EmployeeRole = EmployeeRole.EMPLOYEE,
)

enum class EmployeeRole {
    EMPLOYEE, ADMIN, MANAGER, CHIEF
}