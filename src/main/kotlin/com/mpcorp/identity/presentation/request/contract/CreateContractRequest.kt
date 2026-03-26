package com.mpcorp.identity.presentation.request.contract

import com.mpcorp.identity.presentation.request.employee.UpdateEmployeeRequest
import java.sql.Timestamp

data class CreateContractRequest(
    val employee: UpdateEmployeeRequest,
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

