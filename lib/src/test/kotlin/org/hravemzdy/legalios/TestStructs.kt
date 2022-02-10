package org.hravemzdy.legalios

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import org.hravemzdy.legalios.interfaces.IBundleProps
import org.hravemzdy.legalios.interfaces.IProps
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.spekframework.spek2.style.specification.Suite
import java.math.BigDecimal
import kotlin.math.roundToInt
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

data class TestYearsScenario(val minYear: Int, val maxYear: Int)
data class TestYearExpParams(val title: String, val year: Int, val month: Int, val expected: Int)
data class TestYearExpScenario(val title: String, val tests: List<TestYearExpParams>)
data class TestPeriodParams(val title: String, val year: Int, val month: Int)
data class TestPeriodScenario(val title: String, val tests: List<TestPeriodParams>)

data class TestIntParams(val title: String, val year: Int, val month: Int, val expYear: Int, val expMonth: Int, val expected: Int) {
    fun testBasicResult(test: Suite, result: Result<IBundleProps, HistoryResultError>, bundle: IBundleProps?, props: IProps?, error: HistoryResultError?) {
        test.it("GetProps should return error = null") {
            assertTrue(error == null)
        }
        test.it("GetProps should return result = success") {
            assertTrue(result is Ok<IBundleProps>)
        }
        test.it("GetProps should return props not be nil") {
            assertNotNull(bundle == null)
        }
        test.it("GetProps should return getPeriodYear = ${expYear} and getPeriodMonth = ${expMonth}") {
            assertEquals(expYear, bundle?.getPeriodYear())
            assertEquals(expMonth, bundle?.getPeriodMonth())
        }
        test.it("GetProps should return healthProps not to be nil") {
            assertNotNull(props)
        }
    }
}
data class TestIntScenario(val title: String, val tests: List<TestIntParams>)

data class TestDecParams(val title: String, val year: Int, val month: Int, val expYear: Int, val expMonth: Int, val expected: Double) {
    fun testBasicResult(test: Suite, result: Result<IBundleProps, HistoryResultError>, bundle: IBundleProps?, props: IProps?, error: HistoryResultError?) {
        test.it("GetProps should return error = null") {
            assertTrue(error == null)
        }
        test.it("GetProps should return result = success") {
            assertTrue(result is Ok<IBundleProps>)
        }
        test.it("GetProps should return props not be nil") {
            assertNotNull(bundle == null)
        }
        test.it("GetProps should return getPeriodYear = ${expYear} and getPeriodMonth = ${expMonth}") {
            assertEquals(expYear, bundle?.getPeriodYear())
            assertEquals(expMonth, bundle?.getPeriodMonth())
        }
        test.it("GetProps should return healthProps not to be nil") {
            assertNotNull(props)
        }
    }
    fun expectedDec(): BigDecimal {
        val intValue: Int = (expected*100).roundToInt()
        return intValue.toBigDecimal().divide(100.toBigDecimal())
    }
}
data class TestDecScenario(val title: String, val tests: List<TestDecParams>)

