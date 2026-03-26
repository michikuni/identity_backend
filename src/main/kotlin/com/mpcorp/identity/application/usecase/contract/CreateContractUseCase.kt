package com.mpcorp.identity.application.usecase.contract

import com.mpcorp.identity.application.dto.contract.CreateContractCommand
import com.mpcorp.identity.application.mapper.toDomainEntity
import com.mpcorp.identity.domain.entity.ContractEntity
import com.mpcorp.identity.domain.repository.ContractRepository
import org.springframework.stereotype.Service

@Service
class CreateContractUseCase(
    private val contractRepository: ContractRepository,
) {
    fun execute(createContractCommand: CreateContractCommand): ContractEntity {
        val contractEntity = createContractCommand.toDomainEntity()
        return contractRepository.createContract(contractEntity)
    }
}