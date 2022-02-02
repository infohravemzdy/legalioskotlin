package org.hravemzdy.legalios.operations

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

class SalaryRounding : Spek({
    data class TestSpecParams(val inputVal: String, val expectVal: String)

    describe("TestFactoryHealth_ForYear2011_2021") {
        listOf(
            TestSpecParams("0", "0"),
        ).forEach { tt ->
            describe("Rounding Value${tt.inputVal}") {
                assertEquals(tt.inputVal, tt.expectVal)
            }
        }
    }
})