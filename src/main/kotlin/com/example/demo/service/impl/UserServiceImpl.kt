package com.example.demo.service.impl

import com.example.demo.mapper.UserMapper
import com.example.demo.po.User
import com.example.demo.service.UserService
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * @author     ：ChengShouYi
 * @date       ：2022/5/31 16:43
 * @description :TODO
 */
@Service
class UserServiceImpl : UserService {


    @Resource
    private lateinit var userMapper: UserMapper

    override fun queryUserById(id: String): User? {
        return userMapper.queryUserById(id)
    }

    override fun queryUserByIdAndPassword(userId: String, userPassword: String): User? {
        return userMapper.queryUserByIdAndPassword(userId, userPassword)
    }

    override fun addUser(user: User) {
        userMapper.addUser(user)
    }

    /**
     * 规定 前端传过来的值 username password 必须不为空
     */
    override fun validate(loginUser: User): User? {
        val user: User =
            queryUserByIdAndPassword(loginUser.userId, loginUser.userPassword) ?: throw RuntimeException("用户不存在！")
        return user
    }

}
