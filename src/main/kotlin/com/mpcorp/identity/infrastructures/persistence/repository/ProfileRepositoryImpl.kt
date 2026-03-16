package com.mpcorp.identity.infrastructures.persistence.repository

import com.mpcorp.identity.domain.entity.ProfileEntity
import com.mpcorp.identity.domain.repository.ProfileRepository

class ProfileRepositoryImpl : ProfileRepository {
    override fun createProfileById(
        userId: Long,
        profile: ProfileEntity
    ): ProfileEntity {
        TODO("Not yet implemented")
    }

    override fun findProfileById(userId: Long): ProfileEntity? {
        TODO("Not yet implemented")
    }

    override fun updateProfileById(
        userId: Long,
        profile: ProfileEntity
    ): ProfileEntity {
        TODO("Not yet implemented")
    }

    override fun deleteProfileById(userId: Long) {
        TODO("Not yet implemented")
    }
}