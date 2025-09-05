package com.example.kotlin.metadata.auth

import com.example.kotlin.common.enums.AuthType

/**
 * @author  aidan.liu
 * @since   2025/9/5 16:12
 * @version 1.0
 */
class AuthRequest constructor() {

    private var grantType: AuthType? = null
    private var username: String? = null
    private var password: String? = null
    private var refreshToken: String? = null

    constructor(grantType: AuthType?, username: String?, password: String?, refreshToken: String?) : this() {
        this.grantType = grantType
        this.username = username
        this.password = password
        this.refreshToken = refreshToken
    }

    fun setGrantType(grantType: AuthType?) {
        this.grantType = grantType
    }

    fun getGrantType(): AuthType? {
        return grantType
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    fun getUsername(): String? {
        return username
    }

    fun setPassword(password: String?) {
        this.password = password
    }

    fun getPassword(): String? {
        return password
    }

    fun setRefreshToken(refreshToken: String?) {
        this.refreshToken = refreshToken
    }

    fun getRefreshToken(): String? {
        return refreshToken
    }
}