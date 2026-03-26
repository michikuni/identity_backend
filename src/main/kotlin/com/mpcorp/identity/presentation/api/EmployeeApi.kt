package com.mpcorp.identity.presentation.api

import com.mpcorp.identity.presentation.request.employee.CreateEmployeeRequest
import com.mpcorp.identity.presentation.request.employee.UpdateEmployeeRequest
import com.mpcorp.identity.presentation.response.employee.EmployeeResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/employee")
interface EmployeeApi {
    @PostMapping
    fun create(@RequestBody request: CreateEmployeeRequest): EmployeeResponse

    @GetMapping
    fun get(): EmployeeResponse

    @PutMapping
    fun update(@RequestBody request: UpdateEmployeeRequest): EmployeeResponse

    @DeleteMapping
    fun delete(): EmployeeResponse
}

