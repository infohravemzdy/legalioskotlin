package org.hravemzdy.legalios.service

import com.github.michaelbull.result.*
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.hravemzdy.legalios.interfaces.IBundleProps
import org.hravemzdy.legalios.service.types.Period
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertNull
import kotlin.test.assertTrue

class Service_Legalios_Example_BundleFailure2010Test  : Spek({
    data class TestParams(val title: String, val year: Int, val month: Int)
    data class TestScenario(val title: String, val tests: List<TestParams>)

    val testList = listOf(
        TestScenario("2010", listOf(
            TestParams( "2010-1", 2010, 1),
            TestParams( "2010-2", 2010, 2),
            TestParams( "2010-3", 2010, 3),
            TestParams( "2010-4", 2010, 4),
            TestParams( "2010-5", 2010, 5),
            TestParams( "2010-6", 2010, 6),
            TestParams( "2010-7", 2010, 7),
            TestParams( "2010-8", 2010, 8),
            TestParams( "2010-9", 2010, 9),
            TestParams( "2010-10", 2010, 10),
            TestParams( "2010-11", 2010, 11),
            TestParams( "2010-12", 2010, 12),
        )),
    )
    testList.forEach { tx ->
        describe("year ${tx.title}") {
            tx.tests.forEach { tt ->
                context("period ${tt.title}") {
                    val period = Period.getWithYearMonth(tt.year, tt.month)
                    val service = ServiceLegalios()
                    val result: Result<IBundleProps, HistoryResultError> = service.getBundle(period)

                    val bundle: IBundleProps? = result.get()
                    val error: HistoryResultError? = result.getError()

                    it("GetProps should return error") {
                        assertTrue(error != null)
                    }
                    it("GetProps should return props be nil") {
                        assertNull(bundle)
                    }
                }
            }
        }
    }
})
