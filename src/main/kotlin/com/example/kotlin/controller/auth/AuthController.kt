package com.example.kotlin.controller.auth

import com.example.kotlin.common.response.Response
import com.example.kotlin.metadata.auth.AuthRequest
import com.example.kotlin.service.auth.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author  aidan.liu
 * @since   2025/9/5 16:24
 * @version 1.0
 */
@RestController
@RequestMapping("/auth")
class AuthController constructor(@Autowired private val authService: AuthService) {


    @PostMapping("/token")
    fun auth(@RequestBody authRequest: AuthRequest): Response {
        return Response.ok().entry(authService.auth(authRequest)).build();
    }
}