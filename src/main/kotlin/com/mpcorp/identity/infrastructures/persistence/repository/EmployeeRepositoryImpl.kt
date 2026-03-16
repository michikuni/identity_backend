package com.mpcorp.identity.infrastructures.persistence.repository

import com.mpcorp.identity.domain.entity.EmployeeEntity
import com.mpcorp.identity.domain.repository.EmployeeRepository
import java.util.UUID

class EmployeeRepositoryImpl : EmployeeRepository {
    override fun createEmployeeById(
        id: UUID,
        employee: EmployeeEntity
    ): EmployeeEntity {
        TODO("Not yet implemented")
    }

    override fun findEmployeeById(id: UUID): EmployeeEntity? {
        TODO("Not yet implemented")
    }

    override fun updateEmployeeById(
        id: UUID,
        employee: EmployeeEntity
    ): EmployeeEntity {
        TODO("Not yet implemented")
    }

    override fun deleteEmployeeById(id: UUID) {
        TODO("Not yet implemented")
    }
}