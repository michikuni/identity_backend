package com.mpcorp.identity.application.usecase.profile

import com.mpcorp.identity.application.dto.profile.UpdateProfileCommand
import com.mpcorp.identity.application.mapper.toDomainEntity
import com.mpcorp.identity.common.exception.EmployeeNotFoundException
import com.mpcorp.identity.domain.entity.ProfileEntity
import com.mpcorp.identity.domain.repository.EmployeeRepository
import com.mpcorp.identity.domain.repository.ProfileRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UpdateProfileUseCase(
    private val profileRepository: ProfileRepository,
) {
    fun execute(command: UpdateProfileCommand): ProfileEntity {
        val profileEntity = command.toDomainEntity()
        return profileRepository.updateProfileById(profileEntity)
    }
}

