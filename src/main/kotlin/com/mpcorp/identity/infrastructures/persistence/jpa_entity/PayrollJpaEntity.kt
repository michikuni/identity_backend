package com.mpcorp.identity.infrastructures.persistence.jpa_entity

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "payroll")
data class PayrollJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @OneToOne
    @JoinColumn(name = "employee_id")
    var employee: EmployeeJpaEntity,

    @Column(name = "salary_type", nullable = false)
    val salaryType: String,

    @Column(name = "base_salary", nullable = false)
    val baseSalary: Double,

    @Column(name = "bonus_amount", nullable = true)
    val bonusSalary: Double?,

    @Column(name = "over_time_rate", nullable = true)
    val overTimeRate: Double?,

    @Column(name = "total_income", nullable = false)
    val totalIncome: Double,

    @Column(name = "currency", nullable = false)
    val currency: String,

    @Column(name = "payday", nullable = false)
    val payDay: Timestamp,

    @Column(name = "bank_account_number", nullable = false)
    val bankAccountNumber: String,

    @Column(name = "bank_account_name", nullable = false)
    val bankAccountName: String,

    @Column(name = "bank_name", nullable = false)
    val bankName: String,

    @Column(name = "bank_branch", nullable = true)
    val bankBranch: String?
)