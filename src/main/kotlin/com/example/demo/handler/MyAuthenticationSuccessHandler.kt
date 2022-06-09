package com.example.demo.handler

import cn.hutool.json.JSONUtil
import com.example.demo.po.User
import com.example.demo.utils.WebUtils
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * @author     ：ChengShouYi
 * @date       ：2022/6/7 17:44
 * @description : 认证通过了 生成一个jwt

 */
class MyAuthenticationSuccessHandler : AuthenticationSuccessHandler {
    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationSuccess(
        httpServletRequest: HttpServletRequest,
        httpServletResponse: HttpServletResponse,
        authentication: Authentication
    ) {

        val user: User = authentication.principal as User
        val userJson = JSONUtil.toJsonPrettyStr(user)

        WebUtils.renderString(httpServletResponse, userJson)

        println("登陆成功")
    }
}