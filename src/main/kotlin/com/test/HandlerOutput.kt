package com.test


data class HandlerOutput(
    val argument1: Int,
    val argument2: Int,
    val result: Int,
    var method: String,
    val message: String,
    val statusCode: String
)
