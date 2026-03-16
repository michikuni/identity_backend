package com.mpcorp.identity.service

import com.mpcorp.identity.infrastructures.persistence.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService (
    private val employeeRepository: EmployeeRepository
){
    fun createEmployee()
}