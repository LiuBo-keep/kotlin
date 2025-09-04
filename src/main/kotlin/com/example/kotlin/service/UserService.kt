package com.example.kotlin.service

import com.example.kotlin.metadata.UserInfo

/**
 * @author  aidan.liu
 * @since   2025/9/4 16:36
 * @version 1.0
 */
interface UserService {

    fun getUser(): UserInfo

    fun getUser(name: String): UserInfo
}