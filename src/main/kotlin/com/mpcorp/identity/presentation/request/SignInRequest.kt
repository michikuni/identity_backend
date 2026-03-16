package com.mpcorp.identity.presentation.request

data class SignInRequest (
    val username: String,
    val password: String
)