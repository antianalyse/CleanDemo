package com.example.demo.service.impl

import com.example.demo.mapper.UserMapper
import com.example.demo.po.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * @author     ：ChengShouYi
 * @date       ：2022/6/2 10:57
 * @description :TODO
 */
@Service
class UserDetailsServiceImpl : UserDetailsService {

    @Resource
    lateinit var userMapper: UserMapper

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(id: String): User {

        println("加载用户" + id +" %%%" + userMapper.queryUserByUserName(id))

        return userMapper.queryUserByUserName(id)?: throw UsernameNotFoundException("用户名或者密码错误")

    }
}

