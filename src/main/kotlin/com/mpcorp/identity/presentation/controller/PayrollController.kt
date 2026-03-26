package com.mpcorp.identity.presentation.controller

import com.mpcorp.identity.application.dto.payroll.CreatePayrollCommand
import com.mpcorp.identity.application.dto.payroll.DeletePayrollCommand
import com.mpcorp.identity.application.dto.payroll.GetPayrollRequestCommand
import com.mpcorp.identity.application.dto.payroll.UpdatePayrollCommand
import com.mpcorp.identity.application.usecase.payroll.CreatePayrollUseCase
import com.mpcorp.identity.application.usecase.payroll.DeletePayrollUseCase
import com.mpcorp.identity.application.usecase.payroll.GetPayrollUseCase
import com.mpcorp.identity.application.usecase.payroll.UpdatePayrollUseCase
import com.mpcorp.identity.common.constant.ErrorCodes
import com.mpcorp.identity.common.constant.StatusMessage
import com.mpcorp.identity.common.exception.EmployeeNotFoundException
import com.mpcorp.identity.common.exception.PayrollNotFoundException
import com.mpcorp.identity.domain.repository.EmployeeRepository
import com.mpcorp.identity.infrastructures.security.user_details.CustomUserDetails
import com.mpcorp.identity.presentation.api.PayrollApi
import com.mpcorp.identity.presentation.mapper.toDto
import com.mpcorp.identity.presentation.request.payroll.CreatePayrollRequest
import com.mpcorp.identity.presentation.request.payroll.UpdatePayrollRequest
import com.mpcorp.identity.presentation.response.payroll.PayrollResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RestController

@RestController
class PayrollController(
    private val employeeRepository: EmployeeRepository,
    private val createPayrollUseCase: CreatePayrollUseCase,
    private val updatePayrollUseCase: UpdatePayrollUseCase,
    private val getPayrollUseCase: GetPayrollUseCase,
    private val deletePayrollUseCase: DeletePayrollUseCase,
) : PayrollApi {
    override fun create(request: CreatePayrollRequest): PayrollResponse {
        val authId = currentAuthId()
        val payroll = createPayrollUseCase.execute(
            authId = authId,
            command = CreatePayrollCommand(
                salaryType = request.salaryType,
                baseSalary = request.baseSalary,
                bonusSalary = request.bonusSalary,
                overTimeRate = request.overTimeRate,
                totalIncome = request.totalIncome,
                currency = request.currency,
                payDay = request.payDay,
                bankAccountNumber = request.bankAccountNumber,
                bankAccountName = request.bankAccountName,
                bankName = request.bankName,
                bankBranch = request.bankBranch,
            )
        )

        return PayrollResponse(
            status = ErrorCodes.CREATE_SUCCESS,
            message = StatusMessage.SUCCESS,
            data = payroll.toDto(),
        )
    }

    override fun update(request: UpdatePayrollRequest): PayrollResponse {
        val authId = currentAuthId()
        val payroll = updatePayrollUseCase.execute(
            authId = authId,
            command = UpdatePayrollCommand(
                id = request.id,
                salaryType = request.salaryType,
                baseSalary = request.baseSalary,
                bonusSalary = request.bonusSalary,
                overTimeRate = request.overTimeRate,
                totalIncome = request.totalIncome,
                currency = request.currency,
                payDay = request.payDay,
                bankAccountNumber = request.bankAccountNumber,
                bankAccountName = request.bankAccountName,
                bankName = request.bankName,
                bankBranch = request.bankBranch,
            )
        )

        return PayrollResponse(
            status = ErrorCodes.UPDATE_SUCCESS,
            message = StatusMessage.SUCCESS,
            data = payroll.toDto(),
        )
    }

    override fun get(): PayrollResponse {
        val employeeId = currentEmployeeId()
        val payroll = getPayrollUseCase.execute(GetPayrollRequestCommand(employeeId = employeeId)) ?: throw PayrollNotFoundException()

        return PayrollResponse(
            status = ErrorCodes.SUCCESS,
            message = StatusMessage.SUCCESS,
            data = payroll.toDto(),
        )
    }

    override fun delete(): PayrollResponse {
        val employeeId = currentEmployeeId()
        deletePayrollUseCase.execute(DeletePayrollCommand(employeeId = employeeId))

        return PayrollResponse(
            status = ErrorCodes.DELETE_SUCCESS,
            message = StatusMessage.SUCCESS,
            data = null,
        )
    }

    private fun currentAuthId() =
        (SecurityContextHolder.getContext().authentication?.principal as? CustomUserDetails)?.getId()
            ?: throw EmployeeNotFoundException()

    private fun currentEmployeeId(): Long {
        val authId = currentAuthId()
        val employee = employeeRepository.findEmployeeByAuthId(authId) ?: throw EmployeeNotFoundException()
        return employee.id ?: throw EmployeeNotFoundException()
    }
}

