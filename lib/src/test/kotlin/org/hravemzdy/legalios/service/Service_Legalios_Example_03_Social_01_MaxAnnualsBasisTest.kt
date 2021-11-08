package org.hravemzdy.legalios.service

import com.github.michaelbull.result.*
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.hravemzdy.legalios.interfaces.IBundleProps
import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.service.types.Period
import org.hravemzdy.legalios.service.ServiceLegalios
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

class Service_Legalios_Example_03_Social_01_MaxAnnualsBasisTest  : Spek({
    val testList = listOf(
        TestIntScenario("2011", listOf(
            TestIntParams( "2011-1", 2011, 1, 2011, 1, 1781280 ),
            TestIntParams( "2011-2", 2011, 2, 2011, 2, 1781280 ),
            TestIntParams( "2011-3", 2011, 3, 2011, 3, 1781280 ),
            TestIntParams( "2011-4", 2011, 4, 2011, 4, 1781280 ),
            TestIntParams( "2011-5", 2011, 5, 2011, 5, 1781280 ),
            TestIntParams( "2011-6", 2011, 6, 2011, 6, 1781280 ),
            TestIntParams( "2011-7", 2011, 7, 2011, 7, 1781280 ),
            TestIntParams( "2011-8", 2011, 8, 2011, 8, 1781280 ),
            TestIntParams( "2011-9", 2011, 9, 2011, 9, 1781280 ),
            TestIntParams( "2011-10", 2011, 10, 2011, 10, 1781280 ),
            TestIntParams( "2011-11", 2011, 11, 2011, 11, 1781280 ),
            TestIntParams( "2011-12", 2011, 12, 2011, 12, 1781280 ),
        )),
        TestIntScenario("2012", listOf(
            TestIntParams( "2012-1", 2012, 1, 2012, 1, 1206576 ),
            TestIntParams( "2012-2", 2012, 2, 2012, 2, 1206576 ),
            TestIntParams( "2012-3", 2012, 3, 2012, 3, 1206576 ),
            TestIntParams( "2012-4", 2012, 4, 2012, 4, 1206576 ),
            TestIntParams( "2012-5", 2012, 5, 2012, 5, 1206576 ),
            TestIntParams( "2012-6", 2012, 6, 2012, 6, 1206576 ),
            TestIntParams( "2012-7", 2012, 7, 2012, 7, 1206576 ),
            TestIntParams( "2012-8", 2012, 8, 2012, 8, 1206576 ),
            TestIntParams( "2012-9", 2012, 9, 2012, 9, 1206576 ),
            TestIntParams( "2012-10", 2012, 10, 2012, 10, 1206576 ),
            TestIntParams( "2012-11", 2012, 11, 2012, 11, 1206576 ),
            TestIntParams( "2012-12", 2012, 12, 2012, 12, 1206576 ),
        )),
        TestIntScenario("2013", listOf(
            TestIntParams( "2013-1", 2013, 1, 2013, 1, 1242432 ),
            TestIntParams( "2013-2", 2013, 2, 2013, 2, 1242432 ),
            TestIntParams( "2013-3", 2013, 3, 2013, 3, 1242432 ),
            TestIntParams( "2013-4", 2013, 4, 2013, 4, 1242432 ),
            TestIntParams( "2013-5", 2013, 5, 2013, 5, 1242432 ),
            TestIntParams( "2013-6", 2013, 6, 2013, 6, 1242432 ),
            TestIntParams( "2013-7", 2013, 7, 2013, 7, 1242432 ),
            TestIntParams( "2013-8", 2013, 8, 2013, 8, 1242432 ),
            TestIntParams( "2013-9", 2013, 9, 2013, 9, 1242432 ),
            TestIntParams( "2013-10", 2013, 10, 2013, 10, 1242432 ),
            TestIntParams( "2013-11", 2013, 11, 2013, 11, 1242432 ),
            TestIntParams( "2013-12", 2013, 12, 2013, 12, 1242432 ),
        )),
        TestIntScenario("2014", listOf(
            TestIntParams( "2014-1", 2014, 1, 2014, 1, 1245216 ),
            TestIntParams( "2014-2", 2014, 2, 2014, 2, 1245216 ),
            TestIntParams( "2014-3", 2014, 3, 2014, 3, 1245216 ),
            TestIntParams( "2014-4", 2014, 4, 2014, 4, 1245216 ),
            TestIntParams( "2014-5", 2014, 5, 2014, 5, 1245216 ),
            TestIntParams( "2014-6", 2014, 6, 2014, 6, 1245216 ),
            TestIntParams( "2014-7", 2014, 7, 2014, 7, 1245216 ),
            TestIntParams( "2014-8", 2014, 8, 2014, 8, 1245216 ),
            TestIntParams( "2014-9", 2014, 9, 2014, 9, 1245216 ),
            TestIntParams( "2014-10", 2014, 10, 2014, 10, 1245216 ),
            TestIntParams( "2014-11", 2014, 11, 2014, 11, 1245216 ),
            TestIntParams( "2014-12", 2014, 12, 2014, 12, 1245216 ),
        )),
        TestIntScenario("2015", listOf(
            TestIntParams( "2015-1", 2015, 1, 2015, 1, 1277328 ),
            TestIntParams( "2015-2", 2015, 2, 2015, 2, 1277328 ),
            TestIntParams( "2015-3", 2015, 3, 2015, 3, 1277328 ),
            TestIntParams( "2015-4", 2015, 4, 2015, 4, 1277328 ),
            TestIntParams( "2015-5", 2015, 5, 2015, 5, 1277328 ),
            TestIntParams( "2015-6", 2015, 6, 2015, 6, 1277328 ),
            TestIntParams( "2015-7", 2015, 7, 2015, 7, 1277328 ),
            TestIntParams( "2015-8", 2015, 8, 2015, 8, 1277328 ),
            TestIntParams( "2015-9", 2015, 9, 2015, 9, 1277328 ),
            TestIntParams( "2015-10", 2015, 10, 2015, 10, 1277328 ),
            TestIntParams( "2015-11", 2015, 11, 2015, 11, 1277328 ),
            TestIntParams( "2015-12", 2015, 12, 2015, 12, 1277328 ),
        )),
        TestIntScenario("2016", listOf(
            TestIntParams( "2016-1", 2016, 1, 2016, 1, 1296288 ),
            TestIntParams( "2016-2", 2016, 2, 2016, 2, 1296288 ),
            TestIntParams( "2016-3", 2016, 3, 2016, 3, 1296288 ),
            TestIntParams( "2016-4", 2016, 4, 2016, 4, 1296288 ),
            TestIntParams( "2016-5", 2016, 5, 2016, 5, 1296288 ),
            TestIntParams( "2016-6", 2016, 6, 2016, 6, 1296288 ),
            TestIntParams( "2016-7", 2016, 7, 2016, 7, 1296288 ),
            TestIntParams( "2016-8", 2016, 8, 2016, 8, 1296288 ),
            TestIntParams( "2016-9", 2016, 9, 2016, 9, 1296288 ),
            TestIntParams( "2016-10", 2016, 10, 2016, 10, 1296288 ),
            TestIntParams( "2016-11", 2016, 11, 2016, 11, 1296288 ),
            TestIntParams( "2016-12", 2016, 12, 2016, 12, 1296288 ),
        )),
        TestIntScenario("2017", listOf(
            TestIntParams( "2017-1", 2017, 1, 2017, 1, 1355136 ),
            TestIntParams( "2017-2", 2017, 2, 2017, 2, 1355136 ),
            TestIntParams( "2017-3", 2017, 3, 2017, 3, 1355136 ),
            TestIntParams( "2017-4", 2017, 4, 2017, 4, 1355136 ),
            TestIntParams( "2017-5", 2017, 5, 2017, 5, 1355136 ),
            TestIntParams( "2017-6", 2017, 6, 2017, 6, 1355136 ),
            TestIntParams( "2017-7", 2017, 7, 2017, 7, 1355136 ),
            TestIntParams( "2017-8", 2017, 8, 2017, 8, 1355136 ),
            TestIntParams( "2017-9", 2017, 9, 2017, 9, 1355136 ),
            TestIntParams( "2017-10", 2017, 10, 2017, 10, 1355136 ),
            TestIntParams( "2017-11", 2017, 11, 2017, 11, 1355136 ),
            TestIntParams( "2017-12", 2017, 12, 2017, 12, 1355136 ),
        )),
        TestIntScenario("2018", listOf(
            TestIntParams( "2018-1", 2018, 1, 2018, 1, 1438992 ),
            TestIntParams( "2018-2", 2018, 2, 2018, 2, 1438992 ),
            TestIntParams( "2018-3", 2018, 3, 2018, 3, 1438992 ),
            TestIntParams( "2018-4", 2018, 4, 2018, 4, 1438992 ),
            TestIntParams( "2018-5", 2018, 5, 2018, 5, 1438992 ),
            TestIntParams( "2018-6", 2018, 6, 2018, 6, 1438992 ),
            TestIntParams( "2018-7", 2018, 7, 2018, 7, 1438992 ),
            TestIntParams( "2018-8", 2018, 8, 2018, 8, 1438992 ),
            TestIntParams( "2018-9", 2018, 9, 2018, 9, 1438992 ),
            TestIntParams( "2018-10", 2018, 10, 2018, 10, 1438992 ),
            TestIntParams( "2018-11", 2018, 11, 2018, 11, 1438992 ),
            TestIntParams( "2018-12", 2018, 12, 2018, 12, 1438992 ),
        )),
        TestIntScenario("2019", listOf(
            TestIntParams( "2019-1", 2019, 1, 2019, 1, 1569552 ),
            TestIntParams( "2019-2", 2019, 2, 2019, 2, 1569552 ),
            TestIntParams( "2019-3", 2019, 3, 2019, 3, 1569552 ),
            TestIntParams( "2019-4", 2019, 4, 2019, 4, 1569552 ),
            TestIntParams( "2019-5", 2019, 5, 2019, 5, 1569552 ),
            TestIntParams( "2019-6", 2019, 6, 2019, 6, 1569552 ),
            TestIntParams( "2019-7", 2019, 7, 2019, 7, 1569552 ),
            TestIntParams( "2019-8", 2019, 8, 2019, 8, 1569552 ),
            TestIntParams( "2019-9", 2019, 9, 2019, 9, 1569552 ),
            TestIntParams( "2019-10", 2019, 10, 2019, 10, 1569552 ),
            TestIntParams( "2019-11", 2019, 11, 2019, 11, 1569552 ),
            TestIntParams( "2019-12", 2019, 12, 2019, 12, 1569552 ),
        )),
        TestIntScenario("2020", listOf(
            TestIntParams( "2020-1", 2020, 1, 2020, 1, 1672080 ),
            TestIntParams( "2020-2", 2020, 2, 2020, 2, 1672080 ),
            TestIntParams( "2020-3", 2020, 3, 2020, 3, 1672080 ),
            TestIntParams( "2020-4", 2020, 4, 2020, 4, 1672080 ),
            TestIntParams( "2020-5", 2020, 5, 2020, 5, 1672080 ),
            TestIntParams( "2020-6", 2020, 6, 2020, 6, 1672080 ),
            TestIntParams( "2020-7", 2020, 7, 2020, 7, 1672080 ),
            TestIntParams( "2020-8", 2020, 8, 2020, 8, 1672080 ),
            TestIntParams( "2020-9", 2020, 9, 2020, 9, 1672080 ),
            TestIntParams( "2020-10", 2020, 10, 2020, 10, 1672080 ),
            TestIntParams( "2020-11", 2020, 11, 2020, 11, 1672080 ),
            TestIntParams( "2020-12", 2020, 12, 2020, 12, 1672080 ),
        )),
        TestIntScenario("2021", listOf(
            TestIntParams( "2021-1", 2021, 1, 2021, 1, 1701168 ),
            TestIntParams( "2021-2", 2021, 2, 2021, 2, 1701168 ),
            TestIntParams( "2021-3", 2021, 3, 2021, 3, 1701168 ),
            TestIntParams( "2021-4", 2021, 4, 2021, 4, 1701168 ),
            TestIntParams( "2021-5", 2021, 5, 2021, 5, 1701168 ),
            TestIntParams( "2021-6", 2021, 6, 2021, 6, 1701168 ),
            TestIntParams( "2021-7", 2021, 7, 2021, 7, 1701168 ),
            TestIntParams( "2021-8", 2021, 8, 2021, 8, 1701168 ),
            TestIntParams( "2021-9", 2021, 9, 2021, 9, 1701168 ),
            TestIntParams( "2021-10", 2021, 10, 2021, 10, 1701168 ),
            TestIntParams( "2021-11", 2021, 11, 2021, 11, 1701168 ),
            TestIntParams( "2021-12", 2021, 12, 2021, 12, 1701168 ),
        )),
        TestIntScenario("2022", listOf(
            TestIntParams( "2022-1",  2022,  1, 2022,  1,1701168 ),
            TestIntParams( "2022-2",  2022,  2, 2022,  2,1701168 ),
            TestIntParams( "2022-3",  2022,  3, 2022,  3,1701168 ),
            TestIntParams( "2022-4",  2022,  4, 2022,  4,1701168 ),
            TestIntParams( "2022-5",  2022,  5, 2022,  5,1701168 ),
            TestIntParams( "2022-6",  2022,  6, 2022,  6,1701168 ),
            TestIntParams( "2022-7",  2022,  7, 2022,  7,1701168 ),
            TestIntParams( "2022-8",  2022,  8, 2022,  8,1701168 ),
            TestIntParams( "2022-9",  2022,  9, 2022,  9,1701168 ),
            TestIntParams( "2022-10", 2022, 10, 2022, 10, 1701168 ),
            TestIntParams( "2022-11", 2022, 11, 2022, 11, 1701168 ),
            TestIntParams( "2022-12", 2022, 12, 2022, 12, 1701168 ),
        )),
    )
    // 03_Social_01_MaxAnnualsBasis
    logTestIntExamples("03_Social_01_MaxAnnualsBasis.txt", testList)

    testList.forEach { tx ->
        describe("year ${tx.title}") {
            tx.tests.forEach { tt ->
                context("period ${tt.title}") {
                    val period = Period.getWithYearMonth(tt.year, tt.month)
                    val service = ServiceLegalios()
                    val result: Result<IBundleProps, HistoryResultError> = service.getBundle(period)

                    val bundle: IBundleProps? = result.get()
                    val error: HistoryResultError? = result.getError()
                    val props: IPropsSocial? = bundle?.socialProps


                    tt.testBasicResult(this, result, bundle, props, error)

                    it("GetProps should return value = ${tt.expected}") {
                        assertEquals(tt.expected, props?.maxAnnualsBasis)
                    }
                }
            }
        }
    }
})