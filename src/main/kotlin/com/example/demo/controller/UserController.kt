package com.example.demo.controller

import com.example.demo.po.User
import com.example.demo.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author     ：ChengShouYi
 * @date       ： 2022/5/31 9:39
 * @description :TODO
 */
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var loginService: LoginService


    @PostMapping("/login")
    fun login(@RequestBody user: User): String {

        return loginService.login(user)

    }

//    @RequestMapping("/user/logout")
//    fun logout(): String {
//        return userService.logout()
//    }


}
