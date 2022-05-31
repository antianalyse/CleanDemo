package com.example.demo.service.impl

import com.example.demo.mapper.UserMapper
import com.example.demo.po.User
import javax.annotation.Resource

/**
 * @author     ：ChengShouYi
 * @date       ： 2022/5/31 16:43
 * @description :TODO
 */
class UserServiceImpl {

    @Resource
    var userMapper: UserMapper? = null

    fun queryUserById(id: String?): User? {
        return userMapper.queryUserById(id)
    }


    fun addUser(user: User?) {
        userMapper.addUser(user)
    }


}