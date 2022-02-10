package org.hravemzdy.legalios.protokol

import org.hravemzdy.legalios.TestYearsScenario
import org.hravemzdy.legalios.factories.FactorySalary
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class ProtokolSalaryTest : Spek({
    // 02_Salary_01_WorkingShiftWeek
    describe("GetProps_ShouldExport_WorkingShiftWeek") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactorySalary()

                exportPropsIntFile("02_Salary_01_WorkingShiftWeek.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.workingShiftWeek }
            }
        }
    }
    // 02_Salary_02_WorkingShiftTime
    describe("GetProps_ShouldExport_WorkingShiftTime") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactorySalary()

                exportPropsIntFile("02_Salary_02_WorkingShiftTime.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.workingShiftTime }
            }
        }
    }
    // 02_Salary_03_MinMonthlyWage
    describe("GetProps_ShouldExport_MinMonthlyWage") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactorySalary()

                exportPropsIntFile("02_Salary_03_MinMonthlyWage.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.minMonthlyWage }
            }
        }
    }
    // 02_Salary_04_MinHourlyWage
    describe("GetProps_ShouldExport_MinHourlyWage") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactorySalary()

                exportPropsIntFile("02_Salary_04_MinHourlyWage.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.minHourlyWage }
            }
        }
    }
})

