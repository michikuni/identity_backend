package com.mpcorp.identity.presentation.api

import com.mpcorp.identity.presentation.request.profile.CreateProfileRequest
import com.mpcorp.identity.presentation.request.profile.UpdateProfileRequest
import com.mpcorp.identity.presentation.response.profile.ProfileResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/profile")
interface ProfileApi {
    @PostMapping
    fun create(@RequestBody request: CreateProfileRequest): ProfileResponse

    @PutMapping
    fun update(@RequestBody request: UpdateProfileRequest): ProfileResponse

    @GetMapping
    fun get(): ProfileResponse

    @DeleteMapping
    fun delete(): ProfileResponse
}

