package com.example.demo.controller

import com.example.demo.po.User
import com.example.demo.service.UserService
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
class UserController(val userService: UserService) {

//    @Autowired
//    lateinit var userService: UserService

    @PostMapping("/login")
    fun login(@RequestBody loginUser: User): User? {
        return userService.validate(loginUser)
    }


}
