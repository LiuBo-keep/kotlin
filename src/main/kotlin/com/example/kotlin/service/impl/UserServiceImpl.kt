package com.example.kotlin.service.impl

import com.example.kotlin.dao.UserDao
import com.example.kotlin.metadata.UserInfoResponse
import com.example.kotlin.metadata.enums.UserType
import com.example.kotlin.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author  aidan.liu
 * @since   2025/9/4 16:37
 * @version 1.0
 */
@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userDao: UserDao

    override fun getUser(): List<UserInfoResponse>{
        return userDao.getUser();
    }

    override fun getUserByName(name: String): UserInfoResponse? {
        return userDao.getUserByName( name);
    }
}