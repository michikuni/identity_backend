package com.mpcorp.identity.infrastructures.persistence.jpa_repository

import com.mpcorp.identity.infrastructures.persistence.jpa_entity.ContractJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ContractJpaRepository : JpaRepository<ContractJpaEntity, Long>