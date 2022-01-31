package org.hravemzdy.legalios.service

import com.github.michaelbull.result.*
import org.hravemzdy.legalios.TestIntParams
import org.hravemzdy.legalios.TestIntScenario
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.hravemzdy.legalios.interfaces.IBundleProps
import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.service.types.Period
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

class Service_Legalios_Example_01_Health_01_MinMonthlyBasisTest  : Spek({
    val testList = listOf(
        TestIntScenario("2010", listOf(
            TestIntParams( "2010-1", 2010, 1, 2010, 1, 8000 ),
            TestIntParams( "2010-2", 2010, 2, 2010, 2, 8000 ),
            TestIntParams( "2010-3", 2010, 3, 2010, 3, 8000 ),
            TestIntParams( "2010-4", 2010, 4, 2010, 4, 8000 ),
            TestIntParams( "2010-5", 2010, 5, 2010, 5, 8000 ),
            TestIntParams( "2010-6", 2010, 6, 2010, 6, 8000 ),
            TestIntParams( "2010-7", 2010, 7, 2010, 7, 8000 ),
            TestIntParams( "2010-8", 2010, 8, 2010, 8, 8000 ),
            TestIntParams( "2010-9", 2010, 9, 2010, 9, 8000 ),
            TestIntParams( "2010-10", 2010, 10, 2010, 10, 8000 ),
            TestIntParams( "2010-11", 2010, 11, 2010, 11, 8000 ),
            TestIntParams( "2010-12", 2010, 12, 2010, 12, 8000 ),
        )),
        TestIntScenario("2011", listOf(
            TestIntParams( "2011-1", 2011, 1, 2011, 1, 8000 ),
            TestIntParams( "2011-2", 2011, 2, 2011, 2, 8000 ),
            TestIntParams( "2011-3", 2011, 3, 2011, 3, 8000 ),
            TestIntParams( "2011-4", 2011, 4, 2011, 4, 8000 ),
            TestIntParams( "2011-5", 2011, 5, 2011, 5, 8000 ),
            TestIntParams( "2011-6", 2011, 6, 2011, 6, 8000 ),
            TestIntParams( "2011-7", 2011, 7, 2011, 7, 8000 ),
            TestIntParams( "2011-8", 2011, 8, 2011, 8, 8000 ),
            TestIntParams( "2011-9", 2011, 9, 2011, 9, 8000 ),
            TestIntParams( "2011-10", 2011, 10, 2011, 10, 8000 ),
            TestIntParams( "2011-11", 2011, 11, 2011, 11, 8000 ),
            TestIntParams( "2011-12", 2011, 12, 2011, 12, 8000 ),
        )),
        TestIntScenario("2012", listOf(
            TestIntParams( "2012-1", 2012, 1, 2012, 1, 8000 ),
            TestIntParams( "2012-2", 2012, 2, 2012, 2, 8000 ),
            TestIntParams( "2012-3", 2012, 3, 2012, 3, 8000 ),
            TestIntParams( "2012-4", 2012, 4, 2012, 4, 8000 ),
            TestIntParams( "2012-5", 2012, 5, 2012, 5, 8000 ),
            TestIntParams( "2012-6", 2012, 6, 2012, 6, 8000 ),
            TestIntParams( "2012-7", 2012, 7, 2012, 7, 8000 ),
            TestIntParams( "2012-8", 2012, 8, 2012, 8, 8000 ),
            TestIntParams( "2012-9", 2012, 9, 2012, 9, 8000 ),
            TestIntParams( "2012-10", 2012, 10, 2012, 10, 8000 ),
            TestIntParams( "2012-11", 2012, 11, 2012, 11, 8000 ),
            TestIntParams( "2012-12", 2012, 12, 2012, 12, 8000 ),
        )),
        TestIntScenario("2013", listOf(
            TestIntParams( "2013-1", 2013, 1, 2013, 1, 8000 ),
            TestIntParams( "2013-2", 2013, 2, 2013, 2, 8000 ),
            TestIntParams( "2013-3", 2013, 3, 2013, 3, 8000 ),
            TestIntParams( "2013-4", 2013, 4, 2013, 4, 8000 ),
            TestIntParams( "2013-5", 2013, 5, 2013, 5, 8000 ),
            TestIntParams( "2013-6", 2013, 6, 2013, 6, 8000 ),
            TestIntParams( "2013-7", 2013, 7, 2013, 7, 8000 ),
            TestIntParams( "2013-8", 2013, 8, 2013, 8, 8500 ),
            TestIntParams( "2013-9", 2013, 9, 2013, 9, 8500 ),
            TestIntParams( "2013-10", 2013, 10, 2013, 10, 8500 ),
            TestIntParams( "2013-11", 2013, 11, 2013, 11, 8500 ),
            TestIntParams( "2013-12", 2013, 12, 2013, 12, 8500 ),
        )),
        TestIntScenario("2014", listOf(
            TestIntParams( "2014-1", 2014, 1, 2014, 1, 8500 ),
            TestIntParams( "2014-2", 2014, 2, 2014, 2, 8500 ),
            TestIntParams( "2014-3", 2014, 3, 2014, 3, 8500 ),
            TestIntParams( "2014-4", 2014, 4, 2014, 4, 8500 ),
            TestIntParams( "2014-5", 2014, 5, 2014, 5, 8500 ),
            TestIntParams( "2014-6", 2014, 6, 2014, 6, 8500 ),
            TestIntParams( "2014-7", 2014, 7, 2014, 7, 8500 ),
            TestIntParams( "2014-8", 2014, 8, 2014, 8, 8500 ),
            TestIntParams( "2014-9", 2014, 9, 2014, 9, 8500 ),
            TestIntParams( "2014-10", 2014, 10, 2014, 10, 8500 ),
            TestIntParams( "2014-11", 2014, 11, 2014, 11, 8500 ),
            TestIntParams( "2014-12", 2014, 12, 2014, 12, 8500 ),
        )),
        TestIntScenario("2015", listOf(
            TestIntParams( "2015-1", 2015, 1, 2015, 1, 9200 ),
            TestIntParams( "2015-2", 2015, 2, 2015, 2, 9200 ),
            TestIntParams( "2015-3", 2015, 3, 2015, 3, 9200 ),
            TestIntParams( "2015-4", 2015, 4, 2015, 4, 9200 ),
            TestIntParams( "2015-5", 2015, 5, 2015, 5, 9200 ),
            TestIntParams( "2015-6", 2015, 6, 2015, 6, 9200 ),
            TestIntParams( "2015-7", 2015, 7, 2015, 7, 9200 ),
            TestIntParams( "2015-8", 2015, 8, 2015, 8, 9200 ),
            TestIntParams( "2015-9", 2015, 9, 2015, 9, 9200 ),
            TestIntParams( "2015-10", 2015, 10, 2015, 10, 9200 ),
            TestIntParams( "2015-11", 2015, 11, 2015, 11, 9200 ),
            TestIntParams( "2015-12", 2015, 12, 2015, 12, 9200 ),
        )),
        TestIntScenario("2016", listOf(
            TestIntParams( "2016-1", 2016, 1, 2016, 1, 9900 ),
            TestIntParams( "2016-2", 2016, 2, 2016, 2, 9900 ),
            TestIntParams( "2016-3", 2016, 3, 2016, 3, 9900 ),
            TestIntParams( "2016-4", 2016, 4, 2016, 4, 9900 ),
            TestIntParams( "2016-5", 2016, 5, 2016, 5, 9900 ),
            TestIntParams( "2016-6", 2016, 6, 2016, 6, 9900 ),
            TestIntParams( "2016-7", 2016, 7, 2016, 7, 9900 ),
            TestIntParams( "2016-8", 2016, 8, 2016, 8, 9900 ),
            TestIntParams( "2016-9", 2016, 9, 2016, 9, 9900 ),
            TestIntParams( "2016-10", 2016, 10, 2016, 10, 9900 ),
            TestIntParams( "2016-11", 2016, 11, 2016, 11, 9900 ),
            TestIntParams( "2016-12", 2016, 12, 2016, 12, 9900 ),
        )),
        TestIntScenario("2017", listOf(
            TestIntParams( "2017-1", 2017, 1, 2017, 1, 11000 ),
            TestIntParams( "2017-2", 2017, 2, 2017, 2, 11000 ),
            TestIntParams( "2017-3", 2017, 3, 2017, 3, 11000 ),
            TestIntParams( "2017-4", 2017, 4, 2017, 4, 11000 ),
            TestIntParams( "2017-5", 2017, 5, 2017, 5, 11000 ),
            TestIntParams( "2017-6", 2017, 6, 2017, 6, 11000 ),
            TestIntParams( "2017-7", 2017, 7, 2017, 7, 11000 ),
            TestIntParams( "2017-8", 2017, 8, 2017, 8, 11000 ),
            TestIntParams( "2017-9", 2017, 9, 2017, 9, 11000 ),
            TestIntParams( "2017-10", 2017, 10, 2017, 10, 11000 ),
            TestIntParams( "2017-11", 2017, 11, 2017, 11, 11000 ),
            TestIntParams( "2017-12", 2017, 12, 2017, 12, 11000 ),
        )),
        TestIntScenario("2018", listOf(
            TestIntParams( "2018-1", 2018, 1, 2018, 1, 12200 ),
            TestIntParams( "2018-2", 2018, 2, 2018, 2, 12200 ),
            TestIntParams( "2018-3", 2018, 3, 2018, 3, 12200 ),
            TestIntParams( "2018-4", 2018, 4, 2018, 4, 12200 ),
            TestIntParams( "2018-5", 2018, 5, 2018, 5, 12200 ),
            TestIntParams( "2018-6", 2018, 6, 2018, 6, 12200 ),
            TestIntParams( "2018-7", 2018, 7, 2018, 7, 12200 ),
            TestIntParams( "2018-8", 2018, 8, 2018, 8, 12200 ),
            TestIntParams( "2018-9", 2018, 9, 2018, 9, 12200 ),
            TestIntParams( "2018-10", 2018, 10, 2018, 10, 12200 ),
            TestIntParams( "2018-11", 2018, 11, 2018, 11, 12200 ),
            TestIntParams( "2018-12", 2018, 12, 2018, 12, 12200 ),
        )),
        TestIntScenario("2019", listOf(
            TestIntParams( "2019-1", 2019, 1, 2019, 1, 13350 ),
            TestIntParams( "2019-2", 2019, 2, 2019, 2, 13350 ),
            TestIntParams( "2019-3", 2019, 3, 2019, 3, 13350 ),
            TestIntParams( "2019-4", 2019, 4, 2019, 4, 13350 ),
            TestIntParams( "2019-5", 2019, 5, 2019, 5, 13350 ),
            TestIntParams( "2019-6", 2019, 6, 2019, 6, 13350 ),
            TestIntParams( "2019-7", 2019, 7, 2019, 7, 13350 ),
            TestIntParams( "2019-8", 2019, 8, 2019, 8, 13350 ),
            TestIntParams( "2019-9", 2019, 9, 2019, 9, 13350 ),
            TestIntParams( "2019-10", 2019, 10, 2019, 10, 13350 ),
            TestIntParams( "2019-11", 2019, 11, 2019, 11, 13350 ),
            TestIntParams( "2019-12", 2019, 12, 2019, 12, 13350 ),
        )),
        TestIntScenario("2020", listOf(
            TestIntParams( "2020-1", 2020, 1, 2020, 1, 14600 ),
            TestIntParams( "2020-2", 2020, 2, 2020, 2, 14600 ),
            TestIntParams( "2020-3", 2020, 3, 2020, 3, 14600 ),
            TestIntParams( "2020-4", 2020, 4, 2020, 4, 14600 ),
            TestIntParams( "2020-5", 2020, 5, 2020, 5, 14600 ),
            TestIntParams( "2020-6", 2020, 6, 2020, 6, 14600 ),
            TestIntParams( "2020-7", 2020, 7, 2020, 7, 14600 ),
            TestIntParams( "2020-8", 2020, 8, 2020, 8, 14600 ),
            TestIntParams( "2020-9", 2020, 9, 2020, 9, 14600 ),
            TestIntParams( "2020-10", 2020, 10, 2020, 10, 14600 ),
            TestIntParams( "2020-11", 2020, 11, 2020, 11, 14600 ),
            TestIntParams( "2020-12", 2020, 12, 2020, 12, 14600 ),
        )),
        TestIntScenario("2021", listOf(
            TestIntParams( "2021-1", 2021, 1, 2021, 1, 15200 ),
            TestIntParams( "2021-2", 2021, 2, 2021, 2, 15200 ),
            TestIntParams( "2021-3", 2021, 3, 2021, 3, 15200 ),
            TestIntParams( "2021-4", 2021, 4, 2021, 4, 15200 ),
            TestIntParams( "2021-5", 2021, 5, 2021, 5, 15200 ),
            TestIntParams( "2021-6", 2021, 6, 2021, 6, 15200 ),
            TestIntParams( "2021-7", 2021, 7, 2021, 7, 15200 ),
            TestIntParams( "2021-8", 2021, 8, 2021, 8, 15200 ),
            TestIntParams( "2021-9", 2021, 9, 2021, 9, 15200 ),
            TestIntParams( "2021-10", 2021, 10, 2021, 10, 15200 ),
            TestIntParams( "2021-11", 2021, 11, 2021, 11, 15200 ),
            TestIntParams( "2021-12", 2021, 12, 2021, 12, 15200 ),
        )),
        TestIntScenario("2022", listOf(
            TestIntParams( "2022-1",  2022,  1, 2022,  1,15200 ),
            TestIntParams( "2022-2",  2022,  2, 2022,  2,15200 ),
            TestIntParams( "2022-3",  2022,  3, 2022,  3,15200 ),
            TestIntParams( "2022-4",  2022,  4, 2022,  4,15200 ),
            TestIntParams( "2022-5",  2022,  5, 2022,  5,15200 ),
            TestIntParams( "2022-6",  2022,  6, 2022,  6,15200 ),
            TestIntParams( "2022-7",  2022,  7, 2022,  7,15200 ),
            TestIntParams( "2022-8",  2022,  8, 2022,  8,15200 ),
            TestIntParams( "2022-9",  2022,  9, 2022,  9,15200 ),
            TestIntParams( "2022-10", 2022, 10, 2022, 10, 15200 ),
            TestIntParams( "2022-11", 2022, 11, 2022, 11, 15200 ),
            TestIntParams( "2022-12", 2022, 12, 2022, 12, 15200 ),
        )),
    )
    // 01_Health_01_MinMonthlyBasis
    logTestIntExamples("01_Health_01_MinMonthlyBasis.txt", testList)

    testList.forEach { tx ->
        describe("year ${tx.title}") {
            tx.tests.forEach { tt ->
                context("period ${tt.title}") {
                    val period = Period.getWithYearMonth(tt.year, tt.month)
                    val service = ServiceLegalios()
                    val result: Result<IBundleProps, HistoryResultError> = service.getBundle(period)

                    val bundle: IBundleProps? = result.get()
                    val error: HistoryResultError? = result.getError()
                    val props: IPropsHealth? = bundle?.healthProps


                    tt.testBasicResult(this, result, bundle, props, error)

                    it("GetProps should return value = ${tt.expected}") {
                        assertEquals(tt.expected, props?.minMonthlyBasis)
                    }
                }
            }
        }
    }
})
