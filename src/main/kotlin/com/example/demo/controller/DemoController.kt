package com.example.demo.controller

import com.example.demo.po.UserView
import com.example.demo.utils.Result
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
class DemoController {


    @PreAuthorize(value = "hasAuthority('ROLE_USER')")
    @GetMapping("/userList")
    fun demo1(): Result {

        val list: ArrayList<UserView> = ArrayList()
        list.add(UserView(1, "程111"))
        list.add(UserView(5, "程555"))
        list.add(UserView(11, "程232"))
        list.add(UserView(15, "程888"))

        return Result("这是来自服务器的 普通用户 资源", list)
    }

    @PreAuthorize(value = "hasAuthority('ROLE_VIP')")
    @GetMapping("/vip")
    fun demo2(): Result {
        return Result("这是来自服务器的 VIP 资源", null)

    }

    @PreAuthorize(value = "hasAuthority('ROLE_MANAGER')")
    @GetMapping("/manager")
    fun demo3(): Result {
        return Result("这是来自服务器的 管理员 资源", null)
    }


}