package com.mpcorp.identity.application.mapper

import com.mpcorp.identity.application.dto.profile.GetProfileResponseCommand
import com.mpcorp.identity.application.references.IdentifierModel
import com.mpcorp.identity.domain.entity.ProfileEntity

fun ProfileEntity.toGetProfileResponseCommand(): GetProfileResponseCommand = GetProfileResponseCommand(
    id = IdentifierModel(requireNotNull(id) { "profile id missing" }.toString()),
    employee = employee.toRefModel(),
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
