package com.mpcorp.identity.infrastructures.persistence

import com.mpcorp.identity.domain.entities.ProfileEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProfileRepository : JpaRepository<ProfileEntity, UUID>