package com.test

import kotlin.properties.Delegates

class HandlerInput() {
    var argument1 by Delegates.notNull<Int>()
    var argument2 by Delegates.notNull<Int>()
    var dataType by Delegates.notNull<String>()
    lateinit var method: OperationType
}