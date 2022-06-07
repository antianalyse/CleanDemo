package com.example.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


/**
 * @author     ：ChengShouYi
 * @date       ：2022/6/7 16:57
 * @description :TODO
 */
@RestController
class LoginController {

    @GetMapping("/login/{status}")
    fun login(@PathVariable status: String): String? {
        println(status)
        if ("auth" == status) {
            return "没有登录"
        }
        if ("fail" == status) {
            return "登录失败"
        }
        if ("success" == status) {
            return "登录成功"
        }
        return if ("logout" == status) {
            "注销成功"
        } else ""
    }

}