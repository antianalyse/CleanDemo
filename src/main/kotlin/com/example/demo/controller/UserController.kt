package com.example.demo.controller

import com.example.demo.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
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

    @GetMapping("/checkLogin")
    fun checkLogin(): String {
        return loginService.checkLogin()
    }

}
