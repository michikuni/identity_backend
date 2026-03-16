package com.mpcorp.identity.infrastructures.persistence.jpa_repository

import com.mpcorp.identity.infrastructures.persistence.jpa_entity.PayrollJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PayrollJpaRepository : JpaRepository<PayrollJpaEntity, Long>