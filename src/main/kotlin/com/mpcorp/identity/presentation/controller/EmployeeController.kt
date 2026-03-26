package com.mpcorp.identity.presentation.controller

import com.mpcorp.identity.application.dto.employee.CreateEmployeeCommand
import com.mpcorp.identity.application.dto.employee.UpdateEmployeeCommand
import com.mpcorp.identity.application.usecase.employee.CreateCurrentEmployeeUseCase
import com.mpcorp.identity.application.usecase.employee.DeleteCurrentEmployeeUseCase
import com.mpcorp.identity.application.usecase.employee.GetCurrentEmployeeUseCase
import com.mpcorp.identity.application.usecase.employee.UpdateCurrentEmployeeUseCase
import com.mpcorp.identity.common.constant.ErrorCodes
import com.mpcorp.identity.common.constant.StatusMessage
import com.mpcorp.identity.common.exception.EmployeeNotFoundException
import com.mpcorp.identity.infrastructures.security.user_details.CustomUserDetails
import com.mpcorp.identity.presentation.api.EmployeeApi
import com.mpcorp.identity.presentation.mapper.toDto
import com.mpcorp.identity.presentation.request.employee.CreateEmployeeRequest
import com.mpcorp.identity.presentation.request.employee.UpdateEmployeeRequest
import com.mpcorp.identity.presentation.response.employee.EmployeeResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeController(
    private val createCurrentEmployeeUseCase: CreateCurrentEmployeeUseCase,
    private val getCurrentEmployeeUseCase: GetCurrentEmployeeUseCase,
    private val updateCurrentEmployeeUseCase: UpdateCurrentEmployeeUseCase,
    private val deleteCurrentEmployeeUseCase: DeleteCurrentEmployeeUseCase,
) : EmployeeApi {
    override fun create(request: CreateEmployeeRequest): EmployeeResponse {
        val username = currentUsername()
        val employee = createCurrentEmployeeUseCase.execute(
            username = username,
            command = CreateEmployeeCommand(
                department = request.department,
                position = request.position,
                status = request.status,
                workingType = request.workingType,
                isActive = request.isActive,
                managerAuthId = request.managerAuthId,
                createdAt = request.createdAt,
                updatedAt = request.updatedAt,
                createdBy = request.createdBy,
                note = request.note,
            )
        )

        return EmployeeResponse(
            status = ErrorCodes.CREATE_SUCCESS,
            message = StatusMessage.SUCCESS,
            data = employee.toDto(),
        )
    }

    override fun get(): EmployeeResponse {
        val authId = currentAuthId()
        val employee = getCurrentEmployeeUseCase.execute(authId)
        return EmployeeResponse(
            status = ErrorCodes.SUCCESS,
            message = StatusMessage.SUCCESS,
            data = employee.toDto(),
        )
    }

    override fun update(request: UpdateEmployeeRequest): EmployeeResponse {
        val authId = currentAuthId()
        val employee = updateCurrentEmployeeUseCase.execute(
            authId = authId,
            command = UpdateEmployeeCommand(
                department = request.department,
                position = request.position,
                status = request.status,
                workingType = request.workingType,
                isActive = request.isActive,
                updatedAt = request.updatedAt,
                note = request.note,
            )
        )

        return EmployeeResponse(
            status = ErrorCodes.UPDATE_SUCCESS,
            message = StatusMessage.SUCCESS,
            data = employee.toDto(),
        )
    }

    override fun delete(): EmployeeResponse {
        val authId = currentAuthId()
        deleteCurrentEmployeeUseCase.execute(authId)
        return EmployeeResponse(
            status = ErrorCodes.DELETE_SUCCESS,
            message = StatusMessage.SUCCESS,
            data = null,
        )
    }

    private fun currentAuthId() =
        (SecurityContextHolder.getContext().authentication?.principal as? CustomUserDetails)?.getId()
            ?: throw EmployeeNotFoundException()

    private fun currentUsername() =
        (SecurityContextHolder.getContext().authentication?.principal as? CustomUserDetails)?.username
            ?: throw EmployeeNotFoundException()
}

