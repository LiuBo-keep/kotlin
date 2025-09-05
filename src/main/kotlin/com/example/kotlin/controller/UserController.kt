package com.example.kotlin.controller

import com.example.kotlin.metadata.UserInfoResponse
import com.example.kotlin.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * @author  aidan.liu
 * @since   2025/9/4 10:54
 * @version 1.0
 */
@RestController
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getUser(): List<UserInfoResponse> {
        return userService.getUser();
    }

    @GetMapping("/{name}")
    fun getUserByName(@PathVariable name: String): UserInfoResponse? {
        return userService.getUserByName(name);
    }
}