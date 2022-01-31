package org.hravemzdy.legalios.service

import com.github.michaelbull.result.*
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.hravemzdy.legalios.interfaces.IBundleProps
import org.hravemzdy.legalios.service.types.Period
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertNull
import kotlin.test.assertTrue

class Service_Legalios_Example_BundleFailure2009Test  : Spek({
    data class TestParams(val title: String, val year: Int, val month: Int)
    data class TestScenario(val title: String, val tests: List<TestParams>)

    val testList = listOf(
        TestScenario("2009", listOf(
            TestParams( "2009-1", 2009, 1),
            TestParams( "2009-2", 2009, 2),
            TestParams( "2009-3", 2009, 3),
            TestParams( "2009-4", 2009, 4),
            TestParams( "2009-5", 2009, 5),
            TestParams( "2009-6", 2009, 6),
            TestParams( "2009-7", 2009, 7),
            TestParams( "2009-8", 2009, 8),
            TestParams( "2009-9", 2009, 9),
            TestParams( "2009-10", 2009, 10),
            TestParams( "2009-11", 2009, 11),
            TestParams( "2009-12", 2009, 12),
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
