package com.mpcorp.identity.domain.entity

import com.mpcorp.identity.common.enums.EmployeeRole
import java.util.UUID

data class AuthEntity (
    var id: UUID? = null,
    var email: String,
    var phone: String,
    var password: String?,
    var role: EmployeeRole = EmployeeRole.EMPLOYEE,
)