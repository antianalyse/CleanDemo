package com.example.demo.handler

import com.example.demo.utils.WebUtils
import org.springframework.http.HttpStatus
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author     ：Line
 * @date       ： 2022/6/5 17:33
 * @description :TODO
 */
@Component
class AuthenticationEntryPointImpl : AuthenticationEntryPoint {
    @Throws(IOException::class, ServletException::class)
    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException?
    ) {
        val result = "用户认证失败请重新登录"
        //处理异常
        WebUtils.renderString(response, result)
    }
}