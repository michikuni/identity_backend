package com.mpcorp.identity.service.auth

import com.mpcorp.identity.entity.AuthEntity
import com.mpcorp.identity.repository.auth.AuthRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val authRepository: AuthRepository
) {

    fun getAll(): List<AuthEntity> {
        return authRepository.findAll()
    }

    fun getById(id: UUID): AuthEntity {
        return authRepository.findById(id)
            .orElseThrow { RuntimeException("User not found") }
    }

    fun create(user: AuthEntity): AuthEntity {
        return authRepository.save(user)
    }

    fun update(id: UUID, user: AuthEntity): AuthEntity {

        val existing = getById(id)

        val updated = existing.copy(
            phone = user.phone,
            email = user.email,
            password = user.password,
        )

        return authRepository.save(updated)
    }

    fun delete(id: UUID) {
        authRepository.deleteById(id)
    }
}