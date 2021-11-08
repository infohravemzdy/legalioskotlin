package org.hravemzdy.legalios.service

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.hravemzdy.legalios.interfaces.IBundleProps
import java.io.File
import java.io.FileWriter
import java.nio.file.Paths
import kotlin.math.roundToInt
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import org.hravemzdy.legalios.interfaces.IProps
import org.spekframework.spek2.style.specification.Suite
import java.math.BigDecimal

const val __test_protokol_file__ = false

const val EXAMPLE_FOLDER_PATH = "../../../test_expected"
const val EXAMPLE_FOLDER_NAME = "test_expected"
const val PARENT_EXAMPLE_FOLDER_NAME = "legalios"

fun createLoggerFile(fileName : String): FileWriter {
    var currPath = Paths.get(".").toAbsolutePath()
    while (!currPath.endsWith(PARENT_EXAMPLE_FOLDER_NAME) || currPath.nameCount==1) {
        currPath = currPath.parent
    }
    val basePath = Paths.get(currPath.toString(), EXAMPLE_FOLDER_NAME)
    val path = Paths.get(basePath.toString(), fileName).toAbsolutePath().toString()
    return FileWriter(File(path))
}

fun closeLoggerFile(protokol: FileWriter) {
    protokol.flush()
    protokol.close()
}

fun logTestStart(protokol: FileWriter) {
    protokol.write("")

    protokol.write("YEAR")
    for (testMonth in 1..12) {
        protokol.write("\t$testMonth")
    }
    protokol.write("\n")
}


fun logTestYear(protokol: FileWriter, value: String) {
    protokol.write("$value")
}

fun logTestEnd(protokol: FileWriter) {
    protokol.write("\n")
}


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

fun logExampleIntValue(protokol: FileWriter, value: Int) {
    protokol.write("\t$value")
}

fun logTestIntExamples(fileName : String, tests: List<TestIntScenario>) {
    if (__test_protokol_file__) {
        var testLogger = createLoggerFile(fileName)

        testLogger.use {
            logTestStart(testLogger)
            tests.forEach { tx ->
                logTestYear(testLogger, tx.title)
                tx.tests.forEach { tt ->
                    logExampleIntValue(testLogger, tt.expected)
                }
                logTestEnd(testLogger)
            }
            closeLoggerFile(testLogger)
        }
    }
}

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
        return BigDecimal(intValue).divide(BigDecimal(100))
    }
}
data class TestDecScenario(val title: String, val tests: List<TestDecParams>)

fun logExampleDecValue(protokol: FileWriter, value: Double) {
    val intValue: Int = (value*100).roundToInt()
    protokol.write("\t$intValue")
}

fun logTestDecExamples(fileName : String, tests: List<TestDecScenario>) {
    if (__test_protokol_file__) {
        var testLogger = createLoggerFile(fileName)

        testLogger.use {
            logTestStart(testLogger)
            tests.forEach { tx ->
                logTestYear(testLogger, tx.title)
                tx.tests.forEach { tt ->
                    logExampleDecValue(testLogger, tt.expected)
                }
                logTestEnd(testLogger)
            }
            closeLoggerFile(testLogger)
        }
    }
}

