package com.mpcorp.identity.infrastructures.persistence.jpa_repository

import com.mpcorp.identity.infrastructures.persistence.jpa_entity.EmployeeJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface EmployeeJpaRepository : JpaRepository<EmployeeJpaEntity, Long>