package com.mpcorp.identity.application.mapper

import com.mpcorp.identity.application.dto.profile.CreateProfileCommand
import com.mpcorp.identity.application.dto.profile.GetProfileResponseCommand
import com.mpcorp.identity.application.dto.profile.UpdateProfileCommand
import com.mpcorp.identity.domain.entity.ProfileEntity

fun UpdateProfileCommand.toDomainEntity(): ProfileEntity {
    return ProfileEntity(
        expYears = expYears,
        id = id,
        employee = employee.toDomainEntity(),
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
    )
}

fun GetProfileResponseCommand.toDomainEntity(): ProfileEntity {
    return ProfileEntity(
        expYears = expYears,
        id = id,
        employee = employee.toDomainEntity(),
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
    )
}

fun CreateProfileCommand.toDomainEntity(): ProfileEntity {
    return ProfileEntity(
        expYears = expYears,
        employee = employee.toDomainEntity(),
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
    )
}