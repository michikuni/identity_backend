package com.mpcorp.identity.presentation.api

import com.mpcorp.identity.presentation.request.contract.CreateContractRequest
import com.mpcorp.identity.presentation.request.contract.UpdateContractRequest
import com.mpcorp.identity.presentation.response.contract.ContractResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/contracts")
interface ContractApi {
    @PostMapping
    fun createContract(@RequestBody request: CreateContractRequest): ContractResponse

    @PutMapping
    fun updateContract(@RequestBody request: UpdateContractRequest): ContractResponse

    @GetMapping
    fun getContract(): ContractResponse

    @DeleteMapping
    fun deleteContract(): ContractResponse
}

