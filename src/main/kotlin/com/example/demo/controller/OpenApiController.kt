package com.example.demo.controller

import com.example.demo.service.OpenApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author     ：ChengShouYi
 * @date       ：2022/5/31 9:39
 * @description :开放接口，允许任何人访问
 */
@RestController
@RequestMapping("/open")
class OpenApiController {

    @Autowired
    lateinit var openApiService: OpenApiService

    @GetMapping("/checkLoginStatus")
    fun checkLoginStatus(): Boolean {
        return openApiService.checkLoginStatus()
    }

}
