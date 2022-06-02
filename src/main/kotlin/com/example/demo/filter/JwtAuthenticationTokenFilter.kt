package com.example.demo.filter

import cn.hutool.jwt.JWT
import cn.hutool.jwt.JWTUtil
import com.example.demo.domain.LoginUserDetails
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author     ：ChengShouYi
 * @date       ：2022/6/2 10:37
 * @description :TODO
 */
@Component
class JwtAuthenticationTokenFilter : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse?,
        filterChain: FilterChain
    ) {
        //获取token
        val token = request.getHeader("token")
        if (!StringUtils.hasText(token)) {
            //放行
            filterChain.doFilter(request, response)
            return
        }

        val loginUserDetails: LoginUserDetails

        //解析token 获取userid
        try {
            val jwt: JWT = JWTUtil.parseToken(token)
            loginUserDetails = jwt.getPayload() as LoginUserDetails
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("token非法")
        }

        //用不用在这里先查询？
        //获取权限信息封装到Authentication中
        val authenticationToken =
            UsernamePasswordAuthenticationToken(loginUserDetails, null, loginUserDetails.authorities)
        SecurityContextHolder.getContext().authentication = authenticationToken
        //放行
        filterChain.doFilter(request, response)
    }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        TODO("Not yet implemented")
    }

}
