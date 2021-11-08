package org.hravemzdy.legalios.protokol

import org.hravemzdy.legalios.factories.FactoryTaxing
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class ProtokolTaxingTest : Spek({
    data class TestIntScenario(val minYear: Int, val maxYear: Int)

    // 04_Taxing_01_AllowancePayer
    describe("GetProps_ShouldExport_AllowancePayer") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_01_AllowancePayer.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.allowancePayer }
            }
        }
    }
    // 04_Taxing_02_AllowanceDisab1st
    describe("GetProps_ShouldExport_AllowanceDisab1st") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_02_AllowanceDisab1st.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.allowanceDisab1st }
            }
        }
    }
    // 04_Taxing_03_AllowanceDisab2nd
    describe("GetProps_ShouldExport_AllowanceDisab2nd") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_03_AllowanceDisab2nd.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.allowanceDisab2nd }
            }
        }
    }
    // 04_Taxing_04_AllowanceDisab3rd
    describe("GetProps_ShouldExport_AllowanceDisab3rd") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_04_AllowanceDisab3rd.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.allowanceDisab3rd }
            }
        }
    }
    // 04_Taxing_05_AllowanceStudy
    describe("GetProps_ShouldExport_AllowanceStudy") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_05_AllowanceStudy.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.allowanceStudy }
            }
        }
    }
    // 04_Taxing_06_AllowanceChild1st
    describe("GetProps_ShouldExport_AllowanceChild1st") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_06_AllowanceChild1st.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.allowanceChild1st }
            }
        }
    }
    // 04_Taxing_07_AllowanceChild2nd
    describe("GetProps_ShouldExport_AllowanceChild2nd") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_07_AllowanceChild2nd.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.allowanceChild2nd }
            }
        }
    }
    // 04_Taxing_08_AllowanceChild3rd
    describe("GetProps_ShouldExport_AllowanceChild3rd") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_08_AllowanceChild3rd.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.allowanceChild3rd }
            }
        }
    }
    // 04_Taxing_09_FactorAdvances
    describe("GetProps_ShouldExport_FactorAdvances") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsDecFile("04_Taxing_09_FactorAdvances.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.factorAdvances }
            }
        }
    }
    // 04_Taxing_10_FactorWithhold
    describe("GetProps_ShouldExport_FactorWithhold") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsDecFile("04_Taxing_10_FactorWithhold.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.factorWithhold }
            }
        }
    }
    // 04_Taxing_11_FactorSolitary
    describe("GetProps_ShouldExport_FactorSolitary") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsDecFile("04_Taxing_11_FactorSolitary.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.factorSolitary }
            }
        }
    }
    // 04_Taxing_12_MinAmountOfTaxBonus
    describe("GetProps_ShouldExport_MinAmountOfTaxBonus") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_12_MinAmountOfTaxBonus.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.minAmountOfTaxBonus }
            }
        }
    }
    // 04_Taxing_13_MaxAmountOfTaxBonus
    describe("GetProps_ShouldExport_MaxAmountOfTaxBonus") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_13_MaxAmountOfTaxBonus.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.maxAmountOfTaxBonus }
            }
        }
    }
    // 04_Taxing_14_MarginIncomeOfTaxBonus
    describe("GetProps_ShouldExport_MarginIncomeOfTaxBonus") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_14_MarginIncomeOfTaxBonus.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.marginIncomeOfTaxBonus }
            }
        }
    }
    // 04_Taxing_15_MarginIncomeOfRounding
    describe("GetProps_ShouldExport_MarginIncomeOfRounding") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_15_MarginIncomeOfRounding.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.marginIncomeOfRounding }
            }
        }
    }
    // 04_Taxing_16_MarginIncomeOfWithhold
    describe("GetProps_ShouldExport_MarginIncomeOfWithhold") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_16_MarginIncomeOfWithhold.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.marginIncomeOfWithhold }
            }
        }
    }
    // 04_Taxing_17_MarginIncomeOfSolitary
    describe("GetProps_ShouldExport_MarginIncomeOfSolitary") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_17_MarginIncomeOfSolitary.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.marginIncomeOfSolitary }
            }
        }
    }
    // 04_Taxing_18_MarginIncomeOfWthEmp
    describe("GetProps_ShouldExport_MarginIncomeOfWthEmp") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_18_MarginIncomeOfWthEmp.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.marginIncomeOfWthEmp }
            }
        }
    }
    // 04_Taxing_19_MarginIncomeOfWthAgr
    describe("GetProps_ShouldExport_MarginIncomeOfWthAgr") {
        listOf(
            TestIntScenario(2011, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                val factory = FactoryTaxing()

                ExportPropsIntFile("04_Taxing_19_MarginIncomeOfWthAgr.txt",
                    tt.minYear, tt.maxYear, factory)
                    { prop -> prop.marginIncomeOfWthAgr }
            }
        }
    }
})

