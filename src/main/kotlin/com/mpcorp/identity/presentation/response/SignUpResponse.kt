package com.mpcorp.identity.presentation.response

data class SignUpResponse (
    val status: Int,
    val message: String,
    val token: String,
)