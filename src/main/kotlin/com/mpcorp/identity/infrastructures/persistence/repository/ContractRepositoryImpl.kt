package com.mpcorp.identity.infrastructures.persistence.repository

import com.mpcorp.identity.domain.entity.ContractEntity
import com.mpcorp.identity.domain.repository.ContractRepository
import com.mpcorp.identity.infrastructures.persistence.jpa_repository.ContractJpaRepository
import com.mpcorp.identity.infrastructures.persistence.mapper.toDomainEntity
import com.mpcorp.identity.infrastructures.persistence.mapper.toPersistentEntity
import org.springframework.stereotype.Service

@Service
class ContractRepositoryImpl (
    private val contractJpaRepository: ContractJpaRepository
) : ContractRepository {
    override fun createContract(contract: ContractEntity): ContractEntity {
        val contractJpaData = contract.toPersistentEntity()
        val dataSaveContract = contractJpaRepository.save(contractJpaData)
        return dataSaveContract.toDomainEntity()
    }

    override fun findContractByEmployeeId(userId: Long): ContractEntity? {
        val contractJpaData = contractJpaRepository.findContractByEmployeeId(userId) ?: return null
        return contractJpaData.toDomainEntity()
    }

    override fun updateContract(contract: ContractEntity): ContractEntity {
        val employeeId = contract.employee.id ?: throw RuntimeException("employee id is null")
        val existingContract = contractJpaRepository.findContractByEmployeeId(employeeId) ?: throw RuntimeException("Contract not found")
        existingContract.apply {
            employee = contract.employee.toPersistentEntity()
            typeContract = contract.typeContract
            startDate = contract.startDate
            endDate = contract.endDate
            contractExpire = contract.contractExpire
            probationStartDate = contract.probationStartDate
            probationEndDate = contract.probationEndDate
            taxCode = contract.taxCode
            socialInsuranceNumber = contract.socialInsuranceNumber
            healthInsuranceNumber = contract.healthInsuranceNumber
        }

        return contractJpaRepository.save(existingContract).toDomainEntity()
    }

    override fun deleteContractByEmployeeId(userId: Long) {
        contractJpaRepository.deleteContractByEmployeeId(userId)
    }

}