package com.mpcorp.identity.infrastructures.security.utils

import com.mpcorp.identity.infrastructures.persistence.jpa_repository.AuthJpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CustomUserDetailsService (
    private val authJpaRepository: AuthJpaRepository
): UserDetailsService {
    fun loadUserByUserId(userId: UUID): CustomUserDetails {
        val user = authJpaRepository.findById(userId).orElseThrow{ Exception("User with id $userId not found") }
        return CustomUserDetails(user)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = authJpaRepository.findUserByPhoneOrEmail(username) ?: throw  Exception("User with id $username not found")
        return CustomUserDetails(user)
    }
}