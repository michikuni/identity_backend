package com.mpcorp.identity.repository.user

import com.mpcorp.identity.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID>