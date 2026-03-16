package com.mpcorp.identity.application.usecase.auth

import com.mpcorp.identity.application.dto.SignInCommand
import com.mpcorp.identity.domain.repository.AuthRepository
import com.mpcorp.identity.presentation.request.SignInRequest
import org.springframework.stereotype.Service

@Service
class SignInUseCase (
    private val authRepository: AuthRepository
){
    fun execute(signInCommand: SignInCommand) : Boolean {
        authRepository.signIn(SignInRequest(username = signInCommand.username, password = signInCommand.password))
        return true
    }
}