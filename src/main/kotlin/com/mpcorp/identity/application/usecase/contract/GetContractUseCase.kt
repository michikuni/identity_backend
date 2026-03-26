package com.mpcorp.identity.application.usecase.contract

import com.mpcorp.identity.application.dto.contract.GetContractResponseCommand
import com.mpcorp.identity.domain.entity.ContractEntity
import com.mpcorp.identity.domain.repository.ContractRepository
import org.springframework.stereotype.Service

@Service
class GetContractUseCase(
    private val contractRepository: ContractRepository,
) {
    fun execute(getContractResponseCommand: GetContractResponseCommand): ContractEntity? {
        return contractRepository.findContractByEmployeeId(getContractResponseCommand.employee.id)
    }
}