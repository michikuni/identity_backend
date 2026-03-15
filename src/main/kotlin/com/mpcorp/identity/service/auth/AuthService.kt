package com.mpcorp.identity.service.auth

import com.mpcorp.identity.auth_filter.utils.JwtUtils
import com.mpcorp.identity.dto.LoginRequest
import com.mpcorp.identity.dto.LoginResponse
import com.mpcorp.identity.dto.RegisterRequest
import com.mpcorp.identity.dto.RegisterResponse
import com.mpcorp.identity.entity.AuthEntity
import com.mpcorp.identity.repository.auth.AuthRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AuthService(
    private val authRepository: AuthRepository,
    private val passwordEncoder: BCryptPasswordEncoder,
    private val jwtUtils: JwtUtils
) {

    fun login(loginRequest: LoginRequest): LoginResponse {
        val login = authRepository.findUserByPhoneOrEmail(loginRequest.username) ?: throw ResponseStatusException(
            HttpStatus.UNAUTHORIZED, "No user found with username: ${loginRequest.username}")
        print(login)
        return if(passwordEncoder.matches(loginRequest.password, login.password)) {
            LoginResponse(
                token = jwtUtils.generateToken(username = login.phone),
                status = 200,
                message = "Success"
            )
        } else {
            LoginResponse(
                token = "",
                status = 200,
                message = "Tên tài khoản hoặc mật khẩu không chính xác"
            )
        }
    }

    fun register(registerRequest: RegisterRequest): RegisterResponse {
        val existsPhone = authRepository.findUserByPhoneOrEmail(registerRequest.phone)
        val existsEmail = authRepository.findUserByPhoneOrEmail(registerRequest.email)

        if(existsPhone == null && existsEmail == null) {
          authRepository.save(AuthEntity(
              phone = registerRequest.phone,
              email = registerRequest.email,
              password = passwordEncoder.encode(registerRequest.password),
          ))
          return RegisterResponse(
              token = jwtUtils.generateToken(username = registerRequest.email),
              status = 200,
              message = "Success"
          )
        } else {
            return RegisterResponse(
                status = 200,
                token = "",
                message = "Tài khoản đã tồn tại"
            )
        }
    }
}