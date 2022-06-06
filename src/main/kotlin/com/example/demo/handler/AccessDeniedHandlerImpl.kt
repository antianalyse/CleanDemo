package com.example.demo.handler

import com.example.demo.utils.WebUtils
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
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
class AccessDeniedHandlerImpl : AccessDeniedHandler {
    @Throws(IOException::class, ServletException::class)
    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: AccessDeniedException?
    ) {
        val result = "您的权限不足"

        WebUtils.renderString(response, result)
    }
}