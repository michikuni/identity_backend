package com.mpcorp.identity.application.dto.payroll

import com.mpcorp.identity.application.dto.employee.UpdateEmployeeCommand
import java.sql.Timestamp

data class UpdatePayrollCommand(
    val id: Long,
    val employee: UpdateEmployeeCommand,
    val salaryType: String,
    val baseSalary: Double,
    val bonusSalary: Double?,
    val overTimeRate: Double?,
    val totalIncome: Double,
    val currency: String,
    val payDay: Timestamp,
    val bankAccountNumber: String,
    val bankAccountName: String,
    val bankName: String,
    val bankBranch: String?,
)

