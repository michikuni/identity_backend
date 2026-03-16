package com.mpcorp.identity.domain.entity

import java.sql.Timestamp

data class ContractEntity(
    var id: Long? = null,
    var employee: EmployeeEntity,
    var typeContract: String,
    var startDate: Timestamp,
    var endDate: Timestamp?,
    var contractExpire: Timestamp?,
    var probationStartDate: Timestamp?,
    var probationEndDate: Timestamp?,
    var taxCode: String,
    var socialInsuranceNumber: String?,
    var healthInsuranceNumber: String?,
)