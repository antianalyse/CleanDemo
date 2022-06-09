package com.example.demo.service.impl

import com.example.demo.service.OpenApiService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

/**
 * @author     ：ChengShouYi
 * @date       ：2022/5/31 16:43
 * @description :TODO
 */
@Service
class OpenApiServiceImpl : OpenApiService {

    //如果是匿名身份，返回false
    override fun checkLoginStatus(): Boolean {
        return !SecurityContextHolder.getContext().authentication.principal.equals("anonymousUser")
    }

}
