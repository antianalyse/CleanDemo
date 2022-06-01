package com.example.demo.mapper

import com.example.demo.po.User

/**
 * @author     ：ChengShouYi
 * @date       ：2022/5/31 16:37
 * @description :TODO
 */
interface UserMapper {
    fun queryUserById(id: String): User?
    fun addUser(user: User)

}