package com.example.kotlin.dao

import com.example.kotlin.metadata.UserInfoResponse
import com.example.kotlin.metadata.enums.UserType
import org.springframework.stereotype.Repository

/**
 * @author  aidan.liu
 * @since   2025/9/5 14:56
 * @version 1.0
 */
@Repository
class UserDao {

    private val USER_INFO: Map<String, UserInfoResponse> = mapOf(
            "aidan" to UserInfoResponse().apply {
                setName("aidan")
                setAge(18)
                setSex("男")
                setAddress("中国")
                setUserType(UserType.USER)
            },
            "admin" to UserInfoResponse().apply {
                setName("admin")
                setAge(18)
                setSex("男")
                setAddress("中国")
                setUserType(UserType.ADMIN)
            }
    )

    init {
        println("UserDao init")
    }

    fun getUser(): List<UserInfoResponse> {
        val users = ArrayList<UserInfoResponse>()
        for ((key, value) in USER_INFO) {
            users.add(value);
        }
        return users;
    }

    fun getUserByName(name: String): UserInfoResponse? {
        return USER_INFO[name]
    }
}