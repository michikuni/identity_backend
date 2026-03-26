package com.mpcorp.identity.presentation.response.employee

import com.mpcorp.identity.common.enums.EmployeeRole
import java.sql.Timestamp
import java.util.UUID

data class AuthDto(
    val id: UUID?,
    val email: String,
    val phone: String,
    val role: EmployeeRole,
)

data class EmployeeDto(
    val id: Long?,
    val auth: AuthDto,
    val department: String,
    val position: String,
    val status: String,
    val workingType: String,
    val isActive: Boolean,
    val managerId: Long?,
    val createdAt: Timestamp,
    val updatedAt: Timestamp,
    val createdBy: String,
    val note: String?,
)

data class EmployeeResponse(
    val status: Int,
    val message: String,
    val data: EmployeeDto?,
)

