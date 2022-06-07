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
    lateinit var authenticationManager: AuthenticationManager

    override fun queryUserById(id: String): User? {
        return userMapper.queryUserByUserName(id)
    }

    override fun addUser(user: User) {
        userMapper.addUser(user)
    }


    override fun login(user: User): String {

        //AuthenticationManager authenticate进行用户认证
        val authenticationToken = UsernamePasswordAuthenticationToken(user.username, user.password)

        //验证不通过，直接抛出异常到 异常处理控制器
        val authenticate: Authentication = authenticationManager.authenticate(authenticationToken)


        //认证通过了 生成一个jwt
        var loginUser: User = authenticate.principal as User


        val token = JWT.create()
            .setPayload("token", loginUser)
            .setKey("Line".toByteArray()).sign()

        return token
    }

}
