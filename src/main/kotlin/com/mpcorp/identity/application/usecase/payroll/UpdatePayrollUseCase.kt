package com.mpcorp.identity.application.usecase.payroll

import com.mpcorp.identity.application.dto.payroll.UpdatePayrollCommand
import com.mpcorp.identity.application.mapper.toDomainEntity
import com.mpcorp.identity.domain.entity.PayrollEntity
import com.mpcorp.identity.domain.repository.PayrollRepository
import org.springframework.stereotype.Service

@Service
class UpdatePayrollUseCase(
    private val payrollRepository: PayrollRepository,
) {
    fun execute(command: UpdatePayrollCommand): PayrollEntity {
        val payroll = command.toDomainEntity()
        return payrollRepository.updatePayrollById(payroll)
    }
}

