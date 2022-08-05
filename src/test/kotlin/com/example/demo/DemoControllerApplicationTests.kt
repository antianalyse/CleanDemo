package com.example.demo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Bean
import java.io.BufferedInputStream
import kotlin.math.cos


@SpringBootTest
class DemoControllerApplicationTests {

    class HTML {
        fun body() {
            println("HTML BODY")
        }
    }

    fun html(init: HTML.() -> Unit): HTML { // HTML.()中的HTML是接受者类型
        val html = HTML()  // 创建接收者对象
        html.init()        // 将该接收者对象传给该 lambda
        return html
    }

    @Test
    fun test() {

        val a = membersOf<String>()

        println(membersOf<String>().joinToString("\n"))

        System.out.println()
    }


    @get:Synchronized
    val a =1

    class aaaa{

        @Synchronized  fun findFixPoint(x: Double = 1.0): Double =

            if (x == cos(x))
                x
            else
                findFixPoint(cos(x))


    }


    private inline fun <reified T> membersOf() = T::class.members

    @Bean
    fun objectMapper(): ObjectMapper {


        synchronized(this){}



        return jacksonObjectMapper()
    }


    // byte转为int
    fun byteToInt(bytes: ByteArray): Int {
        var value = 0
        for (i in 0..3) {
            val shift = (3 - i) * 8
            value += bytes[i].toInt() and 0xFF shl shift
        }
        return value
    }


    /**
     * 取开头的前4位，表示长度，并返回（长度 + 原字节数组）
     *
     * ByteArray 范围是 Int，Int占4字节，将Int类型的 size 转为字节数组（大端序）
     * */
    fun recordSizeAndBack(originArray: ByteArray): ByteArray {
        val size = originArray.size
        val sizeBytes = ByteArray(4)
        sizeBytes[0] = (size shr 24 and 0xFF).toByte()
        sizeBytes[1] = (size shr 16 and 0xFF).toByte()
        sizeBytes[2] = (size shr 8 and 0xFF).toByte()
        sizeBytes[3] = (size and 0xFF).toByte()

        var newArray = ByteArray(4 + size)
        newArray = originArray.copyInto(newArray, destinationOffset = 4)
        newArray = sizeBytes.copyInto(newArray)
        return newArray
    }

    /**
     * 根据开头的长度，读出相应长度的数据
     *
     * @return 读完时，返回 null
     * */
    fun readOne(buffer: BufferedInputStream): ByteArray? {
        var realData: ByteArray? = null
        try {
            buffer.use {
                val sizeArray = IntArray(4)
                repeat(4) {
                    val temp = buffer.read()
                    if (temp == -1) return null
                    else sizeArray[it] = temp
                }
                var size = 0
                for (i in 0..3) {
                    val shift = (3 - i) * 8
                    size += sizeArray[i].toByte().toInt() and 0xFF shl shift
                }
                realData = ByteArray(size)
                buffer.read(realData!!)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            println("")
        }
        return realData
    }


}

