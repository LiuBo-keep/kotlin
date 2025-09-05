package com.example.kotlin.metadata

/**
 * @author  aidan.liu
 * @since   2025/9/4 16:20
 * @version 1.0
 */
class UserInfo constructor() {

    private var name: String = ""
    private var age: Int = 0
    private var sex: String = ""
    private var address: String = ""

    constructor(name: String, age: Int, sex: String, address: String) : this() {
        this.name = name
        this.age = age
        this.sex = sex
        this.address = address
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getAge(): Int {
        return age
    }

    fun setAge(age: Int) {
        this.age = age
    }

    fun getSex(): String {
        return sex
    }

    fun setSex(sex: String) {
        this.sex = sex
    }

    fun getAddress(): String {
        return address
    }

    fun setAddress(address: String) {
        this.address = address
    }

    override fun hashCode(): Int {
        return name.hashCode() + age + sex.hashCode() + address.hashCode()
    }

    override fun toString(): String {
        return "UserInfo(name='$name', age=$age, sex='$sex', address='$address')"
    }
}