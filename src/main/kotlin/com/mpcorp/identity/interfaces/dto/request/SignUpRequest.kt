package com.mpcorp.identity.interfaces.dto.request

data class SignUpRequest (
    val email: String,
    val phone: String,
    val password: String
)