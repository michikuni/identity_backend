package com.mpcorp.identity.application.usecase.contract

import com.mpcorp.identity.application.dto.contract.DeleteContractCommand
import com.mpcorp.identity.domain.repository.ContractRepository
import org.springframework.stereotype.Service

@Service
class DeleteContractUseCase(
    private val contractRepository: ContractRepository,
) {
    fun execute(deleteContractCommand: DeleteContractCommand) {
        contractRepository.deleteContractByEmployeeId(deleteContractCommand.employeeId)
    }
}