package com.mpcorp.identity.common.exception

import com.mpcorp.identity.common.constant.ErrorMessage
import com.mpcorp.identity.common.constant.StatusMessage
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
            message = ex.message ?: ErrorMessage.USER_NOT_FOUND,
            code = HttpStatus.NOT_FOUND.value(),
            status = StatusMessage.FAILURE,
            data = HttpStatus.NOT_FOUND.reasonPhrase,
        )
    }

    @ExceptionHandler(InvalidPasswordException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleInvalidPassword(
        ex: InvalidPasswordException
    ): ErrorResponse {

        return ErrorResponse(
            message = ex.message ?: ErrorMessage.INVALID_PASSWORD,
            code = HttpStatus.UNAUTHORIZED.value(),
            status = StatusMessage.FAILURE,
            data = HttpStatus.UNAUTHORIZED.reasonPhrase,
        )
    }

    @ExceptionHandler(EmployeeNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleEmployeeNotFound(ex: EmployeeNotFoundException): ErrorResponse {
        return ErrorResponse(
            message = ex.message ?: ErrorMessage.EMPLOYEE_NOT_FOUND,
            code = HttpStatus.NOT_FOUND.value(),
            status = StatusMessage.FAILURE,
            data = HttpStatus.NOT_FOUND.reasonPhrase,
        )
    }

    @ExceptionHandler(ContractNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleContractNotFound(ex: ContractNotFoundException): ErrorResponse {
        return ErrorResponse(
            message = ex.message ?: ErrorMessage.CONTRACT_NOT_FOUND,
            code = HttpStatus.NOT_FOUND.value(),
            status = StatusMessage.FAILURE,
            data = HttpStatus.NOT_FOUND.reasonPhrase,
        )
    }

    @ExceptionHandler(ProfileNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleProfileNotFound(ex: ProfileNotFoundException): ErrorResponse {
        return ErrorResponse(
            message = ex.message ?: ErrorMessage.PROFILE_NOT_FOUND,
            code = HttpStatus.NOT_FOUND.value(),
            status = StatusMessage.FAILURE,
            data = HttpStatus.NOT_FOUND.reasonPhrase,
        )
    }

    @ExceptionHandler(PayrollNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handlePayrollNotFound(ex: PayrollNotFoundException): ErrorResponse {
        return ErrorResponse(
            message = ex.message ?: ErrorMessage.PAYROLL_NOT_FOUND,
            code = HttpStatus.NOT_FOUND.value(),
            status = StatusMessage.FAILURE,
            data = HttpStatus.NOT_FOUND.reasonPhrase,
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(ex: Exception): ErrorResponse {

        return ErrorResponse(
            message = ErrorMessage.SERVER_ERROR,
            code = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            status = StatusMessage.FAILURE,
            data = HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase,
        )
    }
}