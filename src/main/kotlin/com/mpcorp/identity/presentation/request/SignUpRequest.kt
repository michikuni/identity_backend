package com.mpcorp.identity.presentation.request

data class SignUpRequest (
    val email: String,
    val phone: String,
    val password: String
)