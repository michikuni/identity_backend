package com.mpcorp.identity.application.mapper

import com.mpcorp.identity.application.dto.payroll.CreatePayrollCommand
import com.mpcorp.identity.application.dto.payroll.GetPayrollResponseCommand
import com.mpcorp.identity.application.dto.payroll.UpdatePayrollCommand
import com.mpcorp.identity.domain.entity.PayrollEntity

fun CreatePayrollCommand.toDomainEntity(): PayrollEntity {
    return PayrollEntity(
        employee = employee.toDomainEntity(),
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
}

fun UpdatePayrollCommand.toDomainEntity(): PayrollEntity {
    return PayrollEntity(
        id = id,
        employee = employee.toDomainEntity(),
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
}

fun GetPayrollResponseCommand.toDomainEntity(): PayrollEntity {
    return PayrollEntity(
        id = id,
        employee = employee.toDomainEntity(),
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
}