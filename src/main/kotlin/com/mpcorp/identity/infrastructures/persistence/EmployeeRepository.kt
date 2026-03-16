package com.mpcorp.identity.infrastructures.persistence

import com.mpcorp.identity.domain.entities.EmployeeEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface EmployeeRepository : JpaRepository<EmployeeEntity, UUID>