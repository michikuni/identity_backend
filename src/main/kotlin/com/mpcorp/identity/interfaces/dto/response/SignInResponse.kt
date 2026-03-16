package com.mpcorp.identity.interfaces.dto.response

data class SignInResponse (
    val status: Int,
    val message: String,
    val token: String,
)