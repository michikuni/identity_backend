package com.mpcorp.identity.application.dto.employee

import com.mpcorp.identity.application.dto.contract.UpdateContractCommand
import com.mpcorp.identity.application.dto.payroll.UpdatePayrollCommand
import com.mpcorp.identity.application.dto.profile.UpdateProfileCommand
import com.mpcorp.identity.domain.entity.AuthEntity
import java.sql.Timestamp

data class UpdateEmployeeCommand(
    val id: Long,
    val auth: AuthEntity,
    val department: String,
    val position: String,
    val status: String,
    val workingType: String,
    val isActive: Boolean,
    val manager: UpdateEmployeeCommand?,
    val createdAt: Timestamp,
    val updatedAt: Timestamp,
    val createdBy: String,
    val note: String?,
    val profile: UpdateProfileCommand? = null,
    val contract: UpdateContractCommand? = null,
    val payroll: UpdatePayrollCommand? = null
)

