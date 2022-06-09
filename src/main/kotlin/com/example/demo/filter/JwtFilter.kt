//package com.example.demo.filter
//
//import cn.hutool.json.JSONUtil
//import cn.hutool.jwt.JWT
//import cn.hutool.jwt.JWTUtil
//import com.example.demo.po.User
//import org.springframework.stereotype.Component
//import org.springframework.web.filter.OncePerRequestFilter
//import java.io.IOException
//import javax.servlet.FilterChain
//import javax.servlet.ServletException
//import javax.servlet.http.HttpServletRequest
//import javax.servlet.http.HttpServletResponse
//
///**
// * asdas
// * @author     ：ChengShouYi
// * @date       ：2022/6/2 10:37
// * @description :TODO
// */
//@Component
//class JwtFilter : OncePerRequestFilter() {
//    @Throws(ServletException::class, IOException::class)
//    override fun doFilterInternal(
//        request: HttpServletRequest,
//        response: HttpServletResponse,
//        filterChain: FilterChain
//    ) {
//        //获取token
//        val token = request.getHeader("token")
//        if (token == null) {
//            println("没有token")
//            filterChain.doFilter(request, response)
//            return
//        }
//
//        try {
//            //解析token 获取userid
//            val jwt: JWT = JWTUtil.parseToken(token)
//            val json = JSONUtil.parseObj(jwt.getPayload("token"))
//
//            val user = User(
//                json.getStr("username"),
//                json.getStr("password"),
//                json.getStr("nickname"),
//                json.getStr("role")
//            )
//
////            //获取权限信息封装到Authentication中
////            val authenticationToken =
////                UsernamePasswordAuthenticationToken(
////                    user, null, user.authorities
////                )
////
////            SecurityContextHolder.getContext().authentication = authenticationToken
//
//
//            //放行
//            filterChain.doFilter(request, response)
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//            throw RuntimeException("token非法")
//        }
//    }
//}
