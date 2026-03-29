package com.mpcorp.identity.application.mapper

import com.mpcorp.identity.application.dto.contract.CreateContractCommand
import com.mpcorp.identity.application.dto.contract.GetContractResponseCommand
import com.mpcorp.identity.application.dto.contract.UpdateContractCommand
import com.mpcorp.identity.application.references.ContractRefModel
import com.mpcorp.identity.application.references.IdentifierModel
import com.mpcorp.identity.application.support.toLongValue
import com.mpcorp.identity.domain.entity.ContractEntity
import com.mpcorp.identity.domain.entity.EmployeeEntity

fun CreateContractCommand.toDomainEntity(employee: EmployeeEntity): ContractEntity = ContractEntity(
    employee = employee,
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

fun UpdateContractCommand.toDomainEntity(employee: EmployeeEntity): ContractEntity = ContractEntity(
    id = contract.id.toLongValue(),
    employee = employee,
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

fun ContractEntity.toRefModel(): ContractRefModel = ContractRefModel(
    id = IdentifierModel(requireNotNull(id).toString()),
)

fun ContractEntity.toResponseCommand(): GetContractResponseCommand = GetContractResponseCommand(
    id = IdentifierModel(requireNotNull(id).toString()),
    employee = employee.toRefModel(),
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
