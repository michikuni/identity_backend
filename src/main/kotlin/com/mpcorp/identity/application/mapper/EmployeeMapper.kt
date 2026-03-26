package com.mpcorp.identity.application.mapper

import com.mpcorp.identity.application.dto.employee.CreateEmployeeCommand
import com.mpcorp.identity.application.dto.employee.GetEmployeeResponseCommand
import com.mpcorp.identity.application.dto.employee.UpdateEmployeeCommand
import com.mpcorp.identity.domain.entity.EmployeeEntity

fun CreateEmployeeCommand.toDomainEntity(): EmployeeEntity {
    return EmployeeEntity(
        auth = auth,
        department = department,
        position = position,
        status = status,
        workingType = workingType,
        isActive = isActive,
        manager = manager?.toDomainEntity(),
        createdAt = createdAt,
        updatedAt = updatedAt,
        createdBy = createdBy,
        note = note,
        profile = profile?.toDomainEntity(),
        contract = contract?.toDomainEntity(),
        payroll = payroll?.toDomainEntity()
    )
}

fun UpdateEmployeeCommand.toDomainEntity(): EmployeeEntity {
    return EmployeeEntity(
        id = id,
        auth = auth,
        department = department,
        position = position,
        status = status,
        workingType = workingType,
        isActive = isActive,
        manager = manager?.toDomainEntity(),
        createdAt = createdAt,
        updatedAt = updatedAt,
        createdBy = createdBy,
        note = note,
        profile = profile?.toDomainEntity(),
        contract = contract?.toDomainEntity(),
        payroll = payroll?.toDomainEntity()
    )
}

fun GetEmployeeResponseCommand.toDomainEntity(): EmployeeEntity {
    return EmployeeEntity(
        id = id,
        auth = auth,
        department = department,
        position = position,
        status = status,
        workingType = workingType,
        isActive = isActive,
        manager = manager?.toDomainEntity(),
        createdAt = createdAt,
        updatedAt = updatedAt,
        createdBy = createdBy,
        note = note,
        profile = profile?.toDomainEntity(),
        contract = contract?.toDomainEntity(),
        payroll = payroll?.toDomainEntity()
    )
}