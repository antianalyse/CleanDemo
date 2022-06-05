package com.example.demo.utils

import java.io.IOException
import javax.servlet.http.HttpServletResponse

/**
 * @author     ：Line
 * @date       ： 2022/6/5 17:36
 * @description :TODO
 */
object WebUtils {
    /**
     * 将字符串渲染到客户端
     *
     * @param response 渲染对象
     * @param string 待渲染的字符串
     * @return null
     */
    fun renderString(response: HttpServletResponse, string: String?): String? {
        try {
            response.status = 200
            response.contentType = "application/json"
            response.characterEncoding = "utf-8"
            response.writer.print(string)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}