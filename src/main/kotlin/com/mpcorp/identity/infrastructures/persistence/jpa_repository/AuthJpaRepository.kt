package com.mpcorp.identity.infrastructures.persistence.jpa_repository

import com.mpcorp.identity.domain.entity.AuthEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface AuthJpaRepository : JpaRepository<AuthEntity, UUID> {
    @Query(value = "SELECT * FROM auth WHERE (phone = :username OR email = :username)", nativeQuery = true)
    fun findUserByPhoneOrEmail(username: String): AuthEntity?
}