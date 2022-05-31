package com.example.demo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author     ：ChengShouYi
 * @date       ： 2022/5/31 9:39
 * @description :TODO
 */


@RestController
class TestController {
//
//    @Autowired
//    lateinit var userService :UserService

    @GetMapping("/hello")
    fun test():String{
        return "hello kotlin web!"
    }
}