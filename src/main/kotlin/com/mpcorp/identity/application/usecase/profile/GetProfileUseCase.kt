package com.mpcorp.identity.application.usecase.profile

import com.mpcorp.identity.application.dto.profile.GetProfileRequestCommand
import com.mpcorp.identity.domain.entity.ProfileEntity
import com.mpcorp.identity.domain.repository.ProfileRepository
import org.springframework.stereotype.Service

@Service
class GetProfileUseCase(
    private val profileRepository: ProfileRepository,
) {
    fun execute(command: GetProfileRequestCommand): ProfileEntity? {
        return profileRepository.findProfileById(command.employeeId)
    }
}

