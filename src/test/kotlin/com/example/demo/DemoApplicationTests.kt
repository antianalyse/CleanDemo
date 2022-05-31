package com.example.demo

import com.example.demo.po.User
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoApplicationTests {

//    @Autowired
//      val user: User

    @Test
    fun contextLoads() {

        var u = User("dfs","dd","ddf")
        println(u.userId)


    }

}
