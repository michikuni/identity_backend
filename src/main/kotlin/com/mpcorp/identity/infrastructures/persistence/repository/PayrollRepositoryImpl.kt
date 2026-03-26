package com.mpcorp.identity.infrastructures.persistence.repository

import com.mpcorp.identity.domain.entity.PayrollEntity
import com.mpcorp.identity.domain.repository.PayrollRepository
import com.mpcorp.identity.infrastructures.persistence.jpa_repository.PayrollJpaRepository
import com.mpcorp.identity.infrastructures.persistence.mapper.toDomainEntity
import com.mpcorp.identity.infrastructures.persistence.mapper.toPersistentEntity
import org.springframework.stereotype.Service

@Service
class PayrollRepositoryImpl(
    private val payrollJpaRepository: PayrollJpaRepository
) : PayrollRepository {
    override fun createPayrollById(
        payroll: PayrollEntity
    ): PayrollEntity {
        val payrollJpaData = payroll.toPersistentEntity()
        val dataSavePayroll = payrollJpaRepository.save(payrollJpaData)
        return dataSavePayroll.toDomainEntity()
    }

    override fun findPayrollById(userId: Long): PayrollEntity? {
        val payrollJpaData = payrollJpaRepository.findPayrollByEmployeeId(userId) ?: return null
        return payrollJpaData.toDomainEntity()
    }

    override fun updatePayrollById(
        payroll: PayrollEntity
    ): PayrollEntity {
        val existingPayroll = payrollJpaRepository.findPayrollByEmployeeId(payroll.employee.id)
            ?: throw RuntimeException("Payroll not found")
        existingPayroll.apply {
            employee = payroll.employee.toPersistentEntity()
            salaryType = payroll.salaryType
            baseSalary = payroll.baseSalary
            bonusSalary = payroll.bonusSalary
            overTimeRate = payroll.overTimeRate
            totalIncome = payroll.totalIncome
            currency = payroll.currency
            payDay = payroll.payDay
            bankAccountNumber = payroll.bankAccountNumber
            bankAccountName = payroll.bankAccountName
            bankName = payroll.bankName
            bankBranch = payroll.bankBranch
        }

        return payrollJpaRepository.save(existingPayroll).toDomainEntity()
    }

    override fun deletePayrollById(userId: Long) {
        payrollJpaRepository.deletePayrollByEmployeeId(userId)
    }
}