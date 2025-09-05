package com.example.kotlin.service

import com.example.kotlin.metadata.UserInfoResponse

/**
 * @author  aidan.liu
 * @since   2025/9/4 16:36
 * @version 1.0
 */
interface UserService {

    fun getUser(): List<UserInfoResponse>

    fun getUserByName(name: String): UserInfoResponse?
}