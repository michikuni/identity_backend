package com.mpcorp.identity.application.dto

data class SignInCommand(
    val username: String,
    val password: String
)