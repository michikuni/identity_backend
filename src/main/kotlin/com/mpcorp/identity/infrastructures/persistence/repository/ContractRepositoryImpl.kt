package com.mpcorp.identity.infrastructures.persistence.repository

import com.mpcorp.identity.domain.entity.ContractEntity
import com.mpcorp.identity.domain.repository.ContractRepository

class ContractRepositoryImpl : ContractRepository {
    override fun createContractById(
        userId: Long,
        contract: ContractEntity
    ): ContractEntity {
        TODO("Not yet implemented")
    }

    override fun findContractById(userId: Long): ContractEntity? {
        TODO("Not yet implemented")
    }

    override fun updateContractById(
        userId: Long,
        contract: ContractEntity
    ): ContractEntity {
        TODO("Not yet implemented")
    }

    override fun deleteContractById(userId: Long) {
        TODO("Not yet implemented")
    }
}