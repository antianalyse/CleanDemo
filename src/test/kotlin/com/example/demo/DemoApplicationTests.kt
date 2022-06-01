package com.example.demo

import com.example.demo.mapper.UserMapper
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class DemoApplicationTests {

    @Resource
    lateinit var mapper: UserMapper

    @Test
    fun contextLoads() {

        println(mapper.queryUserById("1111")
        )

    }

}
