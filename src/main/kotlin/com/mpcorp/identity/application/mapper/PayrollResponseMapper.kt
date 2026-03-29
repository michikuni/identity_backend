package com.mpcorp.identity.application.mapper

import com.mpcorp.identity.application.dto.payroll.GetPayrollResponseCommand
import com.mpcorp.identity.application.references.IdentifierModel
import com.mpcorp.identity.domain.entity.PayrollEntity

fun PayrollEntity.toGetPayrollResponseCommand(): GetPayrollResponseCommand = GetPayrollResponseCommand(
    id = IdentifierModel(requireNotNull(id) { "payroll id missing" }.toString()),
    employee = employee.toRefModel(),
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
