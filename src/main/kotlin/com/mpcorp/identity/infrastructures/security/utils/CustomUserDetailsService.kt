package com.mpcorp.identity.infrastructures.security.utils

import com.mpcorp.identity.infrastructures.persistence.AuthRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CustomUserDetailsService (
    private val authRepository: AuthRepository
): UserDetailsService {
    fun loadUserByUserId(userId: UUID): CustomUserDetails {
        val user = authRepository.findById(userId).orElseThrow{ Exception("User with id $userId not found") }
        return CustomUserDetails(user)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = authRepository.findUserByPhoneOrEmail(username) ?: throw  Exception("User with id $username not found")
        return CustomUserDetails(user)
    }
}