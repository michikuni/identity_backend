package com.mpcorp.identity.controller.user

import com.mpcorp.identity.entity.AuthEntity
import com.mpcorp.identity.service.auth.UserService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getAll(): List<AuthEntity> =
        userService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): AuthEntity =
        userService.getById(id)

    @PostMapping
    fun create(@RequestBody user: AuthEntity): AuthEntity =
        userService.create(user)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @RequestBody user: AuthEntity
    ): AuthEntity = userService.update(id, user)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) =
        userService.delete(id)
}