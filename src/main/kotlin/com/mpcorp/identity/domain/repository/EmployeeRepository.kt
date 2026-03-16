package com.mpcorp.identity.domain.repository

import com.mpcorp.identity.domain.entity.EmployeeEntity
import java.util.UUID

interface EmployeeRepository {
    fun createEmployeeById(id: UUID, employee: EmployeeEntity): EmployeeEntity
    fun findEmployeeById(id: UUID): EmployeeEntity?
    fun updateEmployeeById(id: UUID, employee: EmployeeEntity): EmployeeEntity
    fun deleteEmployeeById(id: UUID)
}