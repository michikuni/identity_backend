package com.mpcorp.identity.presentation.response.employee

import com.mpcorp.identity.domain.entity.AuthEntity
import com.mpcorp.identity.presentation.response.contract.ContractResponseData
import com.mpcorp.identity.presentation.response.payroll.PayrollResponseData
import com.mpcorp.identity.presentation.response.profile.ProfileResponseData
import java.sql.Timestamp

data class EmployeeResponseData(
    val id: Long,
    val auth: AuthEntity,
    val department: String,
    val position: String,
    val status: String,
    val workingType: String,
    val isActive: Boolean,
    val manager: EmployeeResponseData?,
    val createdAt: Timestamp,
    val updatedAt: Timestamp,
    val createdBy: String,
    val note: String?,
    val profile: ProfileResponseData? = null,
    val contract: ContractResponseData? = null,
    val payroll: PayrollResponseData? = null
)

data class EmployeeResponse(
    val status: Int,
    val message: String,
    val data: EmployeeResponseData?,
)

