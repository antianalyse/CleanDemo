package com.example.demo.service.impl

import com.example.demo.domain.LoginUserDetails
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
    override fun loadUserByUsername(id: String): LoginUserDetails {

        //如果没有查询到用户就抛出异常
        val user: User = userMapper.queryUserById(id) ?: throw RuntimeException("用户名或者密码错误")

        //封装成UserDetails
        return LoginUserDetails(user)
    }
}

