package com.mpcorp.identity.presentation.mapper

import com.mpcorp.identity.domain.entity.EmployeeEntity
import com.mpcorp.identity.presentation.response.employee.AuthDto
import com.mpcorp.identity.presentation.response.employee.EmployeeDto

fun EmployeeEntity.toDto(): EmployeeDto = EmployeeDto(
    id = id,
    auth = AuthDto(
        id = auth.id,
        email = auth.email,
        phone = auth.phone,
        role = auth.role,
    ),
    department = department,
    position = position,
    status = status,
    workingType = workingType,
    isActive = isActive,
    managerId = manager?.id,
    createdAt = createdAt,
    updatedAt = updatedAt,
    createdBy = createdBy,
    note = note,
)