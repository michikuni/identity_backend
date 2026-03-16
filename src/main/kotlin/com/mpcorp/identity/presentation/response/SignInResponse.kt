package com.mpcorp.identity.presentation.response

data class SignInResponse (
    val status: Int,
    val message: String,
    val token: String,
)