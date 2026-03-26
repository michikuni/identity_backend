package com.mpcorp.identity.presentation.mapper

import com.mpcorp.identity.domain.entity.ContractEntity
import com.mpcorp.identity.presentation.response.contract.ContractDto

fun ContractEntity.toDto(): ContractDto = ContractDto(
    id = id,
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