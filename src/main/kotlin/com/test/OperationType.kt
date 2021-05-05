package com.test

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator


enum class OperationType : BinaryOperator<Int>, IntBinaryOperator {
    ADD {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    SUB {
        override fun apply(t: Int, u: Int): Int = t - u
    },

    MUL {
        override fun apply(t: Int, u: Int): Int = t * u
    },

    DIVIDE {
        override fun apply(t: Int, u: Int): Int = t / u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}