package com.mpcorp.identity.infrastructures.persistence.repository

import com.mpcorp.identity.domain.entity.PayrollEntity
import com.mpcorp.identity.domain.repository.PayrollRepository

class PayrollRepositoryImpl: PayrollRepository {
    override fun createPayrollById(
        userId: Long,
        payroll: PayrollEntity
    ): PayrollEntity {
        TODO("Not yet implemented")
    }

    override fun findPayrollById(userId: Long): PayrollEntity? {
        TODO("Not yet implemented")
    }

    override fun updatePayrollById(
        userId: Long,
        payroll: PayrollEntity
    ): PayrollEntity {
        TODO("Not yet implemented")
    }

    override fun deletePayrollById(userId: Long) {
        TODO("Not yet implemented")
    }
}