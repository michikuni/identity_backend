package com.mpcorp.identity.presentation.controller

import com.mpcorp.identity.application.dto.SignInCommand
import com.mpcorp.identity.application.dto.SignUpCommand
import com.mpcorp.identity.application.usecase.auth.SignInUseCase
import com.mpcorp.identity.application.usecase.auth.SignUpUseCase
import com.mpcorp.identity.common.constant.ErrorCodes
import com.mpcorp.identity.common.constant.StatusMessage
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
    private val signUpUseCase: SignUpUseCase,
) : AuthApi {
    override fun signIn(@RequestBody signInRequest: SignInRequest): SignInResponse {
        val signInSuccess = signInUseCase.execute(
            SignInCommand(
                username = signInRequest.username,
                password = signInRequest.password
            )
        )
        return SignInResponse(
                status = ErrorCodes.SUCCESS,
                message = StatusMessage.SUCCESS,
                token = signInSuccess
        )
    }

    override fun signUp(@RequestBody signUpRequest: SignUpRequest): SignUpResponse {
        val signUpSuccess = signUpUseCase.execute(SignUpCommand(phone = signUpRequest.phone, password = signUpRequest.password, email = signUpRequest.email))
        return SignUpResponse(
            status = ErrorCodes.CREATE_SUCCESS,
            message = StatusMessage.SUCCESS,
            token = signUpSuccess
        )
    }
}