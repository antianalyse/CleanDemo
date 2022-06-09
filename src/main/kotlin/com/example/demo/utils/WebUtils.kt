package com.example.demo.utils

import java.io.IOException
import javax.servlet.http.HttpServletResponse

/**
 * @author     ：Line
 * @date       ： 2022/6/5 17:36
 * @description :TODO
 */
object WebUtils {
    fun renderString(response: HttpServletResponse, string: String?){
        try {
            response.status = 200
            response.contentType = "application/json"
            response.characterEncoding = "utf-8"
            response.writer.print(string)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
