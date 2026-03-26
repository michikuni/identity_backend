package com.mpcorp.identity.presentation.controller

import com.mpcorp.identity.application.dto.contract.CreateContractCommand
import com.mpcorp.identity.application.dto.contract.DeleteContractCommand
import com.mpcorp.identity.application.dto.contract.GetContractResponseCommand
import com.mpcorp.identity.application.dto.contract.UpdateContractCommand
import com.mpcorp.identity.application.usecase.contract.CreateContractUseCase
import com.mpcorp.identity.application.usecase.contract.DeleteContractUseCase
import com.mpcorp.identity.application.usecase.contract.GetContractUseCase
import com.mpcorp.identity.application.usecase.contract.UpdateContractUseCase
import com.mpcorp.identity.common.constant.ErrorCodes
import com.mpcorp.identity.common.constant.StatusMessage
import com.mpcorp.identity.common.exception.ContractNotFoundException
import com.mpcorp.identity.common.exception.EmployeeNotFoundException
import com.mpcorp.identity.domain.entity.EmployeeEntity
import com.mpcorp.identity.domain.repository.EmployeeRepository
import com.mpcorp.identity.infrastructures.security.user_details.CustomUserDetails
import com.mpcorp.identity.presentation.api.ContractApi
import com.mpcorp.identity.presentation.mapper.toDto
import com.mpcorp.identity.presentation.request.contract.CreateContractRequest
import com.mpcorp.identity.presentation.request.contract.UpdateContractRequest
import com.mpcorp.identity.presentation.response.contract.ContractResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RestController

@RestController
class ContractController(
    private val employeeRepository: EmployeeRepository,
    private val createContractUseCase: CreateContractUseCase,
    private val updateContractUseCase: UpdateContractUseCase,
    private val getContractUseCase: GetContractUseCase,
    private val deleteContractUseCase: DeleteContractUseCase,
) : ContractApi {

    override fun createContract(request: CreateContractRequest): ContractResponse {
        val employee = currentEmployee()
        val command = CreateContractCommand(
            employee = employee,
            typeContract = request.typeContract,
            startDate = request.startDate,
            endDate = request.endDate,
            contractExpire = request.contractExpire,
            probationStartDate = request.probationStartDate,
            probationEndDate = request.probationEndDate,
            taxCode = request.taxCode,
            socialInsuranceNumber = request.socialInsuranceNumber,
            healthInsuranceNumber = request.healthInsuranceNumber,
        )

        val contract = createContractUseCase.execute(command)
        return ContractResponse(
            status = ErrorCodes.CREATE_SUCCESS,
            message = StatusMessage.SUCCESS,
            data = contract.toDto(),
        )
    }

    override fun updateContract(request: UpdateContractRequest): ContractResponse {
        val employee = currentEmployee()
        val command = UpdateContractCommand(
            id = request.id,
            employee = employee,
            typeContract = request.typeContract,
            startDate = request.startDate,
            endDate = request.endDate,
            contractExpire = request.contractExpire,
            probationStartDate = request.probationStartDate,
            probationEndDate = request.probationEndDate,
            taxCode = request.taxCode,
            socialInsuranceNumber = request.socialInsuranceNumber,
            healthInsuranceNumber = request.healthInsuranceNumber,
        )

        val contract = updateContractUseCase.execute(command)
        return ContractResponse(
            status = ErrorCodes.UPDATE_SUCCESS,
            message = StatusMessage.SUCCESS,
            data = contract.toDto(),
        )
    }

    override fun getContract(): ContractResponse {
        val employee = currentEmployee()
        val employeeId = employee.id ?: throw EmployeeNotFoundException()

        val contract = getContractUseCase.execute(GetContractResponseCommand(employeeId = employeeId))
            ?: throw ContractNotFoundException()

        return ContractResponse(
            status = ErrorCodes.SUCCESS,
            message = StatusMessage.SUCCESS,
            data = contract.toDto(),
        )
    }

    override fun deleteContract(): ContractResponse {
        val employee = currentEmployee()
        val employeeId = employee.id ?: throw EmployeeNotFoundException()

        deleteContractUseCase.execute(DeleteContractCommand(employeeId = employeeId))
        return ContractResponse(
            status = ErrorCodes.DELETE_SUCCESS,
            message = StatusMessage.SUCCESS,
            data = null,
        )
    }

    private fun currentEmployee(): EmployeeEntity {
        val principal = SecurityContextHolder.getContext().authentication?.principal
        val userDetails = principal as? CustomUserDetails ?: throw EmployeeNotFoundException()
        val authId = userDetails.getId() ?: throw EmployeeNotFoundException()

        return employeeRepository.findEmployeeByAuthId(authId) ?: throw EmployeeNotFoundException()
    }
}

