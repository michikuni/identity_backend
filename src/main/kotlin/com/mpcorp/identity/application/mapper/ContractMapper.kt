package com.mpcorp.identity.application.mapper

import com.mpcorp.identity.application.dto.contract.CreateContractCommand
import com.mpcorp.identity.application.dto.contract.GetContractResponseCommand
import com.mpcorp.identity.application.dto.contract.UpdateContractCommand
import com.mpcorp.identity.domain.entity.ContractEntity

fun CreateContractCommand.toDomainEntity(): ContractEntity {
    return ContractEntity(
        employee = employee.toDomainEntity(),
        typeContract = typeContract,
        startDate = startDate,
        endDate = endDate,
        contractExpire = contractExpire,
        probationStartDate = probationStartDate,
        probationEndDate = probationEndDate,
        taxCode = taxCode,
        socialInsuranceNumber = socialInsuranceNumber,
        healthInsuranceNumber = healthInsuranceNumber,
    )
}

fun UpdateContractCommand.toDomainEntity(): ContractEntity {
    return ContractEntity(
        id = id,
        employee = employee.toDomainEntity(),
        typeContract = typeContract,
        startDate = startDate,
        endDate = endDate,
        contractExpire = contractExpire,
        probationStartDate = probationStartDate,
        probationEndDate = probationEndDate,
        taxCode = taxCode,
        socialInsuranceNumber = socialInsuranceNumber,
        healthInsuranceNumber = healthInsuranceNumber,
    )
}

fun GetContractResponseCommand.toDomainEntity(): ContractEntity {
    return ContractEntity(
        id = id,
        employee = employee.toDomainEntity(),
        typeContract = typeContract,
        startDate = startDate,
        endDate = endDate,
        contractExpire = contractExpire,
        probationStartDate = probationStartDate,
        probationEndDate = probationEndDate,
        taxCode = taxCode,
        socialInsuranceNumber = socialInsuranceNumber,
        healthInsuranceNumber = healthInsuranceNumber,
    )
}