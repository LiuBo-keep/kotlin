package com.example.kotlin.common.enums

/**
 * @author  aidan.liu
 * @since   2025/9/5 16:14
 * @version 1.0
 */
enum class AuthType constructor(val desc: String) {
    PASSWORD("密码"),
    REFRESH_TOKEN("刷新令牌"),
    CLIENT_CREDENTIALS("客户端凭证"),
    BASIC("基本认证")
}