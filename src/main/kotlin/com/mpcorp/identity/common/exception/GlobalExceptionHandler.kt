package com.mpcorp.identity.common.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleUserNotFound(
        ex: UserNotFoundException
    ): ErrorResponse {

        return ErrorResponse(
            message = ex.message ?: "User not found",
            status = HttpStatus.NOT_FOUND.value(),
        )
    }

    @ExceptionHandler(InvalidPasswordException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleInvalidPassword(
        ex: InvalidPasswordException
    ): ErrorResponse {

        return ErrorResponse(
            message = ex.message ?: "Invalid password",
            status = HttpStatus.UNAUTHORIZED.value(),
        )
    }
}