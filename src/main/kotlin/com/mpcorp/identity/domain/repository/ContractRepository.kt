package com.mpcorp.identity.domain.repository

import com.mpcorp.identity.domain.entity.ContractEntity

interface ContractRepository {
    fun createContractById(userId: Long, contract: ContractEntity): ContractEntity
    fun findContractById(userId: Long): ContractEntity?
    fun updateContractById(userId: Long, contract: ContractEntity): ContractEntity
    fun deleteContractById(userId: Long)
}