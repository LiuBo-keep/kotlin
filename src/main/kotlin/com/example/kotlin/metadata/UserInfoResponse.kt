package com.example.kotlin.metadata

import com.example.kotlin.metadata.enums.UserType

/**
 * @author  aidan.liu
 * @since   2025/9/4 16:20
 * @version 1.0
 */
class UserInfoResponse constructor() {

    private var name: String = ""
    private var age: Int = 0
    private var sex: String = ""
    private var address: String = ""
    private var userType: UserType? = null


    public fun setName(name: String) {
        this.name = name
    }

    public fun getName(): String {
        return name
    }

    public fun setAge(age: Int) {
        this.age = age
    }

    public fun getAge(): Int {
        return age
    }

    public fun setSex(sex: String) {
        this.sex = sex
    }

    public fun getSex(): String {
        return sex
    }

    public fun setAddress(address: String) {
        this.address = address
    }

    public fun getAddress(): String {
        return address
    }

    public fun setUserType(userType: UserType) {
        this.userType = userType
    }

    public fun getUserType(): UserType? {
        return userType
    }
}