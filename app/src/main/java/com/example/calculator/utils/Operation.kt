package com.example.calculator.utils

import androidx.annotation.StringRes
import com.example.calculator.R

sealed class Operation(@StringRes val nameRes: Int) {
    abstract fun apply(a: Double, b: Double): Double

    data object Addition : Operation(R.string.plus) {
        override fun apply(a: Double, b: Double) = a + b
    }

    data object Subtraction : Operation(R.string.minus) {
        override fun apply(a: Double, b: Double) = a - b
    }

    data object Multiplication : Operation(R.string.multiply) {
        override fun apply(a: Double, b: Double) = a * b
    }

    data object Division : Operation(R.string.divide) {
        override fun apply(a: Double, b: Double): Double {
            require(b != 0.0) { "Division by zero" }
            return a / b
        }
    }

    data object Equals : Operation(R.string.equals) {
        override fun apply(a: Double, b: Double): Double {
            throw UnsupportedOperationException("Equals operation doesn't apply on two operands")
        }

        fun apply(a: Double): Double {
            return a
        }
    }
}