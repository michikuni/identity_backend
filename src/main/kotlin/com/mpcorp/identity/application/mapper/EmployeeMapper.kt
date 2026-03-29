package com.mpcorp.identity.application.mapper

import com.mpcorp.identity.application.dto.employee.GetEmployeeResponseCommand
import com.mpcorp.identity.application.references.AuthRefModel
import com.mpcorp.identity.application.references.ContractRefModel
import com.mpcorp.identity.application.references.EmployeeRefModel
import com.mpcorp.identity.application.references.IdentifierModel
import com.mpcorp.identity.application.references.PayrollRefModel
import com.mpcorp.identity.application.references.ProfileRefModel
import com.mpcorp.identity.domain.entity.AuthEntity
import com.mpcorp.identity.domain.entity.EmployeeEntity

fun AuthEntity.toAuthRefModel(): AuthRefModel = AuthRefModel(
    id = id,
    email = email,
    phone = phone,
    password = password,
    role = role,
)

fun EmployeeEntity.toRefModel(): EmployeeRefModel = EmployeeRefModel(
    id = id?.let { IdentifierModel(it.toString()) },
    authId = auth.id?.let { IdentifierModel(it.toString()) },
)

fun EmployeeEntity.toGetEmployeeResponseCommand(): GetEmployeeResponseCommand = GetEmployeeResponseCommand(
    id = requireNotNull(id) { "employee id missing" },
    auth = auth.toAuthRefModel(),
    department = department,
    position = position,
    status = status,
    workingType = workingType,
    isActive = isActive,
    manager = manager?.toRefModel(),
    createdAt = createdAt,
    updatedAt = updatedAt,
    createdBy = createdBy,
    note = note,
    profile = profile?.id?.let { ProfileRefModel(IdentifierModel(it.toString())) },
    contract = contract?.id?.let { ContractRefModel(IdentifierModel(it.toString())) },
    payroll = payroll?.id?.let { PayrollRefModel(IdentifierModel(it.toString())) },
)
