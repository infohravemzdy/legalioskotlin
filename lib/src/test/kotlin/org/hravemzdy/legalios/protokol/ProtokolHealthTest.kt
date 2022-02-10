package org.hravemzdy.legalios.protokol

import org.hravemzdy.legalios.TestYearsScenario
import org.hravemzdy.legalios.factories.FactoryHealth
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class ProtokolHealthTest  : Spek({
    // 01_Health_01_MinMonthlyBasis
    describe("GetProps_ShouldExport_MinMonthlyBasis") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryHealth()

                exportPropsIntFile("01_Health_01_MinMonthlyBasis.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.minMonthlyBasis }
            }
        }
    }

    // 01_Health_02_MaxAnnualsBasis
    describe("GetProps_ShouldExport_MaxAnnualsBasis") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryHealth()

                exportPropsIntFile("01_Health_02_MaxAnnualsBasis.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.maxAnnualsBasis }
            }
         }
    }

    // 01_Health_03_LimMonthlyState
    describe("GetProps_ShouldExport_LimMonthlyState") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryHealth()

                exportPropsIntFile("01_Health_03_LimMonthlyState.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.limMonthlyState }
            }
        }
    }

    // 01_Health_04_LimMonthlyDis50
    describe("GetProps_ShouldExport_LimMonthlyDis50") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryHealth()

                exportPropsIntFile("01_Health_04_LimMonthlyDis50.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.limMonthlyDis50 }
            }
        }
    }

    // 01_Health_05_FactorCompound
    describe("GetProps_ShouldExport_FactorCompound") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryHealth()

                exportPropsDecFile("01_Health_05_FactorCompound.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.factorCompound }
            }
        }
    }

    // 01_Health_06_FactorEmployee
    describe("GetProps_ShouldExport_FactorEmployee") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryHealth()

                exportPropsDecFile("01_Health_06_FactorEmployee.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.factorEmployee }
            }
        }
    }

    // 01_Health_07_MarginIncomeEmp
    describe("GetProps_ShouldExport_MarginIncomeEmp") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryHealth()

                exportPropsIntFile("01_Health_07_MarginIncomeEmp.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.marginIncomeEmp }
            }
        }
    }

    // 01_Health_08_MarginIncomeAgr
    describe("GetProps_ShouldExport_MarginIncomeAgr") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryHealth()

                exportPropsIntFile("01_Health_08_MarginIncomeAgr.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.marginIncomeAgr }
            }
        }
    }
})

