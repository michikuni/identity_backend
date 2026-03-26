package com.mpcorp.identity.presentation.mapper

import com.mpcorp.identity.domain.entity.ProfileEntity
import com.mpcorp.identity.presentation.response.profile.ProfileDto

fun ProfileEntity.toDto(): ProfileDto = ProfileDto(
    id = id,
    name = name,
    gender = gender,
    identityType = identityType,
    identityNumber = identityNumber,
    identityIssueDate = identityIssueDate,
    identityIssuePlace = identityIssuePlace,
    email = email,
    phone = phone,
    emergencyName = emergencyName,
    emergencyPhone = emergencyPhone,
    emergencyRelationship = emergencyRelationship,
    dateOfBirth = dateOfBirth,
    health = health,
    married = married,
    permanentResidence = permanentResidence,
    nowResidence = nowResidence,
    avatarUrl = avatarUrl,
    educationLevel = educationLevel,
    major = major,
    certificate = certificate,
    skillSet = skillSet,
    expYears = expYears,
)