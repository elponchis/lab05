package com.example.lab05

class FourBasicOpt {
    fun add(x: Double, y: Double): Double = x + y

    fun subtract(x: Double, y: Double): Double = x - y

    fun divide(x: Double, y: Double): Double {
        if (y == 0.0) return 0.0
        return x / y
    }

    fun multiply(x: Double, y: Double): Double = x * y
}
