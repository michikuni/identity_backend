package com.mpcorp.identity.application.usecase.payroll

import com.mpcorp.identity.application.dto.payroll.CreatePayrollCommand
import com.mpcorp.identity.application.mapper.toDomainEntity
import com.mpcorp.identity.domain.entity.PayrollEntity
import com.mpcorp.identity.domain.repository.PayrollRepository
import org.springframework.stereotype.Service

@Service
class CreatePayrollUseCase(
    private val payrollRepository: PayrollRepository,
) {
    fun execute(command: CreatePayrollCommand): PayrollEntity {
        val payroll = command.toDomainEntity()
        return payrollRepository.createPayrollById(payroll)
    }
}

