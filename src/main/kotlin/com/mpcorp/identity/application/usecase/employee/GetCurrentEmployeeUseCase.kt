package com.mpcorp.identity.application.usecase.employee

import com.mpcorp.identity.common.exception.EmployeeNotFoundException
import com.mpcorp.identity.domain.entity.EmployeeEntity
import com.mpcorp.identity.domain.repository.EmployeeRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GetCurrentEmployeeUseCase(
    private val employeeRepository: EmployeeRepository,
) {
    fun execute(authId: UUID): EmployeeEntity {
        return employeeRepository.findEmployeeByAuthId(authId) ?: throw EmployeeNotFoundException()
    }
}

