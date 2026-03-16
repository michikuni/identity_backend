package com.mpcorp.identity.domain.entity

data class ProfileEntity(
    var id: Long? = null,
    var employee: EmployeeEntity,
    var name: String,
    var gender: String,
    var identityType: String,
    var identityNumber: String,
    var identityIssueDate: Int,
    var identityIssuePlace: String,
    var email: String,
    var phone: String,
    var emergencyName: String,
    var emergencyPhone: String,
    var emergencyRelationship: String,
    var dateOfBirth: String,
    var health: String,
    var married: String,
    var permanentResidence: String,
    var nowResidence: String,
    var avatarUrl: String?,
    var educationLevel: String,
    var major: String,
    var certificate: List<String>? = null,
    var skillSet: List<String> = listOf(),
    var expYears: Int
)