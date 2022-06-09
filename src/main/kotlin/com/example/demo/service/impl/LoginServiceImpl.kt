package com.example.demo.service.impl

import cn.hutool.jwt.JWT
import com.example.demo.mapper.UserMapper
import com.example.demo.po.User
import com.example.demo.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * @author     ：ChengShouYi
 * @date       ：2022/5/31 16:43
 * @description :TODO
 */
@Service
class LoginServiceImpl : LoginService {


    @Resource
    private lateinit var userMapper: UserMapper

    @Autowired
    lateinit var authentication: Authentication


    override fun checkLogin(): String {



        return token
    }

}
