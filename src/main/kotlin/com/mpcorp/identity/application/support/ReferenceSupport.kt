package com.mpcorp.identity.application.support

import com.mpcorp.identity.application.references.EmployeeRefModel
import com.mpcorp.identity.application.references.IdentifierModel
import com.mpcorp.identity.common.exception.EmployeeNotFoundException
import com.mpcorp.identity.domain.entity.EmployeeEntity
import com.mpcorp.identity.domain.repository.EmployeeRepository
import java.util.UUID

fun IdentifierModel.toLongValue(): Long = value.toLong()

fun IdentifierModel.toUuidValue(): UUID = UUID.fromString(value)

fun EmployeeRefModel.requireEmployeeId(): Long =
    id?.toLongValue() ?: throw EmployeeNotFoundException()

fun EmployeeRefModel.resolveEmployee(employeeRepository: EmployeeRepository): EmployeeEntity {
    val employee = when {
        id != null -> employeeRepository.findEmployeeById(id.toLongValue())
        authId != null -> employeeRepository.findEmployeeByAuthId(authId.toUuidValue())
        else -> null
    }

    return employee ?: throw EmployeeNotFoundException()
}
