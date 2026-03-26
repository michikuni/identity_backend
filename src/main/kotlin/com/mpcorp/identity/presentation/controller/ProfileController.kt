package com.mpcorp.identity.presentation.controller

import com.mpcorp.identity.application.dto.profile.CreateProfileCommand
import com.mpcorp.identity.application.dto.profile.DeleteProfileCommand
import com.mpcorp.identity.application.dto.profile.GetProfileRequestCommand
import com.mpcorp.identity.application.dto.profile.UpdateProfileCommand
import com.mpcorp.identity.application.usecase.profile.CreateProfileUseCase
import com.mpcorp.identity.application.usecase.profile.DeleteProfileUseCase
import com.mpcorp.identity.application.usecase.profile.GetProfileUseCase
import com.mpcorp.identity.application.usecase.profile.UpdateProfileUseCase
import com.mpcorp.identity.common.constant.ErrorCodes
import com.mpcorp.identity.common.constant.StatusMessage
import com.mpcorp.identity.common.exception.EmployeeNotFoundException
import com.mpcorp.identity.common.exception.ProfileNotFoundException
import com.mpcorp.identity.domain.repository.EmployeeRepository
import com.mpcorp.identity.infrastructures.security.user_details.CustomUserDetails
import com.mpcorp.identity.presentation.api.ProfileApi
import com.mpcorp.identity.presentation.mapper.toDto
import com.mpcorp.identity.presentation.request.profile.CreateProfileRequest
import com.mpcorp.identity.presentation.request.profile.UpdateProfileRequest
import com.mpcorp.identity.presentation.response.profile.ProfileResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfileController(
    private val employeeRepository: EmployeeRepository,
    private val createProfileUseCase: CreateProfileUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase,
    private val getProfileUseCase: GetProfileUseCase,
    private val deleteProfileUseCase: DeleteProfileUseCase,
) : ProfileApi {
    override fun create(request: CreateProfileRequest): ProfileResponse {
        val authId = currentAuthId()
        val profile = createProfileUseCase.execute(
            authId = authId,
            command = CreateProfileCommand(
                name = request.name,
                gender = request.gender,
                identityType = request.identityType,
                identityNumber = request.identityNumber,
                identityIssueDate = request.identityIssueDate,
                identityIssuePlace = request.identityIssuePlace,
                email = request.email,
                phone = request.phone,
                emergencyName = request.emergencyName,
                emergencyPhone = request.emergencyPhone,
                emergencyRelationship = request.emergencyRelationship,
                dateOfBirth = request.dateOfBirth,
                health = request.health,
                married = request.married,
                permanentResidence = request.permanentResidence,
                nowResidence = request.nowResidence,
                avatarUrl = request.avatarUrl,
                educationLevel = request.educationLevel,
                major = request.major,
                certificate = request.certificate,
                skillSet = request.skillSet,
                expYears = request.expYears,
            )
        )

        return ProfileResponse(
            status = ErrorCodes.CREATE_SUCCESS,
            message = StatusMessage.SUCCESS,
            data = profile.toDto(),
        )
    }

    override fun update(request: UpdateProfileRequest): ProfileResponse {
        val authId = currentAuthId()
        val profile = updateProfileUseCase.execute(
            authId = authId,
            command = UpdateProfileCommand(
                id = request.id,
                name = request.name,
                gender = request.gender,
                identityType = request.identityType,
                identityNumber = request.identityNumber,
                identityIssueDate = request.identityIssueDate,
                identityIssuePlace = request.identityIssuePlace,
                email = request.email,
                phone = request.phone,
                emergencyName = request.emergencyName,
                emergencyPhone = request.emergencyPhone,
                emergencyRelationship = request.emergencyRelationship,
                dateOfBirth = request.dateOfBirth,
                health = request.health,
                married = request.married,
                permanentResidence = request.permanentResidence,
                nowResidence = request.nowResidence,
                avatarUrl = request.avatarUrl,
                educationLevel = request.educationLevel,
                major = request.major,
                certificate = request.certificate,
                skillSet = request.skillSet,
                expYears = request.expYears,
            )
        )

        return ProfileResponse(
            status = ErrorCodes.UPDATE_SUCCESS,
            message = StatusMessage.SUCCESS,
            data = profile.toDto(),
        )
    }

    override fun get(): ProfileResponse {
        val employeeId = currentEmployeeId()
        val profile = getProfileUseCase.execute(GetProfileRequestCommand(employeeId = employeeId)) ?: throw ProfileNotFoundException()

        return ProfileResponse(
            status = ErrorCodes.SUCCESS,
            message = StatusMessage.SUCCESS,
            data = profile.toDto(),
        )
    }

    override fun delete(): ProfileResponse {
        val employeeId = currentEmployeeId()
        deleteProfileUseCase.execute(DeleteProfileCommand(employeeId = employeeId))

        return ProfileResponse(
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

