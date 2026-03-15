package com.mpcorp.identity.entity

import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "employee")
class EmployeeEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var department: String,

    @Column(nullable = false)
    var position: String,

    @Column(nullable = false)
    var status: String,

    @Column(name = "working_type", nullable = false)
    var workingType: String,

    @Column(name = "is_active", nullable = false)
    var isActive: Boolean,

    @ManyToOne
    @JoinColumn(name = "manager_id")
    var manager: EmployeeEntity?,

    @Column(name = "created_at", nullable = false)
    var createdAt: Instant,

    @Column(name = "updated_at", nullable = false)
    var updatedAt: Instant,

    @Column(name = "created_by", nullable = false)
    var createdBy: String,

    @Column(columnDefinition = "TEXT")
    var note: String?,

    @OneToOne(mappedBy = "employee", cascade = [CascadeType.ALL])
    var profile: ProfileEntity? = null,

    @OneToOne(mappedBy = "employee", cascade = [CascadeType.ALL])
    var contract: ContractEntity? = null,

    @OneToOne(mappedBy = "employee", cascade = [CascadeType.ALL])
    var payroll: PayrollEntity? = null
)