package com.mpcorp.identity.application.dto.contract

import com.mpcorp.identity.application.dto.employee.UpdateEmployeeCommand
import java.sql.Timestamp

data class GetContractResponseCommand(
    val id: Long,
    val employee: UpdateEmployeeCommand,
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
