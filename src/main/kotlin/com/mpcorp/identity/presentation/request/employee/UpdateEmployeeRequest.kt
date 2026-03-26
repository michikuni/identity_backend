package com.mpcorp.identity.presentation.request.employee

import java.sql.Timestamp

data class UpdateEmployeeRequest(
    val department: String,
    val position: String,
    val status: String,
    val workingType: String,
    val isActive: Boolean,
    val updatedAt: Timestamp,
    val note: String?,
)

