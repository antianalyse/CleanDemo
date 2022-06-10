package com.example.demo

import com.example.demo.mapper.UserMapper
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.annotation.Resource


@SpringBootTest
class DemoControllerApplicationTests {

    @Resource
    lateinit var mapper: UserMapper

    @Test
    fun contextLoads() {

        // 创建密码加密的对象
        val passwordEncoder = BCryptPasswordEncoder()
        // 密码加密
        val newPassword = passwordEncoder.encode("a123456")

        println(newPassword)

        println(mapper.queryUserByUserName("1111")
        )

    }

}
