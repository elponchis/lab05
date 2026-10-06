package com.example.lab05

import org.junit.Assert.assertEquals
import org.junit.Test

class FourBasicOptTest {
    private val delta = 1e-9

    @Test
    fun add01() {
        val fourOpt = FourBasicOpt()
        assertEquals(110.0, fourOpt.add(100.0, 10.0), delta)
    }

    @Test
    fun add02() {
        val fourOpt = FourBasicOpt()
        assertEquals(90.0, fourOpt.add(100.0, -10.0), delta)
    }

    @Test
    fun subtract01() {
        val fourOpt = FourBasicOpt()
        assertEquals(90.0, fourOpt.subtract(100.0, 10.0), delta)
    }

    @Test
    fun subtract02() {
        val fourOpt = FourBasicOpt()
        assertEquals(110.0, fourOpt.subtract(100.0, -10.0), delta)
    }

    @Test
    fun divide01() {
        val fourOpt = FourBasicOpt()
        assertEquals(10.0, fourOpt.divide(100.0, 10.0), delta)
    }

    @Test
    fun divide02() {
        val fourOpt = FourBasicOpt()
        assertEquals(0.0, fourOpt.divide(100.0, 0.0), delta)
    }

    @Test
    fun multiply01() {
        val fourOpt = FourBasicOpt()
        assertEquals(1000.0, fourOpt.multiply(100.0, 10.0), delta)
    }

    @Test
    fun multiply02() {
        val fourOpt = FourBasicOpt()
        assertEquals(100.0, fourOpt.multiply(100.0, 1.0), delta)
    }
}
