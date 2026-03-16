package com.mpcorp.identity.presentation.api

import com.mpcorp.identity.presentation.request.SignInRequest
import com.mpcorp.identity.presentation.request.SignUpRequest
import com.mpcorp.identity.presentation.response.SignInResponse
import com.mpcorp.identity.presentation.response.SignUpResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/api/auth")
interface AuthApi {
    @PostMapping("/sign-in")
    fun signIn(@RequestBody signInRequest: SignInRequest): SignInResponse

    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): SignUpResponse
}