package com.mpcorp.identity.interfaces.dto.request

data class SignInRequest (
    val username: String,
    val password: String
)