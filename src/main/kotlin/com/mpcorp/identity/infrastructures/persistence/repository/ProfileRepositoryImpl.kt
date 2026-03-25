package com.mpcorp.identity.infrastructures.persistence.repository

import com.mpcorp.identity.domain.entity.ProfileEntity
import com.mpcorp.identity.domain.repository.ProfileRepository
import com.mpcorp.identity.infrastructures.persistence.jpa_repository.ProfileJpaRepository
import com.mpcorp.identity.infrastructures.persistence.mapper.toDomainEntity
import com.mpcorp.identity.infrastructures.persistence.mapper.toPersistentEntity

class ProfileRepositoryImpl(
    private val profileJpaRepository: ProfileJpaRepository
) : ProfileRepository {
    override fun createProfileById(
        profile: ProfileEntity
    ): ProfileEntity {
        val profileJpaData = profile.toPersistentEntity()
        val dataSaveProfile = profileJpaRepository.save(profileJpaData)
        return dataSaveProfile.toDomainEntity()
    }

    override fun findProfileById(userId: Long): ProfileEntity {
        val profileJpaData = profileJpaRepository.findProfileByEmployeeId(userId) ?: throw RuntimeException("Profile not found")
        return profileJpaData.toDomainEntity()
    }

    override fun updateProfileById(
        profile: ProfileEntity
    ): ProfileEntity {
        val existingProfile = profileJpaRepository.findProfileByEmployeeId(profile.employee.id) ?: throw RuntimeException("Profile not found")
        existingProfile.apply {
            employee = profile.employee.toPersistentEntity()
            name = profile.name
            gender = profile.gender
            identityType = profile.identityType
            identityNumber = profile.identityNumber
            identityIssueDate = profile.identityIssueDate
            identityIssuePlace = profile.identityIssuePlace
            email = profile.email
            phone = profile.phone
            emergencyName = profile.emergencyName
            emergencyPhone = profile.emergencyPhone
            dateOfBirth = profile.dateOfBirth
            health = profile.health
            married = profile.married
            permanentResidence = profile.permanentResidence
            nowResidence = profile.nowResidence
            avatarUrl = profile.avatarUrl
            educationLevel = profile.educationLevel
            major = profile.major
            certificate = profile.certificate
            skillSet = profile.skillSet
            expYears = profile.expYears
        }

        return profileJpaRepository.save(existingProfile).toDomainEntity()
    }

    override fun deleteProfileById(userId: Long) {
        profileJpaRepository.deleteProfileByEmployeeId(userId)
    }
}