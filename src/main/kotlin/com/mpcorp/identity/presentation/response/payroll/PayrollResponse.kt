package com.mpcorp.identity.presentation.response.payroll

import java.sql.Timestamp

data class PayrollDto(
    val id: Long?,
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

data class PayrollResponse(
    val status: Int,
    val message: String,
    val data: PayrollDto?,
)

