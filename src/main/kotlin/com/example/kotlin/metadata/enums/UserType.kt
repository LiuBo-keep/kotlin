package com.example.kotlin.metadata.enums

/**
 * @author  aidan.liu
 * @since   2025/9/5 14:31
 * @version 1.0
 */
enum class UserType(desc: String) {
    USER("普通用户"),
    ADMIN("管理员"),
    SUPER_ADMIN("超级管理员");
}