package com.example.demo.handler

import cn.hutool.json.JSONUtil
import com.example.demo.utils.ResponseUtils
import com.example.demo.utils.Result
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
class MyAuthenticationEntryPointImpl : AuthenticationEntryPoint {
    @Throws(IOException::class, ServletException::class)
    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException?
    ) {

        val result=  JSONUtil.toJsonStr(Result( "用户认证失败，请重新登录",null)   )

        ResponseUtils.renderString(response, result)
    }
}