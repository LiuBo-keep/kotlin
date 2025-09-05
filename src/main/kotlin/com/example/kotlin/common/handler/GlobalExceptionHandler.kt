package com.example.kotlin.common.handler

import com.example.kotlin.common.exception.AuthException
import com.example.kotlin.common.response.Response
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

/**
 * @author  aidan.liu
 * @since   2025/9/5 17:08
 * @version 1.0
 */
@ControllerAdvice
class GlobalExceptionHandler constructor() {

    @ResponseBody
    @ExceptionHandler(AuthException::class)
    fun handleAuthException(e: AuthException): Response {
        return Response.fail().code(e.code).msg(e.msg).build()
    }
}