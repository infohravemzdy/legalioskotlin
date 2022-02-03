package org.hravemzdy.legalios.protokol

import org.hravemzdy.legalios.factories.IProviderFactory
import org.hravemzdy.legalios.providers.IPropsProvider
import org.hravemzdy.legalios.interfaces.*
import org.hravemzdy.legalios.service.types.Period
import java.io.File
import java.io.FileWriter
import java.math.BigDecimal
import java.nio.file.Paths

const val __test_protokol_file__ = false

const val PROTOKOL_FOLDER_PATH = "../../../test_values"
const val PROTOKOL_FOLDER_NAME = "test_values"
const val PARENT_PROTOKOL_FOLDER_NAME = "legalios"

fun <B : IPropsProvider<P>, P : IProps>exportPropsIntFile(fileName : String, minYear: Int, maxYear: Int, sut: IProviderFactory<P>, func: (P) -> Int) {
    if (__test_protokol_file__) {
        var testProtokol = createProtokolFile(fileName)

        testProtokol.use {
            exportPropsStart(testProtokol)

            for (testYear in minYear..maxYear) {
                exportPropsIntLine<B, P>(
                    testProtokol, testYear, sut, func)
            }
        }
    }
}

fun <B : IPropsProvider<P>, P : IProps>exportPropsIntLine(protokol: FileWriter, testYear: Int, sut: IProviderFactory<P>, func: (P) -> Int) {
    exportPropsYear(protokol, testYear)

    for (testMonth in 1..12) {
        val testPeriod = Period.getWithYearMonth(testYear, testMonth)
        val testResult: P = sut.getProps(testPeriod)
        var testValue: Int = func(testResult)
        exportPropsValue(protokol, testValue)
    }

    exportPropsEnd(protokol)
}

fun exportPropsValue(protokol: FileWriter, value: Int) {
    protokol.write("\t$value")
}

fun <B : IPropsProvider<P>, P : IProps>exportPropsDecFile(fileName : String, minYear: Int, maxYear: Int, sut: IProviderFactory<P>, func: (P) -> BigDecimal) {
    if (__test_protokol_file__) {
        var testProtokol = createProtokolFile(fileName)

        testProtokol.use {
            exportPropsStart(testProtokol)

            for (testYear in minYear..maxYear) {
                exportPropsDecLine<B, P>(testProtokol, testYear, sut, func)
            }
        }
    }
}

fun <B : IPropsProvider<P>, P : IProps>exportPropsDecLine(protokol: FileWriter, testYear: Int, sut: IProviderFactory<P>, func: (P) -> BigDecimal) {
    exportPropsYear(protokol, testYear)

    for (testMonth in 1..12) {
        val testPeriod = Period.getWithYearMonth(testYear, testMonth)
        val testResult: P = sut.getProps(testPeriod)
        var testValue: BigDecimal = func(testResult)
        exportPropsValue(protokol, testValue)
    }

    exportPropsEnd(protokol)
}

fun exportPropsValue(protokol: FileWriter, value: BigDecimal) {
    val intValue: Int = (value*100.toBigDecimal()).toInt()
    protokol.write("\t$intValue")
}

fun createProtokolFile(fileName : String): FileWriter {
    var currPath = Paths.get(".").toAbsolutePath()
    while (!currPath.endsWith(PARENT_PROTOKOL_FOLDER_NAME) || currPath.nameCount==1) {
        currPath = currPath.parent
    }
    val basePath = Paths.get(currPath.toString(), PROTOKOL_FOLDER_NAME)
    val path = Paths.get(basePath.toString(), fileName).toAbsolutePath().toString()
    return FileWriter(File(path))
}

fun exportPropsClose(protokol: FileWriter) {
    protokol.flush()
    protokol.close()
}

fun exportPropsStart(protokol: FileWriter) {
    protokol.write("")

    protokol.write("YEAR")
    for (testMonth in 1..12) {
        protokol.write("\t$testMonth")
    }
    protokol.write("\n")
}

fun exportPropsYear(protokol: FileWriter, value: Int) {
    protokol.write("$value")
}

fun exportPropsEnd(protokol: FileWriter) {
    protokol.write("\n")
}

