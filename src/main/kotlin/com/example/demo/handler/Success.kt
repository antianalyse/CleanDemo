package com.example.demo.handler

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author     ：ChengShouYi
 * @date       ：2022/6/7 17:44
 * @description :TODO
 */
class Success : AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(p0: HttpServletRequest?, p1: HttpServletResponse?, p2: Authentication?) {

        println("cehgngong" )
    }
}