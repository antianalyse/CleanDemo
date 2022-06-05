package com.example.demo.filter

import cn.hutool.json.JSONUtil
import cn.hutool.jwt.JWT
import cn.hutool.jwt.JWTUtil
import com.example.demo.po.User
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
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
 class JwtFilter : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        //获取token
        val token = request.getHeader("token")
        if (token == null) {

            println("没有token")

            //放行
            filterChain.doFilter(request, response)
            return
        }

        //解析token 获取userid
        try {
            val jwt: JWT = JWTUtil.parseToken(token)
            val json = JSONUtil.parseObj(jwt.getPayload("token"))


//            User user = new User(json.getStr("userName"),json.getStr("userPassword"),json.getStr("nickname"),json.getStr("role"))

            val  user = User(
                json.getStr("userName"),
                json.getStr("userPassword"),
                json.getStr("nickname"),
                json.getStr("role")
            )

//            val user = JSONUtil.toBean(jwt.getPayload("token").toString(), User::class.java)

            //获取权限信息封装到Authentication中
            val authenticationToken =
                UsernamePasswordAuthenticationToken(
                    user, null, user.authorities
                )

            SecurityContextHolder.getContext().authentication = authenticationToken

            //放行
            filterChain.doFilter(request, response)

        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("token非法")
        }
    }
}
