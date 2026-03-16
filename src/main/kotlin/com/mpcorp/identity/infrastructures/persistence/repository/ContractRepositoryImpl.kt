package com.mpcorp.identity.infrastructures.persistence.repository

import com.mpcorp.identity.common.exception.UserNotFoundException
import com.mpcorp.identity.domain.entity.ContractEntity
import com.mpcorp.identity.domain.repository.ContractRepository
import com.mpcorp.identity.infrastructures.persistence.jpa_repository.ContractJpaRepository
import com.mpcorp.identity.infrastructures.persistence.jpa_repository.EmployeeJpaRepository
import com.mpcorp.identity.infrastructures.persistence.mapper.toDomainEntity
import com.mpcorp.identity.infrastructures.persistence.mapper.toPersistentEntity
import org.springframework.stereotype.Service

@Service
class ContractRepositoryImpl (
    private val contractJpaRepository: ContractJpaRepository,
    private val employeeJpaRepository: EmployeeJpaRepository
) : ContractRepository {
    override fun createContract(contract: ContractEntity): ContractEntity {
        val contractJpa = contract.toPersistentEntity()
        val contractCreated = contractJpaRepository.save(contractJpa)
        return contractCreated.toDomainEntity()
    }

    override fun findContractById(userId: Long): ContractEntity? {
        val contract = contractJpaRepository.findContractByEmployeeId(userId) ?: return null
        return contract.toDomainEntity()
    }

    override fun updateContractByEmployeeId(employeeId: Long, contract: ContractEntity): ContractEntity {
        val employee = employeeJpaRepository.findById(employeeId).orElseThrow{ RuntimeException("Employee not found") }
        val contractJpa = contract.toPersistentEntity()
        contractJpa.employee = employee
        employee.contract = contractJpa

        val savedEmployee = employeeJpaRepository.save(employee)

        return savedEmployee.contract!!.toDomainEntity()
    }

    override fun deleteContractById(userId: Long) {
        contractJpaRepository.deleteById(userId)
    }

}