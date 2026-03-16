package com.mpcorp.identity.domain.repository

import com.mpcorp.identity.domain.entity.ProfileEntity

interface ProfileRepository {
    fun createProfileById(userId: Long, profile: ProfileEntity): ProfileEntity
    fun findProfileById(userId: Long): ProfileEntity?
    fun updateProfileById(userId: Long, profile: ProfileEntity): ProfileEntity
    fun deleteProfileById(userId: Long)
}