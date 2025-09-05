package com.example.kotlin.common.exception

import com.example.kotlin.common.enums.ResponseCode

/**
 * @author  aidan.liu
 * @since   2025/9/5 16:52
 * @version 1.0
 */
class AuthException constructor(val code: ResponseCode, val msg: String) : Exception() {
}