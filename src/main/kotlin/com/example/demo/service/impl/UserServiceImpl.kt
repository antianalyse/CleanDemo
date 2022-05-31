package com.example.demo.service.impl

import com.example.demo.mapper.UserMapper
import com.example.demo.po.User
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author     ：ChengShouYi
 * @date       ： 2022/5/31 16:43
 * @description :TODO
 */
class UserServiceImpl:UserService {

    @Autowired
    lateinit var userMapper: UserMapper

    override fun queryUserById(id: String): User? {
        return userMapper.queryUserById(id)
    }

    override fun addUser(user: User) {
        userMapper.addUser(user)
    }


}