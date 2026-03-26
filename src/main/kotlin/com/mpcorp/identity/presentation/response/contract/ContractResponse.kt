package com.mpcorp.identity.presentation.response.contract

import java.sql.Timestamp

data class ContractDto(
    val id: Long?,
    val typeContract: String,
    val startDate: Timestamp,
    val endDate: Timestamp?,
    val contractExpire: Timestamp?,
    val probationStartDate: Timestamp?,
    val probationEndDate: Timestamp?,
    val taxCode: String,
    val socialInsuranceNumber: String?,
    val healthInsuranceNumber: String?,
)

data class ContractResponse(
    val status: Int,
    val message: String,
    val data: ContractDto?,
)

