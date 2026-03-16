package com.mpcorp.identity.domain.repository

import com.mpcorp.identity.domain.entity.AuthEntity
import com.mpcorp.identity.infrastructures.persistence.jpa_repository.AuthJpaRepository
import com.mpcorp.identity.common.utils.JwtUtils
import com.mpcorp.identity.presentation.request.SignInRequest
import com.mpcorp.identity.presentation.request.SignUpRequest
import com.mpcorp.identity.presentation.response.SignInResponse
import com.mpcorp.identity.presentation.response.SignUpResponse
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

interface AuthRepository {
    fun findByUsername(username: String): AuthEntity?
    fun create(authEntity: AuthEntity): AuthEntity
}