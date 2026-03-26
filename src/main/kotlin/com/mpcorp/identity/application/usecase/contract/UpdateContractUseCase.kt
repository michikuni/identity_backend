package com.mpcorp.identity.application.usecase.contract

import com.mpcorp.identity.application.dto.contract.UpdateContractCommand
import com.mpcorp.identity.domain.entity.ContractEntity
import com.mpcorp.identity.application.mapper.toDomainEntity
import com.mpcorp.identity.domain.repository.ContractRepository
import org.springframework.stereotype.Service

@Service
class UpdateContractUseCase (
    private val contractRepository: ContractRepository
) {
    fun execute(updateContractCommand: UpdateContractCommand) : ContractEntity {
        val contractEntity = updateContractCommand.toDomainEntity()
        return contractRepository.updateContract(contractEntity)
    }
}