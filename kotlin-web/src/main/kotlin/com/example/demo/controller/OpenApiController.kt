package com.example.demo.controller

import com.example.demo.service.OpenApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author     ：ChengShouYi
 * @date       ：2022/5/31 9:39
 * @description :开放接口，允许任何人访问
 */
@RestController
@RequestMapping("")
class OpenApiController {

    var loginOrNot = false

    @Autowired
    lateinit var openApiService: OpenApiService

    @GetMapping("/checkLoginStatus")
    fun checkLoginStatus(): Boolean {
        return loginOrNot
    }

    @PostMapping("/login")
    fun login(@RequestBody user: User): Result {
        println(user.name)
        println(user.password)

        if (user.name == "123" && user.password == "456") {
            loginOrNot = true
            return Result("登录成功", null)
        } else return Result("失败", null)
    }

}
