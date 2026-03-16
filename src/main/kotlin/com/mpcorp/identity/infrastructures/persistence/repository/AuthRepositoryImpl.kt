package com.mpcorp.identity.infrastructures.persistence.repository

import com.mpcorp.identity.domain.entity.AuthEntity
import com.mpcorp.identity.domain.repository.AuthRepository
import com.mpcorp.identity.infrastructures.persistence.jpa_repository.AuthJpaRepository
import com.mpcorp.identity.infrastructures.security.utils.JwtUtils
import com.mpcorp.identity.presentation.request.SignInRequest
import com.mpcorp.identity.presentation.request.SignUpRequest
import com.mpcorp.identity.presentation.response.SignInResponse
import com.mpcorp.identity.presentation.response.SignUpResponse
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AuthRepositoryImpl(
    private val authJpaRepository: AuthJpaRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtils: JwtUtils
) : AuthRepository {
    override fun signIn(signInRequest: SignInRequest): SignInResponse {
        val signIn = authJpaRepository.findUserByPhoneOrEmail(signInRequest.username) ?: throw ResponseStatusException(
            HttpStatus.UNAUTHORIZED, "No user found with username: ${signInRequest.username}"
        )
        return if (passwordEncoder.matches(signInRequest.password, signIn.password)) {
            SignInResponse(
                token = jwtUtils.generateToken(userId = signIn.id.toString(), role = signIn.role.name),
                status = 200,
                message = "Success"
            )
        } else {
            SignInResponse(
                token = "",
                status = 200,
                message = "Tên tài khoản hoặc mật khẩu không chính xác"
            )
        }
    }

    override fun signUp(signUpRequest: SignUpRequest): SignUpResponse {
        val existsPhone = authJpaRepository.findUserByPhoneOrEmail(signUpRequest.phone)
        val existsEmail = authJpaRepository.findUserByPhoneOrEmail(signUpRequest.email)

        if (existsPhone == null && existsEmail == null) {
            val register = authJpaRepository.save(
                AuthEntity(
                    phone = signUpRequest.phone,
                    email = signUpRequest.email,
                    password = passwordEncoder.encode(signUpRequest.password),
                )
            )
            return SignUpResponse(
                token = jwtUtils.generateToken(userId = register.id.toString(), role = register.role.name),
                status = 200,
                message = "Success"
            )
        } else {
            return SignUpResponse(
                status = 200,
                token = "",
                message = "Tài khoản đã tồn tại"
            )
        }
    }
}