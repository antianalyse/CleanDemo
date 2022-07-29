package com.example.demo.service.impl

import com.example.demo.service.OpenApiService
import org.springframework.stereotype.Service

/**
 * @author     ：ChengShouYi
 * @date       ：2022/5/31 16:43
 * @description :TODO
 */
@Service
class OpenApiServiceImpl : OpenApiService {
    override fun checkLoginStatus(): Boolean {
        return true
    }

}
