package com.mpcorp.identity.infrastructures.persistence.mapper

import com.mpcorp.identity.domain.entity.EmployeeEntity
import com.mpcorp.identity.infrastructures.persistence.jpa_entity.EmployeeJpaEntity

fun EmployeeJpaEntity.toDomainEntity() : EmployeeEntity {
    return EmployeeEntity(
        id = id,
        status = status,
        auth = auth.toDomainEntity(),
        note = note,
        contract = contract?.toDomainEntity(),
        isActive = isActive,
        position = position,
        department = department,
        manager = manager?.toDomainEntity(),
        payroll = payroll?.toDomainEntity(),
        createdBy = createdBy,
        profile = profile?.toDomainEntity(),
        createdAt = createdAt,
        updatedAt = updatedAt,
        workingType = workingType,
    )
}

fun EmployeeEntity.toPersistentEntity() : EmployeeJpaEntity {
    return EmployeeJpaEntity(
        status = status,
        auth = auth.toPersistentEntity(),
        note = note,
        contract = contract?.toPersistentEntity(),
        isActive = isActive,
        position = position,
        department = department,
        manager = manager?.toPersistentEntity(),
        payroll = payroll?.toPersistentEntity(),
        createdBy = createdBy,
        profile = profile?.toPersistentEntity(),
        createdAt = createdAt,
        updatedAt = updatedAt,
        workingType = workingType,
    )
}