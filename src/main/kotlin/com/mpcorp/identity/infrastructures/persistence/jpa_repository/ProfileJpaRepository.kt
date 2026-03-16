package com.mpcorp.identity.infrastructures.persistence.jpa_repository

import com.mpcorp.identity.domain.entity.ProfileEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProfileJpaRepository : JpaRepository<ProfileEntity, UUID>