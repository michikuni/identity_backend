package com.mpcorp.identity.service.user

import com.mpcorp.identity.entity.user.User
import com.mpcorp.identity.repository.user.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getAll(): List<User> {
        return userRepository.findAll()
    }

    fun getById(id: UUID): User {
        return userRepository.findById(id)
            .orElseThrow { RuntimeException("User not found") }
    }

    fun create(user: User): User {
        return userRepository.save(user)
    }

    fun update(id: UUID, user: User): User {

        val existing = getById(id)

        val updated = existing.copy(
            name = user.name,
            email = user.email,
            age = user.age
        )

        return userRepository.save(updated)
    }

    fun delete(id: UUID) {
        userRepository.deleteById(id)
    }
}