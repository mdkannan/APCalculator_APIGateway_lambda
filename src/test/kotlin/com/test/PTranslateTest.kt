package com.test
import kotlin.test.Test
import kotlin.test.assertEquals
class PTranslateTest {
    @Test fun testPirateTranslator() {
        // 2
        val classUnderTest : PTranslate = DefaultPTranslate()

        // 3
        assertEquals("Ahoy!, I am Captain Jack Sparrow", classUnderTest.translate("Hello, I am Captain Jack Sparrow"))
        // 3
        assertEquals("Aye!", classUnderTest.translate("Yes"))
    }
}