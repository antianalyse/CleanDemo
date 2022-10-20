package com.example.demo.controller

import com.example.demo.service.OpenApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import kotlin.concurrent.thread
import kotlin.random.Random
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor

/**
 * @author     ：ChengShouYi
 * @date       ：2022/5/31 9:39
 * @description :开放接口，允许任何人访问
 */
@RestController
@RequestMapping("")
class OpenApiController {

    //必须从 0 开始

    var loginOrNot = false
    val list = listOf(
        Product(0, "山东盛科沃信息技术有限公司", "f3a74f2dd933b9dc3d3896185e52a163", "涉密", "检查版", "永久"),
        Product(1, "山东盛科沃信息技术有限公司", "a5fdba953fe56ccd7700b9fdc00c907a", "非涉密", "自查版", "永久"),
        Product(2, "山东盛科沃信息技术有限公司", "495955fdba953fdgdfgddfdc00casdas", "涉密", "检查版", "永久")
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

    val a = History(
        "2020-10-9",
        "f3a74f2dd933b9dc3d3896185e52a163",
        "LoZFFw44xssB90mIedq4fyqf7KT4NmZOJt+7ONWX4494Q2kM6ul+r9Wf9NNXTxMhFjyf0IWvK4aVz8gf0HCGnOI9MqR9jtCVridi/aiyqdg=P/z3Oh1r4H2zcI4\n"
    )

    @GetMapping("/history/{id}")
    fun history(@PathVariable(value = "id") id: String): Result {
        Thread.sleep(1000)
        var bb = ArrayList<History>()
        for (i in 0..Random.nextInt(0, 10)) {
            bb.add(a)
        }
        return Result("登录成功", bb)
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
