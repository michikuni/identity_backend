package com.mpcorp.identity.interfaces.controller

import com.mpcorp.identity.interfaces.dto.request.SignInRequest
import com.mpcorp.identity.interfaces.dto.request.SignUpRequest
import com.mpcorp.identity.interfaces.dto.response.SignInResponse
import com.mpcorp.identity.interfaces.dto.response.SignUpResponse
import com.mpcorp.identity.service.AuthService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/sign-in")
    fun login(@RequestBody signInRequest: SignInRequest): SignInResponse {
        return try {
            authService.login(signInRequest)
        } catch (e: Exception){
            throw e
        }
    }

    @PostMapping("/sign-up")
    fun register(@RequestBody signUpRequest: SignUpRequest): SignUpResponse {
        return try {
            authService.register(signUpRequest)
        } catch (e: Exception){
            throw e
        }
    }
}