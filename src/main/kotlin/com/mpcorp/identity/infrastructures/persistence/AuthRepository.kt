package com.mpcorp.identity.infrastructures.persistence

import com.mpcorp.identity.domain.entities.AuthEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface AuthRepository : JpaRepository<AuthEntity, UUID> {
    @Query(value = "SELECT * FROM auth WHERE (phone = :username OR email = :username)", nativeQuery = true)
    fun findUserByPhoneOrEmail(username: String): AuthEntity?
}