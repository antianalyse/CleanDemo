//package com.example.demo.utils
//
///**
// * @author     ：ChengShouYi
// * @date       ：2022/6/1 9:09
// * @description :TODO
// */
//class ResultInfo(
//    val code: Int,
//    val message: String,
//    var data: Any?
//    ) {
//
//    companion object {
//        fun success(data: Any? = null, message: String = "success"): ResultInfo {
//            return ResultInfo(200, message, data)
//        }
//
//        fun error(data: Any? = null, message: String = "error", code: Int = 500): ResultInfo {
//            return ResultInfo(code, message, data)
//        }
//
//        fun tryit(op: () -> Any?): ResultInfo {
//            return try {
//                success(op.invoke())
//            } catch (e: Exception) {
//                error(message = e.message ?: "")
//            }
//        }
//    }
//}
