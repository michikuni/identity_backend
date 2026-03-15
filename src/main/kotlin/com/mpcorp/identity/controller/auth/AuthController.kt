package com.mpcorp.identity.controller.auth

import com.mpcorp.identity.dto.LoginRequest
import com.mpcorp.identity.dto.LoginResponse
import com.mpcorp.identity.dto.RegisterRequest
import com.mpcorp.identity.dto.RegisterResponse
import com.mpcorp.identity.service.auth.AuthService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): LoginResponse {
        return try {
            authService.login(loginRequest)
        } catch (e: Exception){
            throw e
        }
    }

    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest): RegisterResponse {
        return try {
            authService.register(registerRequest)
        } catch (e: Exception){
            throw e
        }
    }
}