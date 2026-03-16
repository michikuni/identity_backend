package com.mpcorp.identity.presentation.controller

import com.mpcorp.identity.application.dto.SignInCommand
import com.mpcorp.identity.application.usecase.auth.SignInUseCase
import com.mpcorp.identity.domain.repository.AuthRepository
import com.mpcorp.identity.presentation.api.AuthApi
import com.mpcorp.identity.presentation.request.SignInRequest
import com.mpcorp.identity.presentation.request.SignUpRequest
import com.mpcorp.identity.presentation.response.SignInResponse
import com.mpcorp.identity.presentation.response.SignUpResponse
import org.springframework.web.bind.annotation.*

@RestController
class AuthController(
    private val signInUseCase: SignInUseCase,
    private val authRepository: AuthRepository,
): AuthApi {
    override fun signIn(@RequestBody signInRequest: SignInRequest): SignInResponse {
        try {
            val signInSuccess = signInUseCase.execute(SignInCommand(
                username = signInRequest.username,
                password = signInRequest.password
            ))
            return if (signInSuccess){
                SignInResponse(
                    status = 200,
                    token = "",
                    message = ""
                )
            } else {
                SignInResponse(
                    status = 400,
                    message = "",
                    token = ""
                )
            }
        } catch (e: Exception){
            throw e
        }
    }

    override fun signUp(@RequestBody signUpRequest: SignUpRequest): SignUpResponse {
        return try {
            authRepository.signUp(signUpRequest)
        } catch (e: Exception){
            throw e
        }
    }
}