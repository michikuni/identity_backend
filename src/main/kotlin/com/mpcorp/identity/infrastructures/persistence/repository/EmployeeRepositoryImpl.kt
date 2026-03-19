package com.mpcorp.identity.infrastructures.persistence.repository

import com.mpcorp.identity.domain.entity.EmployeeEntity
import com.mpcorp.identity.domain.repository.EmployeeRepository
import com.mpcorp.identity.infrastructures.persistence.jpa_repository.EmployeeJpaRepository
import com.mpcorp.identity.infrastructures.persistence.mapper.toDomainEntity
import com.mpcorp.identity.infrastructures.persistence.mapper.toPersistentEntity
import java.util.UUID

class EmployeeRepositoryImpl(
    private val employeeJpaRepository: EmployeeJpaRepository
) : EmployeeRepository {
    override fun createEmployee(
        employee: EmployeeEntity
    ): EmployeeEntity {
        val employeeJpaData = employee.toPersistentEntity()
        val dataSaveEmployee = employeeJpaRepository.save(employeeJpaData)
        return dataSaveEmployee.toDomainEntity()
    }

    override fun findEmployeeByAuthId(id: UUID): EmployeeEntity? {
        val employeeJpaData = employeeJpaRepository.findEmployeeByAuthId(id) ?: return null
        return employeeJpaData.toDomainEntity()
    }

    override fun updateEmployeeByAuthId(
        id: UUID,
        employee: EmployeeEntity
    ): EmployeeEntity {
        val existingEmployee = employeeJpaRepository.findEmployeeByAuthId(id) ?: throw RuntimeException("Employee not found")
        existingEmployee.apply {
            contract = employee.contract?.toPersistentEntity()
            profile = employee.profile?.toPersistentEntity()
            payroll = employee.payroll?.toPersistentEntity()
            manager = employee.manager?.toPersistentEntity()
            createdBy = employee.createdBy
            department = employee.department
            position = employee.position
            status = employee.status
            workingType = employee.workingType
            isActive = employee.isActive
            createdAt = employee.createdAt
            updatedAt = employee.updatedAt
            note = employee.note
        }

        return employeeJpaRepository.save(existingEmployee).toDomainEntity()
    }

    override fun deleteEmployeeByAuthId(id: UUID) {
        employeeJpaRepository.deleteEmployeeByAuthId(id)
    }
}