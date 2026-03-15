package com.mpcorp.identity.controller.user

import com.mpcorp.identity.entity.user.User
import com.mpcorp.identity.service.user.UserService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getAll(): List<User> =
        userService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): User =
        userService.getById(id)

    @PostMapping
    fun create(@RequestBody user: User): User =
        userService.create(user)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @RequestBody user: User
    ): User = userService.update(id, user)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID) =
        userService.delete(id)
}