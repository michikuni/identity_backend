package com.mpcorp.identity.application.dto.profile

import com.mpcorp.identity.application.dto.employee.UpdateEmployeeCommand

data class UpdateProfileCommand(
    val id: Long? = null,
    val employee: UpdateEmployeeCommand,
    val name: String,
    val gender: String,
    val identityType: String,
    val identityNumber: String,
    val identityIssueDate: Int,
    val identityIssuePlace: String,
    val email: String,
    val phone: String,
    val emergencyName: String,
    val emergencyPhone: String,
    val emergencyRelationship: String,
    val dateOfBirth: String,
    val health: String,
    val married: String,
    val permanentResidence: String,
    val nowResidence: String,
    val avatarUrl: String?,
    val educationLevel: String,
    val major: String,
    val certificate: List<String>?,
    val skillSet: List<String>,
    val expYears: Int,
)

