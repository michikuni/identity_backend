package com.mpcorp.identity.domain.repository

import com.mpcorp.identity.domain.entity.ContractEntity

interface ContractRepository {
    fun createContract(contract: ContractEntity): ContractEntity
    fun findContractById(userId: Long): ContractEntity?
    fun updateContractByEmployeeId(employeeId: Long, contract: ContractEntity): ContractEntity
    fun deleteContractById(userId: Long)
}