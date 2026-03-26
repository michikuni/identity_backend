package com.mpcorp.identity.application.usecase.employee

import com.mpcorp.identity.application.dto.employee.UpdateEmployeeCommand
import com.mpcorp.identity.application.mapper.toDomainEntity
import com.mpcorp.identity.domain.entity.EmployeeEntity
import com.mpcorp.identity.domain.repository.EmployeeRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UpdateCurrentEmployeeUseCase(
    private val employeeRepository: EmployeeRepository,
) {
    fun execute(authId: UUID, command: UpdateEmployeeCommand): EmployeeEntity {
        val updated = command.toDomainEntity()
        return employeeRepository.updateEmployeeByAuthId(authId, updated)
    }
}

