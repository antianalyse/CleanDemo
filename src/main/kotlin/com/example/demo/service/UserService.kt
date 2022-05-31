package com.example.demo.service

import com.example.demo.po.User

/**
 * @author     ：ChengShouYi
 * @date       ： 2022/5/31 16:42
 * @description :TODO
 */
interface UserService {

    fun queryUserById(id: String?): User?

    fun addUser(user: User?)

}