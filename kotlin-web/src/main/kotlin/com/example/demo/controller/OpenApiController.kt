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
    val list = listOf(
        Product("山东盛科沃信息技术有限公司", "f3a74f2dd933b9dc3d3896185e52a163", "涉密", "检查版", "永久"),
        Product("山东盛科沃信息技术有限公司", "a5fdba953fe56ccd7700b9fdc00c907a", "非涉密", "自查版", "永久"),
        Product("山东盛科沃信息技术有限公司", "495955fdba953fdgdfgddfdc00casdas", "涉密", "检查版", "永久")
    )

    @Autowired
    lateinit var openApiService: OpenApiService

    @GetMapping("/checkLoginStatus")
    fun checkLoginStatus(): Boolean {
        return loginOrNot
    }

    @GetMapping("/list")
    fun list(): Result {
        return Result("登录成功", list)
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
