package com.example.demo.service

import com.example.demo.po.User
import org.springframework.stereotype.Service

/**
 * @author     ：ChengShouYi
 * @date       ：2022/5/31 16:42
 * @description :TODO
 */
@Service
interface UserService {
    fun queryUserById(id: String): User?
    fun addUser(user: User)

}