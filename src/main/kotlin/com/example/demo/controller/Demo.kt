package com.example.demo.controller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author     ：Line
 * @date       ： 2022/6/5 18:58
 * @description :TODO
 */
@RestController
@RequestMapping("/demo")
class Demo {

    @PreAuthorize(value = "hasAuthority('ROLE_USER')")
    @GetMapping("/user")
    fun demo1( ): String {
        println("进来了   普通人 ######### ############################################")
        return "验证成功"
    }

    @PreAuthorize(value = "hasAuthority('ROLE_VIP')")
    @GetMapping("/vip")
    fun demo2( ): String {
        println("进来了  vip   ##########      #############################################")
        return "验证成功"
    }

    @PreAuthorize(value = "hasAuthority('ROLE_MANAGER')")
    @GetMapping("/manager")
    fun demo3( ): String {
        println("进来了    manager  ##########      #############################################")
        return "验证成功"
    }

}