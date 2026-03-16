package com.mpcorp.identity.domain.entity

import java.sql.Timestamp

class EmployeeEntity(
    var id: Long? = null,
    var auth: AuthEntity,
    var department: String,
    var position: String,
    var status: String,
    var workingType: String,
    var isActive: Boolean,
    var manager: EmployeeEntity?,
    var createdAt: Timestamp,
    var updatedAt: Timestamp,
    var createdBy: String,
    var note: String?,
    var profile: ProfileEntity? = null,
    var contract: ContractEntity? = null,
    var payroll: PayrollEntity? = null
)