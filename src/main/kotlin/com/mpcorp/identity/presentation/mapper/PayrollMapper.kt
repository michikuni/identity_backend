package com.mpcorp.identity.presentation.mapper

import com.mpcorp.identity.domain.entity.PayrollEntity
import com.mpcorp.identity.presentation.response.payroll.PayrollDto

fun PayrollEntity.toDto(): PayrollDto = PayrollDto(
    id = id,
    salaryType = salaryType,
    baseSalary = baseSalary,
    bonusSalary = bonusSalary,
    overTimeRate = overTimeRate,
    totalIncome = totalIncome,
    currency = currency,
    payDay = payDay,
    bankAccountNumber = bankAccountNumber,
    bankAccountName = bankAccountName,
    bankName = bankName,
    bankBranch = bankBranch,
)