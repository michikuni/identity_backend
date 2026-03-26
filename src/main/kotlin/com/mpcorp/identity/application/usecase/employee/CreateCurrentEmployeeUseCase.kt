package com.mpcorp.identity.application.usecase.employee

import com.mpcorp.identity.application.dto.employee.CreateEmployeeCommand
import com.mpcorp.identity.application.mapper.toDomainEntity
import com.mpcorp.identity.common.exception.EmployeeNotFoundException
import com.mpcorp.identity.domain.entity.EmployeeEntity
import com.mpcorp.identity.domain.repository.AuthRepository
import com.mpcorp.identity.domain.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class CreateCurrentEmployeeUseCase(
    private val employeeRepository: EmployeeRepository,
) {
    fun execute(command: CreateEmployeeCommand): EmployeeEntity {
        val employee = command.toDomainEntity()
        return employeeRepository.createEmployee(employee)
    }
}

