package com.example.kotlin.metadata.auth

import com.example.kotlin.common.enums.TokenType

/**
 * @author  aidan.liu
 * @since   2025/9/5 16:17
 * @version 1.0
 */
class AuthResponse constructor() {

    private var tokenType: TokenType? = null
    private var token: String? = null
    private var expiresIn: Long? = null
    private var refreshToken: String? = null
    private var refreshTokenExpiresIn: Long? = null

    fun setTokenType(tokenType: TokenType?) {
        this.tokenType = tokenType
    }

    fun getTokenType(): TokenType? {
        return tokenType
    }

    fun setToken(token: String?) {
        this.token = token
    }

    fun getToken(): String? {
        return token
    }

    fun setExpiresIn(expiresIn: Long?) {
        this.expiresIn = expiresIn
    }

    fun getExpiresIn(): Long? {
        return expiresIn
    }

    fun setRefreshToken(refreshToken: String?) {
        this.refreshToken = refreshToken
    }

    fun getRefreshToken(): String? {
        return refreshToken
    }

    fun setRefreshTokenExpiresIn(refreshTokenExpiresIn: Long?) {
        this.refreshTokenExpiresIn = refreshTokenExpiresIn
    }

    fun getRefreshTokenExpiresIn(): Long? {
        return refreshTokenExpiresIn
    }
}