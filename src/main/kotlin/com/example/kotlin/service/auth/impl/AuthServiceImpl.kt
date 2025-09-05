package com.example.kotlin.service.auth.impl

import com.example.kotlin.common.enums.ResponseCode
import com.example.kotlin.common.exception.AuthException
import com.example.kotlin.metadata.auth.AuthRequest
import com.example.kotlin.metadata.auth.AuthResponse
import com.example.kotlin.service.auth.AuthService
import org.springframework.stereotype.Service

/**
 * @author  aidan.liu
 * @since   2025/9/5 16:23
 * @version 1.0
 */
@Service
class AuthServiceImpl : AuthService {
    companion object {
        private const val GRANT_TYPE_NULL_ERROR = "grantType is null"
    }

    override fun auth(authRequest: AuthRequest): AuthResponse {
        val grantType = authRequest.getGrantType()
                ?: throw AuthException(ResponseCode.UNAUTHORIZED, GRANT_TYPE_NULL_ERROR);

        return AuthResponse();
    }


    fun getBearerToken(): String {
        return "token"
    }

    fun getBasicToken(): String {
        return "token"
    }

    fun getRefreshToken(): String {
        return "token"
    }

    fun getClientCredentialsToken(): String {
        return "token"
    }
}