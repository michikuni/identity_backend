package com.mpcorp.identity.application.usecase.payroll

import com.mpcorp.identity.application.dto.payroll.GetPayrollRequestCommand
import com.mpcorp.identity.domain.entity.PayrollEntity
import com.mpcorp.identity.domain.repository.PayrollRepository
import org.springframework.stereotype.Service

@Service
class GetPayrollUseCase(
    private val payrollRepository: PayrollRepository,
) {
    fun execute(command: GetPayrollRequestCommand): PayrollEntity? {
        return payrollRepository.findPayrollById(command.employeeId)
    }
}

