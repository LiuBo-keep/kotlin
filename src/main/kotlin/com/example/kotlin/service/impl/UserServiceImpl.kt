package com.example.kotlin.service.impl

import com.example.kotlin.metadata.UserInfo
import com.example.kotlin.service.UserService
import org.springframework.stereotype.Service

/**
 * @author  aidan.liu
 * @since   2025/9/4 16:37
 * @version 1.0
 */
@Service
class UserServiceImpl: UserService {



    override fun getUser(): UserInfo {

        TODO("Not yet implemented")
    }

    override fun getUser(name: String): UserInfo {
        TODO("Not yet implemented")
    }
}