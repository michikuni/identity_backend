package com.mpcorp.identity.interfaces.dto.response

data class SignUpResponse (
    val status: Int,
    val message: String,
    val token: String,
)