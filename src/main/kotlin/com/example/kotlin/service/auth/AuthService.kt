package com.example.kotlin.service.auth

import com.example.kotlin.metadata.auth.AuthRequest
import com.example.kotlin.metadata.auth.AuthResponse

/**
 * @author  aidan.liu
 * @since   2025/9/5 16:22
 * @version 1.0
 */
interface AuthService {

    fun auth(authRequest: AuthRequest): AuthResponse
}