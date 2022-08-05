package com.example.demo

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun suspendingTest(context: CoroutineContext = EmptyCoroutineContext, block: suspend CoroutineScope.() -> Any): Unit {
    runBlocking(context, block)
    Unit
}

@SpringBootTest
class KotlinTest {

    @Test
    suspend fun tt() = coroutineScope {
        launch {
            delay(1000)
            println("Kotlin Coroutines World!")
        }
        println("Hello")
    }


    @Test
    fun test() {

        println(6696)

    }

}

