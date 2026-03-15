package com.mpcorp.identity.dto

data class LoginRequest(
    val username: String,
    val password: String
)

data class LoginResponse(
    val status: Int,
    val message: String,
    val token: String,
)

data class RegisterRequest(val email: String, val phone: String, val password: String)
data class RegisterResponse(
    val status: Int,
    val message: String,
    val token: String,
)