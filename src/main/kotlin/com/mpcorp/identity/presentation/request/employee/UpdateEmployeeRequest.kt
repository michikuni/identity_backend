package com.mpcorp.identity.presentation.request.employee

import com.mpcorp.identity.domain.entity.AuthEntity
import com.mpcorp.identity.presentation.request.contract.UpdateContractRequest
import com.mpcorp.identity.presentation.request.payroll.UpdatePayrollRequest
import com.mpcorp.identity.presentation.request.profile.UpdateProfileRequest
import java.sql.Timestamp

data class UpdateEmployeeRequest(
    val id: Long,
    val auth: AuthEntity,
    val department: String,
    val position: String,
    val status: String,
    val workingType: String,
    val isActive: Boolean,
    val manager: UpdateEmployeeRequest?,
    val createdAt: Timestamp,
    val updatedAt: Timestamp,
    val createdBy: String,
    val note: String?,
    val profile: UpdateProfileRequest? = null,
    val contract: UpdateContractRequest? = null,
    val payroll: UpdatePayrollRequest? = null
)

