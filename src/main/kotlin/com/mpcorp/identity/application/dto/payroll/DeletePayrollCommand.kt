package com.mpcorp.identity.application.dto.payroll

import com.mpcorp.identity.application.references.EmployeeRefModel

data class DeletePayrollCommand(
    val employee: EmployeeRefModel,
)
