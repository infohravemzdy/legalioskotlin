package org.hravemzdy.legalios.operations

import org.hravemzdy.legalios.props.PropsSalary
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.math.BigDecimal
import kotlin.test.assertEquals

class SalaryRoundingTest : Spek({
    data class TestSpecParams(val testTarget: String, val testResult: String)

    describe("HoursToHalfHoursUp_ShouldReturn_RoundedDecimal") {
        listOf(
            TestSpecParams("5,125", "5,50"),
            TestSpecParams("2,125", "2,50"),
            TestSpecParams("1,126", "1,50"),
            TestSpecParams("1,121", "1,50"),
            TestSpecParams("1,120", "1,50"),
            TestSpecParams("-1,120", "-1,50"),
            TestSpecParams("-1,121", "-1,50"),
            TestSpecParams("-1,126", "-1,50"),
            TestSpecParams("-2,125", "-2,50"),
            TestSpecParams("-5,125", "-5,50"),
            TestSpecParams("5,375", "5,50"),
            TestSpecParams("2,375", "2,50"),
            TestSpecParams("1,376", "1,50"),
            TestSpecParams("1,371", "1,50"),
            TestSpecParams("1,370", "1,50"),
            TestSpecParams("-1,370", "-1,50"),
            TestSpecParams("-1,371", "-1,50"),
            TestSpecParams("-1,376", "-1,50"),
            TestSpecParams("-2,375", "-2,50"),
            TestSpecParams("-5,375", "-5,50"),
            TestSpecParams("5,625", "6,00"),
            TestSpecParams("2,625", "3,00"),
            TestSpecParams("1,626", "2,00"),
            TestSpecParams("1,621", "2,00"),
            TestSpecParams("1,620", "2,00"),
            TestSpecParams("-1,620", "-2,00"),
            TestSpecParams("-1,621", "-2,00"),
            TestSpecParams("-1,626", "-2,00"),
            TestSpecParams("-2,625", "-3,00"),
            TestSpecParams("-5,625", "-6,00"),
            TestSpecParams("5,875", "6,00"),
            TestSpecParams("2,875", "3,00"),
            TestSpecParams("1,876", "2,00"),
            TestSpecParams("1,871", "2,00"),
            TestSpecParams("1,870", "2,00"),
            TestSpecParams("-1,870", "-2,00"),
            TestSpecParams("-1,871", "-2,00"),
            TestSpecParams("-1,876", "-2,00"),
            TestSpecParams("-2,875", "-3,00"),
            TestSpecParams("-5,875", "-6,00"),
            TestSpecParams("5,55", "6"),
            TestSpecParams("2,55", "3"),
            TestSpecParams("1,56", "2"),
            TestSpecParams("1,51", "2"),
            TestSpecParams("1,50", "1,50"),
            TestSpecParams("-1,50", "-1,50"),
            TestSpecParams("-1,51", "-2"),
            TestSpecParams("-1,56", "-2"),
            TestSpecParams("-2,55", "-3"),
            TestSpecParams("-5,55", "-6"),
            TestSpecParams("5,05", "5,50"),
            TestSpecParams("2,05", "2,50"),
            TestSpecParams("1,06", "1,50"),
            TestSpecParams("1,01", "1,50"),
            TestSpecParams("1,00", "1,00"),
            TestSpecParams("-1,00", "-1,00"),
            TestSpecParams("-1,01", "-1,50"),
            TestSpecParams("-1,06", "-1,50"),
            TestSpecParams("-2,05", "-2,50"),
            TestSpecParams("-5,05", "-5,50"),
        ).forEach { tt ->
            describe("Rounding Value${tt.testTarget}") {
                val decimalTarget = BigDecimal(tt.testTarget.replace(',','.'))
                val decimalResult = BigDecimal(tt.testResult.replace(',','.'))

                val _sut = PropsSalary.empty()

                val decimalRounds = _sut.hoursToHalfHoursUp(decimalTarget)

                it("rounding value should equal ${tt.testResult}") {
                    assertEquals(0, decimalRounds.compareTo(decimalResult), "rounding operation failed; expected = ${decimalResult}, actual=${decimalRounds}")
                }
            }
        }
    }

    describe("HoursToQuartHoursUp_ShouldReturn_RoundedDecimal") {
        listOf(
            TestSpecParams("5,125", "5,25"),
            TestSpecParams("2,125", "2,25"),
            TestSpecParams("1,126", "1,25"),
            TestSpecParams("1,121", "1,25"),
            TestSpecParams("1,120", "1,25"),
            TestSpecParams("-1,120", "-1,25"),
            TestSpecParams("-1,121", "-1,25"),
            TestSpecParams("-1,126", "-1,25"),
            TestSpecParams("-2,125", "-2,25"),
            TestSpecParams("-5,125", "-5,25"),
            TestSpecParams("5,375", "5,50"),
            TestSpecParams("2,375", "2,50"),
            TestSpecParams("1,376", "1,50"),
            TestSpecParams("1,371", "1,50"),
            TestSpecParams("1,370", "1,50"),
            TestSpecParams("-1,370", "-1,50"),
            TestSpecParams("-1,371", "-1,50"),
            TestSpecParams("-1,376", "-1,50"),
            TestSpecParams("-2,375", "-2,50"),
            TestSpecParams("-5,375", "-5,50"),
            TestSpecParams("5,625", "5,75"),
            TestSpecParams("2,625", "2,75"),
            TestSpecParams("1,626", "1,75"),
            TestSpecParams("1,621", "1,75"),
            TestSpecParams("1,620", "1,75"),
            TestSpecParams("-1,620", "-1,75"),
            TestSpecParams("-1,621", "-1,75"),
            TestSpecParams("-1,626", "-1,75"),
            TestSpecParams("-2,625", "-2,75"),
            TestSpecParams("-5,625", "-5,75"),
            TestSpecParams("5,875", "6,00"),
            TestSpecParams("2,875", "3,00"),
            TestSpecParams("1,876", "2,00"),
            TestSpecParams("1,871", "2,00"),
            TestSpecParams("1,870", "2,00"),
            TestSpecParams("-1,870", "-2,00"),
            TestSpecParams("-1,871", "-2,00"),
            TestSpecParams("-1,876", "-2,00"),
            TestSpecParams("-2,875", "-3,00"),
            TestSpecParams("-5,875", "-6,00"),
            TestSpecParams("5,255", "5,50"),
            TestSpecParams("2,255", "2,50"),
            TestSpecParams("1,256", "1,50"),
            TestSpecParams("1,251", "1,50"),
            TestSpecParams("1,250", "1,25"),
            TestSpecParams("-1,250", "-1,25"),
            TestSpecParams("-1,251", "-1,50"),
            TestSpecParams("-1,256", "-1,50"),
            TestSpecParams("-2,255", "-2,50"),
            TestSpecParams("-5,255", "-5,50"),
            TestSpecParams("5,555", "5,75"),
            TestSpecParams("2,555", "2,75"),
            TestSpecParams("1,556", "1,75"),
            TestSpecParams("1,551", "1,75"),
            TestSpecParams("1,500", "1,50"),
            TestSpecParams("-1,500", "-1,50"),
            TestSpecParams("-1,551", "-1,75"),
            TestSpecParams("-1,556", "-1,75"),
            TestSpecParams("-2,555", "-2,75"),
            TestSpecParams("-5,555", "-5,75"),
            TestSpecParams("5,755", "6,00"),
            TestSpecParams("2,755", "3,00"),
            TestSpecParams("1,756", "2,00"),
            TestSpecParams("1,751", "2,00"),
            TestSpecParams("1,750", "1,75"),
            TestSpecParams("-1,750", "-1,75"),
            TestSpecParams("-1,751", "-2,00"),
            TestSpecParams("-1,756", "-2,00"),
            TestSpecParams("-2,755", "-3,00"),
            TestSpecParams("-5,755", "-6,00"),
            TestSpecParams("5,050", "5,25"),
            TestSpecParams("2,050", "2,25"),
            TestSpecParams("1,060", "1,25"),
            TestSpecParams("1,010", "1,25"),
            TestSpecParams("1,000", "1,00"),
            TestSpecParams("-1,000", "-1,00"),
            TestSpecParams("-1,010", "-1,25"),
            TestSpecParams("-1,060", "-1,25"),
            TestSpecParams("-2,050", "-2,25"),
            TestSpecParams("-5,050", "-5,25"),
        ).forEach { tt ->
            describe("Rounding Value${tt.testTarget}") {
                val decimalTarget = BigDecimal(tt.testTarget.replace(',','.'))
                val decimalResult = BigDecimal(tt.testResult.replace(',','.'))

                val _sut = PropsSalary.empty()
                val decimalRounds = _sut.hoursToQuartHoursUp(decimalTarget)

                it("rounding value should equal ${tt.testResult}") {
                    assertEquals(0, decimalRounds.compareTo(decimalResult), "rounding operation failed; expected = ${decimalResult}, actual=${decimalRounds}")
                }
            }
        }
    }

    describe("HoursToHalfHoursDown_ShouldReturn_RoundedDecimal") {
        listOf(
            TestSpecParams("5,125", "5,00"),
            TestSpecParams("2,125", "2,00"),
            TestSpecParams("1,126", "1,00"),
            TestSpecParams("1,121", "1,00"),
            TestSpecParams("1,120", "1,00"),
            TestSpecParams("-1,120", "-1,00"),
            TestSpecParams("-1,121", "-1,00"),
            TestSpecParams("-1,126", "-1,00"),
            TestSpecParams("-2,125", "-2,00"),
            TestSpecParams("-5,125", "-5,00"),
            TestSpecParams("5,375", "5,00"),
            TestSpecParams("2,375", "2,00"),
            TestSpecParams("1,376", "1,00"),
            TestSpecParams("1,371", "1,00"),
            TestSpecParams("1,370", "1,00"),
            TestSpecParams("-1,370", "-1,00"),
            TestSpecParams("-1,371", "-1,00"),
            TestSpecParams("-1,376", "-1,00"),
            TestSpecParams("-2,375", "-2,00"),
            TestSpecParams("-5,375", "-5,00"),
            TestSpecParams("5,625", "5,50"),
            TestSpecParams("2,625", "2,50"),
            TestSpecParams("1,626", "1,50"),
            TestSpecParams("1,621", "1,50"),
            TestSpecParams("1,620", "1,50"),
            TestSpecParams("-1,620", "-1,50"),
            TestSpecParams("-1,621", "-1,50"),
            TestSpecParams("-1,626", "-1,50"),
            TestSpecParams("-2,625", "-2,50"),
            TestSpecParams("-5,625", "-5,50"),
            TestSpecParams("5,875", "5,50"),
            TestSpecParams("2,875", "2,50"),
            TestSpecParams("1,876", "1,50"),
            TestSpecParams("1,871", "1,50"),
            TestSpecParams("1,870", "1,50"),
            TestSpecParams("-1,870", "-1,50"),
            TestSpecParams("-1,871", "-1,50"),
            TestSpecParams("-1,876", "-1,50"),
            TestSpecParams("-2,875", "-2,50"),
            TestSpecParams("-5,875", "-5,50"),
            TestSpecParams("5,55", "5,50"),
            TestSpecParams("2,55", "2,50"),
            TestSpecParams("1,56", "1,50"),
            TestSpecParams("1,51", "1,50"),
            TestSpecParams("1,50", "1,50"),
            TestSpecParams("-1,50", "-1,50"),
            TestSpecParams("-1,51", "-1,50"),
            TestSpecParams("-1,56", "-1,50"),
            TestSpecParams("-2,55", "-2,50"),
            TestSpecParams("-5,55", "-5,50"),
            TestSpecParams("5,05", "5,00"),
            TestSpecParams("2,05", "2,00"),
            TestSpecParams("1,06", "1,00"),
            TestSpecParams("1,01", "1,00"),
            TestSpecParams("1,00", "1,00"),
            TestSpecParams("-1,00", "-1,00"),
            TestSpecParams("-1,01", "-1,00"),
            TestSpecParams("-1,06", "-1,00"),
            TestSpecParams("-2,05", "-2,00"),
            TestSpecParams("-5,05", "-5,00"),
        ).forEach { tt ->
            describe("Rounding Value${tt.testTarget}") {
                val decimalTarget = BigDecimal(tt.testTarget.replace(',','.'))
                val decimalResult = BigDecimal(tt.testResult.replace(',','.'))

                val _sut = PropsSalary.empty()
                val decimalRounds = _sut.hoursToHalfHoursDown(decimalTarget)

                it("rounding value should equal ${tt.testResult}") {
                    assertEquals(0, decimalRounds.compareTo(decimalResult), "rounding operation failed; expected = ${decimalResult}, actual=${decimalRounds}")
                }
            }
        }
    }

    describe("HoursToQuartHoursDown_ShouldReturn_RoundedDecimal") {
        listOf(
            TestSpecParams("5,125", "5,00"),
            TestSpecParams("2,125", "2,00"),
            TestSpecParams("1,126", "1,00"),
            TestSpecParams("1,121", "1,00"),
            TestSpecParams("1,120", "1,00"),
            TestSpecParams("-1,120", "-1,00"),
            TestSpecParams("-1,121", "-1,00"),
            TestSpecParams("-1,126", "-1,00"),
            TestSpecParams("-2,125", "-2,00"),
            TestSpecParams("-5,125", "-5,00"),
            TestSpecParams("5,375", "5,25"),
            TestSpecParams("2,375", "2,25"),
            TestSpecParams("1,376", "1,25"),
            TestSpecParams("1,371", "1,25"),
            TestSpecParams("1,370", "1,25"),
            TestSpecParams("-1,370", "-1,25"),
            TestSpecParams("-1,371", "-1,25"),
            TestSpecParams("-1,376", "-1,25"),
            TestSpecParams("-2,375", "-2,25"),
            TestSpecParams("-5,375", "-5,25"),
            TestSpecParams("5,625", "5,50"),
            TestSpecParams("2,625", "2,50"),
            TestSpecParams("1,626", "1,50"),
            TestSpecParams("1,621", "1,50"),
            TestSpecParams("1,620", "1,50"),
            TestSpecParams("-1,620", "-1,50"),
            TestSpecParams("-1,621", "-1,50"),
            TestSpecParams("-1,626", "-1,50"),
            TestSpecParams("-2,625", "-2,50"),
            TestSpecParams("-5,625", "-5,50"),
            TestSpecParams("5,875", "5,75"),
            TestSpecParams("2,875", "2,75"),
            TestSpecParams("1,876", "1,75"),
            TestSpecParams("1,871", "1,75"),
            TestSpecParams("1,870", "1,75"),
            TestSpecParams("-1,870", "-1,75"),
            TestSpecParams("-1,871", "-1,75"),
            TestSpecParams("-1,876", "-1,75"),
            TestSpecParams("-2,875", "-2,75"),
            TestSpecParams("-5,875", "-5,75"),
            TestSpecParams("5,255", "5,25"),
            TestSpecParams("2,255", "2,25"),
            TestSpecParams("1,256", "1,25"),
            TestSpecParams("1,251", "1,25"),
            TestSpecParams("1,250", "1,25"),
            TestSpecParams("-1,250", "-1,25"),
            TestSpecParams("-1,251", "-1,25"),
            TestSpecParams("-1,256", "-1,25"),
            TestSpecParams("-2,255", "-2,25"),
            TestSpecParams("-5,255", "-5,25"),
            TestSpecParams("5,555", "5,50"),
            TestSpecParams("2,555", "2,50"),
            TestSpecParams("1,556", "1,50"),
            TestSpecParams("1,551", "1,50"),
            TestSpecParams("1,500", "1,50"),
            TestSpecParams("-1,500", "-1,50"),
            TestSpecParams("-1,551", "-1,50"),
            TestSpecParams("-1,556", "-1,50"),
            TestSpecParams("-2,555", "-2,50"),
            TestSpecParams("-5,555", "-5,50"),
            TestSpecParams("5,755", "5,75"),
            TestSpecParams("2,755", "2,75"),
            TestSpecParams("1,756", "1,75"),
            TestSpecParams("1,751", "1,75"),
            TestSpecParams("1,750", "1,75"),
            TestSpecParams("-1,750", "-1,75"),
            TestSpecParams("-1,751", "-1,75"),
            TestSpecParams("-1,756", "-1,75"),
            TestSpecParams("-2,755", "-2,75"),
            TestSpecParams("-5,755", "-5,75"),
            TestSpecParams("5,050", "5,00"),
            TestSpecParams("2,050", "2,00"),
            TestSpecParams("1,060", "1,00"),
            TestSpecParams("1,010", "1,00"),
            TestSpecParams("1,000", "1,00"),
            TestSpecParams("-1,000", "-1,00"),
            TestSpecParams("-1,010", "-1,00"),
            TestSpecParams("-1,060", "-1,00"),
            TestSpecParams("-2,050", "-2,00"),
            TestSpecParams("-5,050", "-5,00"),
        ).forEach { tt ->
            describe("Rounding Value${tt.testTarget}") {
                val decimalTarget = BigDecimal(tt.testTarget.replace(',','.'))
                val decimalResult = BigDecimal(tt.testResult.replace(',','.'))

                val _sut = PropsSalary.empty()
                val decimalRounds = _sut.hoursToQuartHoursDown(decimalTarget)

                it("rounding value should equal ${tt.testResult}") {
                    assertEquals(0, decimalRounds.compareTo(decimalResult), "rounding operation failed; expected = ${decimalResult}, actual=${decimalRounds}")
                }
            }
        }
    }

    describe("HoursToHalfHoursNorm_ShouldReturn_RoundedDecimal") {
        listOf(
            TestSpecParams("5,125", "5,00"),
            TestSpecParams("2,125", "2,00"),
            TestSpecParams("1,126", "1,00"),
            TestSpecParams("1,121", "1,00"),
            TestSpecParams("1,120", "1,00"),
            TestSpecParams("-1,120", "-1,00"),
            TestSpecParams("-1,121", "-1,00"),
            TestSpecParams("-1,126", "-1,00"),
            TestSpecParams("-2,125", "-2,00"),
            TestSpecParams("-5,125", "-5,00"),
            TestSpecParams("5,375", "5,50"),
            TestSpecParams("2,375", "2,50"),
            TestSpecParams("1,376", "1,50"),
            TestSpecParams("1,371", "1,50"),
            TestSpecParams("1,370", "1,50"),
            TestSpecParams("-1,370", "-1,50"),
            TestSpecParams("-1,371", "-1,50"),
            TestSpecParams("-1,376", "-1,50"),
            TestSpecParams("-2,375", "-2,50"),
            TestSpecParams("-5,375", "-5,50"),
            TestSpecParams("5,625", "5,50"),
            TestSpecParams("2,625", "2,50"),
            TestSpecParams("1,626", "1,50"),
            TestSpecParams("1,621", "1,50"),
            TestSpecParams("1,620", "1,50"),
            TestSpecParams("-1,620", "-1,50"),
            TestSpecParams("-1,621", "-1,50"),
            TestSpecParams("-1,626", "-1,50"),
            TestSpecParams("-2,625", "-2,50"),
            TestSpecParams("-5,625", "-5,50"),
            TestSpecParams("5,875", "6,00"),
            TestSpecParams("2,875", "3,00"),
            TestSpecParams("1,876", "2,00"),
            TestSpecParams("1,871", "2,00"),
            TestSpecParams("1,870", "2,00"),
            TestSpecParams("-1,870", "-2,00"),
            TestSpecParams("-1,871", "-2,00"),
            TestSpecParams("-1,876", "-2,00"),
            TestSpecParams("-2,875", "-3,00"),
            TestSpecParams("-5,875", "-6,00"),
            TestSpecParams("5,55", "5,50"),
            TestSpecParams("2,55", "2,50"),
            TestSpecParams("1,56", "1,50"),
            TestSpecParams("1,51", "1,50"),
            TestSpecParams("1,50", "1,50"),
            TestSpecParams("-1,50", "-1,50"),
            TestSpecParams("-1,51", "-1,50"),
            TestSpecParams("-1,56", "-1,50"),
            TestSpecParams("-2,55", "-2,50"),
            TestSpecParams("-5,55", "-5,50"),
            TestSpecParams("5,05", "5,00"),
            TestSpecParams("2,05", "2,00"),
            TestSpecParams("1,06", "1,00"),
            TestSpecParams("1,01", "1,00"),
            TestSpecParams("1,00", "1,00"),
            TestSpecParams("-1,00", "-1,00"),
            TestSpecParams("-1,01", "-1,00"),
            TestSpecParams("-1,06", "-1,00"),
            TestSpecParams("-2,05", "-2,00"),
            TestSpecParams("-5,05", "-5,00"),
        ).forEach { tt ->
            describe("Rounding Value${tt.testTarget}") {
                val decimalTarget = BigDecimal(tt.testTarget.replace(',','.'))
                val decimalResult = BigDecimal(tt.testResult.replace(',','.'))

                val _sut = PropsSalary.empty()
                val decimalRounds = _sut.hoursToHalfHoursNorm(decimalTarget)

                it("rounding value should equal ${tt.testResult}") {
                    assertEquals(0, decimalRounds.compareTo(decimalResult), "rounding operation failed; expected = ${decimalResult}, actual=${decimalRounds}")
                }
            }
        }
    }

    describe("HoursToQuartHoursNorm_ShouldReturn_RoundedDecimal") {
        listOf(
            TestSpecParams("5,125", "5,25"),
            TestSpecParams("2,125", "2,25"),
            TestSpecParams("1,126", "1,25"),
            TestSpecParams("1,121", "1,00"),
            TestSpecParams("1,120", "1,00"),
            TestSpecParams("-1,120", "-1,00"),
            TestSpecParams("-1,121", "-1,00"),
            TestSpecParams("-1,126", "-1,25"),
            TestSpecParams("-2,125", "-2,25"),
            TestSpecParams("-5,125", "-5,25"),
            TestSpecParams("5,375", "5,50"),
            TestSpecParams("2,375", "2,50"),
            TestSpecParams("1,376", "1,50"),
            TestSpecParams("1,371", "1,25"),
            TestSpecParams("1,370", "1,25"),
            TestSpecParams("-1,370", "-1,25"),
            TestSpecParams("-1,371", "-1,25"),
            TestSpecParams("-1,376", "-1,50"),
            TestSpecParams("-2,375", "-2,50"),
            TestSpecParams("-5,375", "-5,50"),
            TestSpecParams("5,625", "5,75"),
            TestSpecParams("2,625", "2,75"),
            TestSpecParams("1,626", "1,75"),
            TestSpecParams("1,621", "1,50"),
            TestSpecParams("1,620", "1,50"),
            TestSpecParams("-1,620", "-1,50"),
            TestSpecParams("-1,621", "-1,50"),
            TestSpecParams("-1,626", "-1,75"),
            TestSpecParams("-2,625", "-2,75"),
            TestSpecParams("-5,625", "-5,75"),
            TestSpecParams("5,875", "6,00"),
            TestSpecParams("2,875", "3,00"),
            TestSpecParams("1,876", "2,00"),
            TestSpecParams("1,871", "1,75"),
            TestSpecParams("1,870", "1,75"),
            TestSpecParams("-1,870", "-1,75"),
            TestSpecParams("-1,871", "-1,75"),
            TestSpecParams("-1,876", "-2,00"),
            TestSpecParams("-2,875", "-3,00"),
            TestSpecParams("-5,875", "-6,00"),
            TestSpecParams("5,255", "5,25"),
            TestSpecParams("2,255", "2,25"),
            TestSpecParams("1,256", "1,25"),
            TestSpecParams("1,251", "1,25"),
            TestSpecParams("1,250", "1,25"),
            TestSpecParams("-1,250", "-1,25"),
            TestSpecParams("-1,251", "-1,25"),
            TestSpecParams("-1,256", "-1,25"),
            TestSpecParams("-2,255", "-2,25"),
            TestSpecParams("-5,255", "-5,25"),
            TestSpecParams("5,555", "5,50"),
            TestSpecParams("2,555", "2,50"),
            TestSpecParams("1,556", "1,50"),
            TestSpecParams("1,551", "1,50"),
            TestSpecParams("1,500", "1,50"),
            TestSpecParams("-1,500", "-1,50"),
            TestSpecParams("-1,551", "-1,50"),
            TestSpecParams("-1,556", "-1,50"),
            TestSpecParams("-2,555", "-2,50"),
            TestSpecParams("-5,555", "-5,50"),
            TestSpecParams("5,755", "5,75"),
            TestSpecParams("2,755", "2,75"),
            TestSpecParams("1,756", "1,75"),
            TestSpecParams("1,751", "1,75"),
            TestSpecParams("1,750", "1,75"),
            TestSpecParams("-1,750", "-1,75"),
            TestSpecParams("-1,751", "-1,75"),
            TestSpecParams("-1,756", "-1,75"),
            TestSpecParams("-2,755", "-2,75"),
            TestSpecParams("-5,755", "-5,75"),
            TestSpecParams("5,050", "5,00"),
            TestSpecParams("2,050", "2,00"),
            TestSpecParams("1,060", "1,00"),
            TestSpecParams("1,010", "1,00"),
            TestSpecParams("1,000", "1,00"),
            TestSpecParams("-1,000", "-1,00"),
            TestSpecParams("-1,010", "-1,00"),
            TestSpecParams("-1,060", "-1,00"),
            TestSpecParams("-2,050", "-2,00"),
            TestSpecParams("-5,050", "-5,00"),
        ).forEach { tt ->
            describe("Rounding Value${tt.testTarget}") {
                val decimalTarget = BigDecimal(tt.testTarget.replace(',','.'))
                val decimalResult = BigDecimal(tt.testResult.replace(',','.'))

                val _sut = PropsSalary.empty()
                val decimalRounds = _sut.hoursToQuartHoursNorm(decimalTarget)

                it("rounding value should equal ${tt.testResult}") {
                    assertEquals(0, decimalRounds.compareTo(decimalResult), "rounding operation failed; expected = ${decimalResult}, actual=${decimalRounds}")
                }
            }
        }
    }

    describe("MoneyToRoundDown_ShouldReturn_RoundedDecimal") {
        listOf(
            TestSpecParams("5,555", "5,55"),
            TestSpecParams("2,555", "2,55"),
            TestSpecParams("1,556", "1,55"),
            TestSpecParams("1,551", "1,55"),
            TestSpecParams("1,550", "1,55"),
            TestSpecParams("-1,550", "-1,55"),
            TestSpecParams("-1,551", "-1,55"),
            TestSpecParams("-1,556", "-1,55"),
            TestSpecParams("-2,555", "-2,55"),
            TestSpecParams("-5,555", "-5,55"),
            TestSpecParams("5,005", "5,00"),
            TestSpecParams("2,005", "2,00"),
            TestSpecParams("1,006", "1,00"),
            TestSpecParams("1,001", "1,00"),
            TestSpecParams("1,000", "1,00"),
            TestSpecParams("-1,000", "-1,00"),
            TestSpecParams("-1,001", "-1,00"),
            TestSpecParams("-1,006", "-1,00"),
            TestSpecParams("-2,005", "-2,00"),
            TestSpecParams("-5,005", "-5,00"),
        ).forEach { tt ->
            describe("Rounding Value${tt.testTarget}") {
                val decimalTarget = BigDecimal(tt.testTarget.replace(',','.'))
                val decimalResult = BigDecimal(tt.testResult.replace(',','.'))

                val _sut = PropsSalary.empty()
                val decimalRounds = _sut.moneyToRoundDown(decimalTarget)

                it("rounding value should equal ${tt.testResult}") {
                    assertEquals(0, decimalRounds.compareTo(decimalResult), "rounding operation failed; expected = ${decimalResult}, actual=${decimalRounds}")
                }
            }
        }
    }

    describe("MoneyToRoundUp_ShouldReturn_RoundedDecimal") {
        listOf(
            TestSpecParams("5,555", "5,56"),
            TestSpecParams("2,555", "2,56"),
            TestSpecParams("1,556", "1,56"),
            TestSpecParams("1,551", "1,56"),
            TestSpecParams("1,550", "1,55"),
            TestSpecParams("-1,550", "-1,55"),
            TestSpecParams("-1,551", "-1,56"),
            TestSpecParams("-1,556", "-1,56"),
            TestSpecParams("-2,555", "-2,56"),
            TestSpecParams("-5,555", "-5,56"),
            TestSpecParams("5,005", "5,01"),
            TestSpecParams("2,005", "2,01"),
            TestSpecParams("1,006", "1,01"),
            TestSpecParams("1,001", "1,01"),
            TestSpecParams("1,000", "1,00"),
            TestSpecParams("-1,000", "-1,00"),
            TestSpecParams("-1,001", "-1,01"),
            TestSpecParams("-1,006", "-1,01"),
            TestSpecParams("-2,005", "-2,01"),
            TestSpecParams("-5,005", "-5,01"),
        ).forEach { tt ->
            describe("Rounding Value${tt.testTarget}") {
                val decimalTarget = BigDecimal(tt.testTarget.replace(',','.'))
                val decimalResult = BigDecimal(tt.testResult.replace(',','.'))

                val _sut = PropsSalary.empty()
                val decimalRounds = _sut.moneyToRoundUp(decimalTarget)

                it("rounding value should equal ${tt.testResult}") {
                    assertEquals(0, decimalRounds.compareTo(decimalResult), "rounding operation failed; expected = ${decimalResult}, actual=${decimalRounds}")
                }
            }
        }
    }

    describe("MoneyToRoundNorm_ShouldReturn_RoundedDecimal") {
        listOf(
            TestSpecParams("5,555", "5,56"),
            TestSpecParams("2,555", "2,56"),
            TestSpecParams("1,556", "1,56"),
            TestSpecParams("1,551", "1,55"),
            TestSpecParams("1,550", "1,55"),
            TestSpecParams("-1,550", "-1,55"),
            TestSpecParams("-1,551", "-1,55"),
            TestSpecParams("-1,556", "-1,56"),
            TestSpecParams("-2,555", "-2,56"),
            TestSpecParams("-5,555", "-5,56"),
            TestSpecParams("5,005", "5,01"),
            TestSpecParams("2,005", "2,01"),
            TestSpecParams("1,006", "1,01"),
            TestSpecParams("1,001", "1,00"),
            TestSpecParams("1,000", "1,00"),
            TestSpecParams("-1,000", "-1,00"),
            TestSpecParams("-1,001", "-1,00"),
            TestSpecParams("-1,006", "-1,01"),
            TestSpecParams("-2,005", "-2,01"),
            TestSpecParams("-5,005", "-5,01"),
        ).forEach { tt ->
            describe("Rounding Value${tt.testTarget}") {
                val decimalTarget = BigDecimal(tt.testTarget.replace(',','.'))
                val decimalResult = BigDecimal(tt.testResult.replace(',','.'))

                val _sut = PropsSalary.empty()
                val decimalRounds = _sut.moneyToRoundNorm(decimalTarget)

                it("rounding value should equal ${tt.testResult}") {
                    assertEquals(0, decimalRounds.compareTo(decimalResult), "rounding operation failed; expected = ${decimalResult}, actual=${decimalRounds}")
                }
            }
        }
    }
})