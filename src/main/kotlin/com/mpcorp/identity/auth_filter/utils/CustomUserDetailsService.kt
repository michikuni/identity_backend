package com.mpcorp.identity.auth_filter.utils

import com.mpcorp.identity.repository.auth.AuthRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService (
    private val authRepository: AuthRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = authRepository.findUserByPhoneOrEmail(username);
        return CustomUserDetails(user)
    }
}