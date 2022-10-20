package com.example.demo.controller

class Result(
    val message: String, val data: Any?
) {}

class User(
    val name: String, val password: String
) {
}

class Product(
    val id: Long,
    val companyName: String,
    val machineCode: String,
    val secretVersion: String,
    val programVersion: String,
    val expirationTime: String,
) {
}

class History(
    val generateTime: String,
    val machineCode: String,
    val activationCode: String,
) {
}
