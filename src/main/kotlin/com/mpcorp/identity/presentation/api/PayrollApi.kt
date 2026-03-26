package com.mpcorp.identity.presentation.api

import com.mpcorp.identity.presentation.request.payroll.CreatePayrollRequest
import com.mpcorp.identity.presentation.request.payroll.UpdatePayrollRequest
import com.mpcorp.identity.presentation.response.payroll.PayrollResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/payroll")
interface PayrollApi {
    @PostMapping
    fun create(@RequestBody request: CreatePayrollRequest): PayrollResponse

    @PutMapping
    fun update(@RequestBody request: UpdatePayrollRequest): PayrollResponse

    @GetMapping
    fun get(): PayrollResponse

    @DeleteMapping
    fun delete(): PayrollResponse
}

