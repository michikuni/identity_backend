package com.mpcorp.identity.presentation.request.employee

import java.sql.Timestamp
import java.util.UUID

data class CreateEmployeeRequest(
    val department: String,
    val position: String,
    val status: String,
    val workingType: String,
    val isActive: Boolean,
    val managerAuthId: UUID?,
    val createdAt: Timestamp,
    val updatedAt: Timestamp,
    val createdBy: String,
    val note: String?,
)

