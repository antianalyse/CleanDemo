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
import java.util.*
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

    override fun queryUserById(id: String): User? {
        return userMapper.queryUserByUserName(id)
    }

//    override fun queryUserByIdAndPassword(userId: String, userPassword: String): User? {
//        return userMapper.queryUserByIdAndPassword(userId, userPassword)
//    }

    override fun addUser(user: User) {
        userMapper.addUser(user)
    }

    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    override fun login(user: User): String {

        //AuthenticationManager authenticate进行用户认证
        val authenticationToken = UsernamePasswordAuthenticationToken(user.userName, user.userPassword)

        println("asdasdddddddddddddd")

        val authenticate: Authentication = authenticationManager.authenticate(authenticationToken)

        //如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate)) {

            println("sadasd")

            throw RuntimeException("登录失败")
        }

        println("@@@@@@@@@@@@@@@@")

        //如果认证通过了， 生成一个jwt  返回
        val loginUser: User = authenticate.principal as User


        println(loginUser.authorities + "###################################################")

        //密码处理一下

        val token = JWT.create()
            .setPayload("token", loginUser)
            .setKey("JWT_SECRET".toByteArray()).sign()


        println(token + "###################################################")


        return token
    }

//    override fun logout(): String {
//        //获取SecurityContextHolder中的用户id
//        val authentication = SecurityContextHolder.getContext().authentication as UsernamePasswordAuthenticationToken
//        val loginUser: LoginUserDetails = authentication.principal as LoginUserDetails
//        val userid: Long = loginUser.getUser().getId()
//        //删除redis中的值
//        redisCache.deleteObject("login:$userid")
//        return ResponseResult(200, "注销成功")
//    }

//    /**
//     * 规定 前端传过来的值 username password 必须不为空
//     */
//    override fun validate(loginUser: User): User? {
//        val user: User =
//            queryUserByIdAndPassword(loginUser.userId, loginUser.userPassword) ?: throw RuntimeException("用户不存在！")
//        return user
//    }

}
