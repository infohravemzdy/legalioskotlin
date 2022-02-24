package org.hravemzdy.legalios.history

import org.hravemzdy.legalios.TestYearsScenario
import org.hravemzdy.legalios.factories.*
import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.interfaces.IPropsSalary
import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.protokol.*
import org.hravemzdy.legalios.service.types.Period
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.io.File
import java.io.FileWriter
import java.math.BigDecimal
import java.nio.file.Paths

const val HISTORY_TEST_FOLDER = "../../../test_history"
const val HISTORY_FOLDER_NAME = "test_history"
const val PARENT_HISTORY_FOLDER_NAME = "legalios"

class FactoriesHistoryTest() : Spek({
    val _sutSalary : IProviderFactory<IPropsSalary> = FactorySalary()
    val _sutHealth : IProviderFactory<IPropsHealth> = FactoryHealth()
    val _sutSocial : IProviderFactory<IPropsSocial> = FactorySocial()
    val _sutTaxing : IProviderFactory<IPropsTaxing> = FactoryTaxing()

    describe("GetProps_ShouldExport_History") {
        listOf(
            TestYearsScenario(2010, 2022),
        ).forEach { tt ->
            it("GetProps should export values") {
                if (__test_protokol_file__) {
                    var testProtokol = createHistoryFile("history_${tt.minYear}_${tt.maxYear}.xls")

                    testProtokol.use {
                        var headerData = emptyList<Pair<Int, Boolean>>()
                        for (testYear in tt.minYear..tt.maxYear) {
                            var yearWithChanges = false

                            val testPeriod = Period(testYear, 1)

                            var testSalaryProp = _sutSalary.getProps(testPeriod)
                            var testHealthProp = _sutHealth.getProps(testPeriod)
                            var testSocialProp = _sutSocial.getProps(testPeriod)
                            var testTaxingProp = _sutTaxing.getProps(testPeriod)

                            for (testMonth in 2..12)
                            {
                                val nextPeriod = Period(testYear, testMonth)

                                val testSalaryNext = _sutSalary.getProps(nextPeriod)
                                val testHealthNext = _sutHealth.getProps(nextPeriod)
                                val testSocialNext = _sutSocial.getProps(nextPeriod)
                                val testTaxingNext = _sutTaxing.getProps(nextPeriod)

                                if (testSalaryNext.valueEquals(testSalaryProp) == false)
                                {
                                    yearWithChanges = true
                                }
                                if (testHealthNext.valueEquals(testHealthProp) == false)
                                {
                                    yearWithChanges = true
                                }
                                if (testSocialNext.valueEquals(testSocialProp) == false)
                                {
                                    yearWithChanges = true
                                }
                                if (testTaxingNext.valueEquals(testTaxingProp) == false)
                                {
                                    yearWithChanges = true
                                }
                                testSalaryProp = testSalaryNext
                                testHealthProp = testHealthNext
                                testSocialProp = testSocialNext
                                testTaxingProp = testTaxingNext
                            }
                            headerData = headerData.plus(Pair<Int, Boolean>(testYear, yearWithChanges))
                        }
                        exportHistoryStart(testProtokol, headerData)

                        val VECT_HEALTH_MIN_MONTHLY_BASIS = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_HEALTH_MAX_ANNUALS_BASIS = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_HEALTH_LIM_MONTHLY_STATE = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_HEALTH_LIM_MONTHLY_DIS50 = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_HEALTH_FACTOR_COMPOUND = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_HEALTH_FACTOR_EMPLOYEE = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_HEALTH_MARGIN_INCOME_EMP = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_HEALTH_MARGIN_INCOME_AGR = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SALARY_WORKING_SHIFT_WEEK = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SALARY_WORKING_SHIFT_TIME = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SALARY_MIN_MONTHLY_WAGE = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SALARY_MIN_HOURLY_WAGE = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SOCIAL_MAX_ANNUALS_BASIS = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SOCIAL_FACTOR_EMPLOYER = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SOCIAL_FACTOR_EMPLOYER_HIGHER = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SOCIAL_FACTOR_EMPLOYEE = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SOCIAL_FACTOR_EMPLOYEE_GARANT = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SOCIAL_FACTOR_EMPLOYEE_REDUCE = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SOCIAL_MARGIN_INCOME_EMP = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_SOCIAL_MARGIN_INCOME_AGR = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_ALLOWANCE_PAYER = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_ALLOWANCE_DISAB_1ST = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_ALLOWANCE_DISAB_2ND = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_ALLOWANCE_DISAB_3RD = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_ALLOWANCE_STUDY = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_ALLOWANCE_CHILD_1ST = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_ALLOWANCE_CHILD_2ND = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_ALLOWANCE_CHILD_3RD = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_FACTOR_ADVANCES = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_FACTOR_WITHHOLD = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_FACTOR_SOLIDARY = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_FACTOR_TAXRATE2 = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_MIN_AMOUNT_OF_TAXBONUS = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_MAX_AMOUNT_OF_TAXBONUS = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_MARGIN_INCOME_OF_TAXBONUS = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_MARGIN_INCOME_OF_ROUNDING = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_MARGIN_INCOME_OF_WITHHOLD = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_MARGIN_INCOME_OF_SOLIDARY = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_MARGIN_INCOME_OF_TAXRATE2 = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_MARGIN_INCOME_OF_WHT_EMP = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()
                        val VECT_TAXING_MARGIN_INCOME_OF_WHT_AGR = mutableListOf<Pair<Pair<Int, Int>, Pair<String, String>>>()

                        for (testYear in tt.minYear..tt.maxYear) {
                            var MES_HEALTH_MIN_MONTHLY_BASIS         = 0
                            var MES_HEALTH_MAX_ANNUALS_BASIS         = 0
                            var MES_HEALTH_LIM_MONTHLY_STATE         = 0
                            var MES_HEALTH_LIM_MONTHLY_DIS50         = 0
                            var MES_HEALTH_FACTOR_COMPOUND           = 0
                            var MES_HEALTH_FACTOR_EMPLOYEE           = 0
                            var MES_HEALTH_MARGIN_INCOME_EMP         = 0
                            var MES_HEALTH_MARGIN_INCOME_AGR         = 0
                            var MES_SALARY_WORKING_SHIFT_WEEK        = 0
                            var MES_SALARY_WORKING_SHIFT_TIME        = 0
                            var MES_SALARY_MIN_MONTHLY_WAGE          = 0
                            var MES_SALARY_MIN_HOURLY_WAGE           = 0
                            var MES_SOCIAL_MAX_ANNUALS_BASIS         = 0
                            var MES_SOCIAL_FACTOR_EMPLOYER           = 0
                            var MES_SOCIAL_FACTOR_EMPLOYER_HIGHER    = 0
                            var MES_SOCIAL_FACTOR_EMPLOYEE           = 0
                            var MES_SOCIAL_FACTOR_EMPLOYEE_GARANT    = 0
                            var MES_SOCIAL_FACTOR_EMPLOYEE_REDUCE    = 0
                            var MES_SOCIAL_MARGIN_INCOME_EMP         = 0
                            var MES_SOCIAL_MARGIN_INCOME_AGR         = 0
                            var MES_TAXING_ALLOWANCE_PAYER           = 0
                            var MES_TAXING_ALLOWANCE_DISAB_1ST       = 0
                            var MES_TAXING_ALLOWANCE_DISAB_2ND       = 0
                            var MES_TAXING_ALLOWANCE_DISAB_3RD       = 0
                            var MES_TAXING_ALLOWANCE_STUDY           = 0
                            var MES_TAXING_ALLOWANCE_CHILD_1ST       = 0
                            var MES_TAXING_ALLOWANCE_CHILD_2ND       = 0
                            var MES_TAXING_ALLOWANCE_CHILD_3RD       = 0
                            var MES_TAXING_FACTOR_ADVANCES           = 0
                            var MES_TAXING_FACTOR_WITHHOLD           = 0
                            var MES_TAXING_FACTOR_SOLIDARY           = 0
                            var MES_TAXING_FACTOR_TAXRATE2           = 0
                            var MES_TAXING_MIN_AMOUNT_OF_TAXBONUS    = 0
                            var MES_TAXING_MAX_AMOUNT_OF_TAXBONUS    = 0
                            var MES_TAXING_MARGIN_INCOME_OF_TAXBONUS = 0
                            var MES_TAXING_MARGIN_INCOME_OF_ROUNDING = 0
                            var MES_TAXING_MARGIN_INCOME_OF_WITHHOLD = 0
                            var MES_TAXING_MARGIN_INCOME_OF_SOLIDARY = 0
                            var MES_TAXING_MARGIN_INCOME_OF_TAXRATE2 = 0
                            var MES_TAXING_MARGIN_INCOME_OF_WHT_EMP  = 0
                            var MES_TAXING_MARGIN_INCOME_OF_WHT_AGR  = 0

                            val testPeriod = Period(testYear, 1)

                            var testSalaryProp = _sutSalary.getProps(testPeriod)
                            var testHealthProp = _sutHealth.getProps(testPeriod)
                            var testSocialProp = _sutSocial.getProps(testPeriod)
                            var testTaxingProp = _sutTaxing.getProps(testPeriod)

                            val JAN_HEALTH_MIN_MONTHLY_BASIS         = propsValueToString(testHealthProp.minMonthlyBasis)
                            val JAN_HEALTH_MAX_ANNUALS_BASIS         = propsValueToString(testHealthProp.maxAnnualsBasis)
                            val JAN_HEALTH_LIM_MONTHLY_STATE         = propsValueToString(testHealthProp.limMonthlyState)
                            val JAN_HEALTH_LIM_MONTHLY_DIS50         = propsValueToString(testHealthProp.limMonthlyDis50)
                            val JAN_HEALTH_FACTOR_COMPOUND           = propsValueToString(testHealthProp.factorCompound )
                            val JAN_HEALTH_FACTOR_EMPLOYEE           = propsValueToString(testHealthProp.factorEmployee )
                            val JAN_HEALTH_MARGIN_INCOME_EMP         = propsValueToString(testHealthProp.marginIncomeEmp)
                            val JAN_HEALTH_MARGIN_INCOME_AGR         = propsValueToString(testHealthProp.marginIncomeAgr)
                            val JAN_SALARY_WORKING_SHIFT_WEEK        = propsValueToString(testSalaryProp.workingShiftWeek)
                            val JAN_SALARY_WORKING_SHIFT_TIME        = propsValueToString(testSalaryProp.workingShiftTime)
                            val JAN_SALARY_MIN_MONTHLY_WAGE          = propsValueToString(testSalaryProp.minMonthlyWage)
                            val JAN_SALARY_MIN_HOURLY_WAGE           = propsValueToString(testSalaryProp.minHourlyWage  )
                            val JAN_SOCIAL_MAX_ANNUALS_BASIS         = propsValueToString(testSocialProp.maxAnnualsBasis)
                            val JAN_SOCIAL_FACTOR_EMPLOYER           = propsValueToString(testSocialProp.factorEmployer)
                            val JAN_SOCIAL_FACTOR_EMPLOYER_HIGHER    = propsValueToString(testSocialProp.factorEmployerHigher)
                            val JAN_SOCIAL_FACTOR_EMPLOYEE           = propsValueToString(testSocialProp.factorEmployee)
                            val JAN_SOCIAL_FACTOR_EMPLOYEE_GARANT    = propsValueToString(testSocialProp.factorEmployeeGarant)
                            val JAN_SOCIAL_FACTOR_EMPLOYEE_REDUCE    = propsValueToString(testSocialProp.factorEmployeeReduce)
                            val JAN_SOCIAL_MARGIN_INCOME_EMP         = propsValueToString(testSocialProp.marginIncomeEmp)
                            val JAN_SOCIAL_MARGIN_INCOME_AGR         = propsValueToString(testSocialProp.marginIncomeAgr)
                            val JAN_TAXING_ALLOWANCE_PAYER           = propsValueToString(testTaxingProp.allowancePayer)
                            val JAN_TAXING_ALLOWANCE_DISAB_1ST       = propsValueToString(testTaxingProp.allowanceDisab1st )
                            val JAN_TAXING_ALLOWANCE_DISAB_2ND       = propsValueToString(testTaxingProp.allowanceDisab2nd )
                            val JAN_TAXING_ALLOWANCE_DISAB_3RD       = propsValueToString(testTaxingProp.allowanceDisab3rd )
                            val JAN_TAXING_ALLOWANCE_STUDY           = propsValueToString(testTaxingProp.allowanceStudy )
                            val JAN_TAXING_ALLOWANCE_CHILD_1ST       = propsValueToString(testTaxingProp.allowanceChild1st )
                            val JAN_TAXING_ALLOWANCE_CHILD_2ND       = propsValueToString(testTaxingProp.allowanceChild2nd )
                            val JAN_TAXING_ALLOWANCE_CHILD_3RD       = propsValueToString(testTaxingProp.allowanceChild3rd )
                            val JAN_TAXING_FACTOR_ADVANCES           = propsValueToString(testTaxingProp.factorAdvances )
                            val JAN_TAXING_FACTOR_WITHHOLD           = propsValueToString(testTaxingProp.factorWithhold )
                            val JAN_TAXING_FACTOR_SOLIDARY           = propsValueToString(testTaxingProp.factorSolidary )
                            val JAN_TAXING_FACTOR_TAXRATE2           = propsValueToString(testTaxingProp.factorTaxRate2 )
                            val JAN_TAXING_MIN_AMOUNT_OF_TAXBONUS    = propsValueToString(testTaxingProp.minAmountOfTaxBonus )
                            val JAN_TAXING_MAX_AMOUNT_OF_TAXBONUS    = propsValueToString(testTaxingProp.maxAmountOfTaxBonus )
                            val JAN_TAXING_MARGIN_INCOME_OF_TAXBONUS = propsValueToString(testTaxingProp.marginIncomeOfTaxBonus )
                            val JAN_TAXING_MARGIN_INCOME_OF_ROUNDING = propsValueToString(testTaxingProp.marginIncomeOfRounding )
                            val JAN_TAXING_MARGIN_INCOME_OF_WITHHOLD = propsValueToString(testTaxingProp.marginIncomeOfWithhold )
                            val JAN_TAXING_MARGIN_INCOME_OF_SOLIDARY = propsValueToString(testTaxingProp.marginIncomeOfSolidary )
                            val JAN_TAXING_MARGIN_INCOME_OF_TAXRATE2 = propsValueToString(testTaxingProp.marginIncomeOfTaxRate2 )
                            val JAN_TAXING_MARGIN_INCOME_OF_WHT_EMP  = propsValueToString(testTaxingProp.marginIncomeOfWthEmp )
                            val JAN_TAXING_MARGIN_INCOME_OF_WHT_AGR  = propsValueToString(testTaxingProp.marginIncomeOfWthAgr )

                            for (testMonth in 2..12)
                            {
                                val nextPeriod = Period(testYear, testMonth)

                                val testSalaryNext = _sutSalary.getProps(nextPeriod)
                                val testHealthNext = _sutHealth.getProps(nextPeriod)
                                val testSocialNext = _sutSocial.getProps(nextPeriod)
                                val testTaxingNext = _sutTaxing.getProps(nextPeriod)

                                if (testHealthNext.minMonthlyBasis.equals(testHealthProp.minMonthlyBasis)==false) { MES_HEALTH_MIN_MONTHLY_BASIS = testMonth }
                                if (testHealthNext.maxAnnualsBasis.equals(testHealthProp.maxAnnualsBasis)==false) { MES_HEALTH_MAX_ANNUALS_BASIS = testMonth }
                                if (testHealthNext.limMonthlyState.equals(testHealthProp.limMonthlyState)==false) { MES_HEALTH_LIM_MONTHLY_STATE = testMonth }
                                if (testHealthNext.limMonthlyDis50.equals(testHealthProp.limMonthlyDis50)==false) { MES_HEALTH_LIM_MONTHLY_DIS50 = testMonth }
                                if (testHealthNext.factorCompound.equals(testHealthProp.factorCompound)==false) { MES_HEALTH_FACTOR_COMPOUND = testMonth }
                                if (testHealthNext.factorEmployee.equals(testHealthProp.factorEmployee)==false) { MES_HEALTH_FACTOR_EMPLOYEE = testMonth }
                                if (testHealthNext.marginIncomeEmp.equals(testHealthProp.marginIncomeEmp)==false) { MES_HEALTH_MARGIN_INCOME_EMP = testMonth }
                                if (testHealthNext.marginIncomeAgr.equals(testHealthProp.marginIncomeAgr)==false) { MES_HEALTH_MARGIN_INCOME_AGR = testMonth }
                                if (testSalaryNext.workingShiftWeek.equals(testSalaryProp.workingShiftWeek)==false) { MES_SALARY_WORKING_SHIFT_WEEK = testMonth }
                                if (testSalaryNext.workingShiftTime.equals(testSalaryProp.workingShiftTime)==false) { MES_SALARY_WORKING_SHIFT_TIME = testMonth }
                                if (testSalaryNext.minMonthlyWage.equals(testSalaryProp.minMonthlyWage)==false) { MES_SALARY_MIN_MONTHLY_WAGE = testMonth }
                                if (testSalaryNext.minHourlyWage .equals(testSalaryProp.minHourlyWage)==false) { MES_SALARY_MIN_HOURLY_WAGE = testMonth }
                                if (testSocialNext.maxAnnualsBasis.equals(testSocialProp.maxAnnualsBasis)==false) { MES_SOCIAL_MAX_ANNUALS_BASIS = testMonth }
                                if (testSocialNext.factorEmployer.equals(testSocialProp.factorEmployer)==false) { MES_SOCIAL_FACTOR_EMPLOYER = testMonth }
                                if (testSocialNext.factorEmployerHigher.equals(testSocialProp.factorEmployerHigher)==false) { MES_SOCIAL_FACTOR_EMPLOYER_HIGHER = testMonth }
                                if (testSocialNext.factorEmployee.equals(testSocialProp.factorEmployee)==false) { MES_SOCIAL_FACTOR_EMPLOYEE = testMonth }
                                if (testSocialNext.factorEmployeeReduce.equals(testSocialProp.factorEmployeeReduce) == false) { MES_SOCIAL_FACTOR_EMPLOYEE_REDUCE = testMonth }
                                if (testSocialNext.factorEmployeeGarant.equals(testSocialProp.factorEmployeeGarant)==false) { MES_SOCIAL_FACTOR_EMPLOYEE_GARANT = testMonth }
                                if (testSocialNext.marginIncomeEmp.equals(testSocialProp.marginIncomeEmp)==false) { MES_SOCIAL_MARGIN_INCOME_EMP = testMonth }
                                if (testSocialNext.marginIncomeAgr.equals(testSocialProp.marginIncomeAgr)==false) { MES_SOCIAL_MARGIN_INCOME_AGR = testMonth }
                                if (testTaxingNext.allowancePayer.equals(testTaxingProp.allowancePayer)==false) { MES_TAXING_ALLOWANCE_PAYER = testMonth }
                                if (testTaxingNext.allowanceDisab1st.equals(testTaxingProp.allowanceDisab1st)==false) { MES_TAXING_ALLOWANCE_DISAB_1ST = testMonth }
                                if (testTaxingNext.allowanceDisab2nd.equals(testTaxingProp.allowanceDisab2nd)==false) { MES_TAXING_ALLOWANCE_DISAB_2ND = testMonth }
                                if (testTaxingNext.allowanceDisab3rd.equals(testTaxingProp.allowanceDisab3rd)==false) { MES_TAXING_ALLOWANCE_DISAB_3RD = testMonth }
                                if (testTaxingNext.allowanceStudy.equals(testTaxingProp.allowanceStudy)==false) { MES_TAXING_ALLOWANCE_STUDY = testMonth }
                                if (testTaxingNext.allowanceChild1st.equals(testTaxingProp.allowanceChild1st)==false) { MES_TAXING_ALLOWANCE_CHILD_1ST = testMonth }
                                if (testTaxingNext.allowanceChild2nd.equals(testTaxingProp.allowanceChild2nd)==false) { MES_TAXING_ALLOWANCE_CHILD_2ND = testMonth }
                                if (testTaxingNext.allowanceChild3rd.equals(testTaxingProp.allowanceChild3rd)==false) { MES_TAXING_ALLOWANCE_CHILD_3RD = testMonth }
                                if (testTaxingNext.factorAdvances.equals(testTaxingProp.factorAdvances)==false) { MES_TAXING_FACTOR_ADVANCES = testMonth }
                                if (testTaxingNext.factorWithhold.equals(testTaxingProp.factorWithhold)==false) { MES_TAXING_FACTOR_WITHHOLD = testMonth }
                                if (testTaxingNext.factorSolidary.equals(testTaxingProp.factorSolidary)==false) { MES_TAXING_FACTOR_SOLIDARY = testMonth }
                                if (testTaxingNext.factorTaxRate2.equals(testTaxingProp.factorTaxRate2)==false) { MES_TAXING_FACTOR_TAXRATE2 = testMonth }
                                if (testTaxingNext.minAmountOfTaxBonus.equals(testTaxingProp.minAmountOfTaxBonus)==false) { MES_TAXING_MIN_AMOUNT_OF_TAXBONUS = testMonth }
                                if (testTaxingNext.maxAmountOfTaxBonus.equals(testTaxingProp.maxAmountOfTaxBonus)==false) { MES_TAXING_MAX_AMOUNT_OF_TAXBONUS = testMonth }
                                if (testTaxingNext.marginIncomeOfTaxBonus.equals(testTaxingProp.marginIncomeOfTaxBonus)==false) { MES_TAXING_MARGIN_INCOME_OF_TAXBONUS = testMonth }
                                if (testTaxingNext.marginIncomeOfRounding.equals(testTaxingProp.marginIncomeOfRounding)==false) { MES_TAXING_MARGIN_INCOME_OF_ROUNDING = testMonth }
                                if (testTaxingNext.marginIncomeOfWithhold.equals(testTaxingProp.marginIncomeOfWithhold)==false) { MES_TAXING_MARGIN_INCOME_OF_WITHHOLD = testMonth }
                                if (testTaxingNext.marginIncomeOfSolidary.equals(testTaxingProp.marginIncomeOfSolidary)==false) { MES_TAXING_MARGIN_INCOME_OF_SOLIDARY = testMonth }
                                if (testTaxingNext.marginIncomeOfTaxRate2.equals(testTaxingProp.marginIncomeOfTaxRate2)==false) { MES_TAXING_MARGIN_INCOME_OF_TAXRATE2 = testMonth }
                                if (testTaxingNext.marginIncomeOfWthEmp.equals(testTaxingProp.marginIncomeOfWthEmp)==false) { MES_TAXING_MARGIN_INCOME_OF_WHT_EMP = testMonth }
                                if (testTaxingNext.marginIncomeOfWthAgr.equals(testTaxingProp.marginIncomeOfWthAgr)==false) { MES_TAXING_MARGIN_INCOME_OF_WHT_AGR = testMonth }

                                testSalaryProp = testSalaryNext
                                testHealthProp = testHealthNext
                                testSocialProp = testSocialNext
                                testTaxingProp = testTaxingNext
                            }

                            VECT_HEALTH_MIN_MONTHLY_BASIS.add(Pair(Pair(testYear, MES_HEALTH_MIN_MONTHLY_BASIS), Pair(JAN_HEALTH_MIN_MONTHLY_BASIS, propsValueToString(testHealthProp.minMonthlyBasis))))
                            VECT_HEALTH_MAX_ANNUALS_BASIS.add(Pair(Pair(testYear, MES_HEALTH_MAX_ANNUALS_BASIS), Pair(JAN_HEALTH_MAX_ANNUALS_BASIS, propsValueToString(testHealthProp.maxAnnualsBasis))))
                            VECT_HEALTH_LIM_MONTHLY_STATE.add(Pair(Pair(testYear, MES_HEALTH_LIM_MONTHLY_STATE), Pair(JAN_HEALTH_LIM_MONTHLY_STATE, propsValueToString(testHealthProp.limMonthlyState))))
                            VECT_HEALTH_LIM_MONTHLY_DIS50.add(Pair(Pair(testYear, MES_HEALTH_LIM_MONTHLY_DIS50), Pair(JAN_HEALTH_LIM_MONTHLY_DIS50, propsValueToString(testHealthProp.limMonthlyDis50))))
                            VECT_HEALTH_FACTOR_COMPOUND.add(Pair(Pair(testYear, MES_HEALTH_FACTOR_COMPOUND), Pair(JAN_HEALTH_FACTOR_COMPOUND, propsValueToString(testHealthProp.factorCompound))))
                            VECT_HEALTH_FACTOR_EMPLOYEE.add(Pair(Pair(testYear, MES_HEALTH_FACTOR_EMPLOYEE), Pair(JAN_HEALTH_FACTOR_EMPLOYEE, propsValueToString(testHealthProp.factorEmployee))))
                            VECT_HEALTH_MARGIN_INCOME_EMP.add(Pair(Pair(testYear, MES_HEALTH_MARGIN_INCOME_EMP), Pair(JAN_HEALTH_MARGIN_INCOME_EMP, propsValueToString(testHealthProp.marginIncomeEmp))))
                            VECT_HEALTH_MARGIN_INCOME_AGR.add(Pair(Pair(testYear, MES_HEALTH_MARGIN_INCOME_AGR), Pair(JAN_HEALTH_MARGIN_INCOME_AGR, propsValueToString(testHealthProp.marginIncomeAgr))))
                            VECT_SALARY_WORKING_SHIFT_WEEK.add(Pair(Pair(testYear, MES_SALARY_WORKING_SHIFT_WEEK), Pair(JAN_SALARY_WORKING_SHIFT_WEEK, propsValueToString(testSalaryProp.workingShiftWeek))))
                            VECT_SALARY_WORKING_SHIFT_TIME.add(Pair(Pair(testYear, MES_SALARY_WORKING_SHIFT_TIME), Pair(JAN_SALARY_WORKING_SHIFT_TIME, propsValueToString(testSalaryProp.workingShiftTime))))
                            VECT_SALARY_MIN_MONTHLY_WAGE.add(Pair(Pair(testYear, MES_SALARY_MIN_MONTHLY_WAGE), Pair(JAN_SALARY_MIN_MONTHLY_WAGE, propsValueToString(testSalaryProp.minMonthlyWage))))
                            VECT_SALARY_MIN_HOURLY_WAGE.add(Pair(Pair(testYear, MES_SALARY_MIN_HOURLY_WAGE), Pair(JAN_SALARY_MIN_HOURLY_WAGE, propsValueToString(testSalaryProp.minHourlyWage))))
                            VECT_SOCIAL_MAX_ANNUALS_BASIS.add(Pair(Pair(testYear, MES_SOCIAL_MAX_ANNUALS_BASIS), Pair(JAN_SOCIAL_MAX_ANNUALS_BASIS, propsValueToString(testSocialProp.maxAnnualsBasis))))
                            VECT_SOCIAL_FACTOR_EMPLOYER.add(Pair(Pair(testYear, MES_SOCIAL_FACTOR_EMPLOYER), Pair(JAN_SOCIAL_FACTOR_EMPLOYER, propsValueToString(testSocialProp.factorEmployer))))
                            VECT_SOCIAL_FACTOR_EMPLOYER_HIGHER.add(Pair(Pair(testYear, MES_SOCIAL_FACTOR_EMPLOYER_HIGHER), Pair(JAN_SOCIAL_FACTOR_EMPLOYER_HIGHER, propsValueToString(testSocialProp.factorEmployerHigher))))
                            VECT_SOCIAL_FACTOR_EMPLOYEE.add(Pair(Pair(testYear, MES_SOCIAL_FACTOR_EMPLOYEE), Pair(JAN_SOCIAL_FACTOR_EMPLOYEE, propsValueToString(testSocialProp.factorEmployee))))
                            VECT_SOCIAL_FACTOR_EMPLOYEE_GARANT.add(Pair(Pair(testYear, MES_SOCIAL_FACTOR_EMPLOYEE_GARANT), Pair(JAN_SOCIAL_FACTOR_EMPLOYEE_GARANT, propsValueToString(testSocialProp.factorEmployeeGarant))))
                            VECT_SOCIAL_FACTOR_EMPLOYEE_REDUCE.add(Pair(Pair(testYear, MES_SOCIAL_FACTOR_EMPLOYEE_REDUCE), Pair(JAN_SOCIAL_FACTOR_EMPLOYEE_REDUCE, propsValueToString(testSocialProp.factorEmployeeReduce))))
                            VECT_SOCIAL_MARGIN_INCOME_EMP.add(Pair(Pair(testYear, MES_SOCIAL_MARGIN_INCOME_EMP), Pair(JAN_SOCIAL_MARGIN_INCOME_EMP, propsValueToString(testSocialProp.marginIncomeEmp))))
                            VECT_SOCIAL_MARGIN_INCOME_AGR.add(Pair(Pair(testYear, MES_SOCIAL_MARGIN_INCOME_AGR), Pair(JAN_SOCIAL_MARGIN_INCOME_AGR, propsValueToString(testSocialProp.marginIncomeAgr))))
                            VECT_TAXING_ALLOWANCE_PAYER.add(Pair(Pair(testYear, MES_TAXING_ALLOWANCE_PAYER), Pair(JAN_TAXING_ALLOWANCE_PAYER, propsValueToString(testTaxingProp.allowancePayer))))
                            VECT_TAXING_ALLOWANCE_DISAB_1ST.add(Pair(Pair(testYear, MES_TAXING_ALLOWANCE_DISAB_1ST), Pair(JAN_TAXING_ALLOWANCE_DISAB_1ST, propsValueToString(testTaxingProp.allowanceDisab1st))))
                            VECT_TAXING_ALLOWANCE_DISAB_2ND.add(Pair(Pair(testYear, MES_TAXING_ALLOWANCE_DISAB_2ND), Pair(JAN_TAXING_ALLOWANCE_DISAB_2ND, propsValueToString(testTaxingProp.allowanceDisab2nd))))
                            VECT_TAXING_ALLOWANCE_DISAB_3RD.add(Pair(Pair(testYear, MES_TAXING_ALLOWANCE_DISAB_3RD), Pair(JAN_TAXING_ALLOWANCE_DISAB_3RD, propsValueToString(testTaxingProp.allowanceDisab3rd))))
                            VECT_TAXING_ALLOWANCE_STUDY.add(Pair(Pair(testYear, MES_TAXING_ALLOWANCE_STUDY), Pair(JAN_TAXING_ALLOWANCE_STUDY, propsValueToString(testTaxingProp.allowanceStudy))))
                            VECT_TAXING_ALLOWANCE_CHILD_1ST.add(Pair(Pair(testYear, MES_TAXING_ALLOWANCE_CHILD_1ST), Pair(JAN_TAXING_ALLOWANCE_CHILD_1ST, propsValueToString(testTaxingProp.allowanceChild1st))))
                            VECT_TAXING_ALLOWANCE_CHILD_2ND.add(Pair(Pair(testYear, MES_TAXING_ALLOWANCE_CHILD_2ND), Pair(JAN_TAXING_ALLOWANCE_CHILD_2ND, propsValueToString(testTaxingProp.allowanceChild2nd))))
                            VECT_TAXING_ALLOWANCE_CHILD_3RD.add(Pair(Pair(testYear, MES_TAXING_ALLOWANCE_CHILD_3RD), Pair(JAN_TAXING_ALLOWANCE_CHILD_3RD, propsValueToString(testTaxingProp.allowanceChild3rd))))
                            VECT_TAXING_FACTOR_ADVANCES.add(Pair(Pair(testYear, MES_TAXING_FACTOR_ADVANCES), Pair(JAN_TAXING_FACTOR_ADVANCES, propsValueToString(testTaxingProp.factorAdvances))))
                            VECT_TAXING_FACTOR_WITHHOLD.add(Pair(Pair(testYear, MES_TAXING_FACTOR_WITHHOLD), Pair(JAN_TAXING_FACTOR_WITHHOLD, propsValueToString(testTaxingProp.factorWithhold))))
                            VECT_TAXING_FACTOR_SOLIDARY.add(Pair(Pair(testYear, MES_TAXING_FACTOR_SOLIDARY), Pair(JAN_TAXING_FACTOR_SOLIDARY, propsValueToString(testTaxingProp.factorSolidary))))
                            VECT_TAXING_FACTOR_TAXRATE2.add(Pair(Pair(testYear, MES_TAXING_FACTOR_TAXRATE2), Pair(JAN_TAXING_FACTOR_TAXRATE2, propsValueToString(testTaxingProp.factorTaxRate2))))
                            VECT_TAXING_MIN_AMOUNT_OF_TAXBONUS.add(Pair(Pair(testYear, MES_TAXING_MIN_AMOUNT_OF_TAXBONUS), Pair(JAN_TAXING_MIN_AMOUNT_OF_TAXBONUS, propsValueToString(testTaxingProp.minAmountOfTaxBonus))))
                            VECT_TAXING_MAX_AMOUNT_OF_TAXBONUS.add(Pair(Pair(testYear, MES_TAXING_MAX_AMOUNT_OF_TAXBONUS), Pair(JAN_TAXING_MAX_AMOUNT_OF_TAXBONUS, propsValueToString(testTaxingProp.maxAmountOfTaxBonus))))
                            VECT_TAXING_MARGIN_INCOME_OF_TAXBONUS.add(Pair(Pair(testYear, MES_TAXING_MARGIN_INCOME_OF_TAXBONUS), Pair(JAN_TAXING_MARGIN_INCOME_OF_TAXBONUS, propsValueToString(testTaxingProp.marginIncomeOfTaxBonus))))
                            VECT_TAXING_MARGIN_INCOME_OF_ROUNDING.add(Pair(Pair(testYear, MES_TAXING_MARGIN_INCOME_OF_ROUNDING), Pair(JAN_TAXING_MARGIN_INCOME_OF_ROUNDING, propsValueToString(testTaxingProp.marginIncomeOfRounding))))
                            VECT_TAXING_MARGIN_INCOME_OF_WITHHOLD.add(Pair(Pair(testYear, MES_TAXING_MARGIN_INCOME_OF_WITHHOLD), Pair(JAN_TAXING_MARGIN_INCOME_OF_WITHHOLD, propsValueToString(testTaxingProp.marginIncomeOfWithhold))))
                            VECT_TAXING_MARGIN_INCOME_OF_SOLIDARY.add(Pair(Pair(testYear, MES_TAXING_MARGIN_INCOME_OF_SOLIDARY), Pair(JAN_TAXING_MARGIN_INCOME_OF_SOLIDARY, propsValueToString(testTaxingProp.marginIncomeOfSolidary))))
                            VECT_TAXING_MARGIN_INCOME_OF_TAXRATE2.add(Pair(Pair(testYear, MES_TAXING_MARGIN_INCOME_OF_TAXRATE2), Pair(JAN_TAXING_MARGIN_INCOME_OF_TAXRATE2, propsValueToString(testTaxingProp.marginIncomeOfTaxRate2))))
                            VECT_TAXING_MARGIN_INCOME_OF_WHT_EMP.add(Pair(Pair(testYear, MES_TAXING_MARGIN_INCOME_OF_WHT_EMP), Pair(JAN_TAXING_MARGIN_INCOME_OF_WHT_EMP, propsValueToString(testTaxingProp.marginIncomeOfWthEmp))))
                            VECT_TAXING_MARGIN_INCOME_OF_WHT_AGR.add(Pair(Pair(testYear, MES_TAXING_MARGIN_INCOME_OF_WHT_AGR), Pair(JAN_TAXING_MARGIN_INCOME_OF_WHT_AGR, propsValueToString(testTaxingProp.marginIncomeOfWthAgr))))
                        }

                        val tableData = mutableListOf(
                            Pair(HEALTH_MIN_MONTHLY_BASIS         , VECT_HEALTH_MIN_MONTHLY_BASIS),
                            Pair(HEALTH_MAX_ANNUALS_BASIS         , VECT_HEALTH_MAX_ANNUALS_BASIS),
                            Pair(HEALTH_LIM_MONTHLY_STATE         , VECT_HEALTH_LIM_MONTHLY_STATE),
                            Pair(HEALTH_LIM_MONTHLY_DIS50         , VECT_HEALTH_LIM_MONTHLY_DIS50),
                            Pair(HEALTH_FACTOR_COMPOUND           , VECT_HEALTH_FACTOR_COMPOUND),
                            Pair(HEALTH_FACTOR_EMPLOYEE           , VECT_HEALTH_FACTOR_EMPLOYEE),
                            Pair(HEALTH_MARGIN_INCOME_EMP         , VECT_HEALTH_MARGIN_INCOME_EMP),
                            Pair(HEALTH_MARGIN_INCOME_AGR         , VECT_HEALTH_MARGIN_INCOME_AGR),
                            Pair(SALARY_WORKING_SHIFT_WEEK        , VECT_SALARY_WORKING_SHIFT_WEEK),
                            Pair(SALARY_WORKING_SHIFT_TIME        , VECT_SALARY_WORKING_SHIFT_TIME),
                            Pair(SALARY_MIN_MONTHLY_WAGE          , VECT_SALARY_MIN_MONTHLY_WAGE),
                            Pair(SALARY_MIN_HOURLY_WAGE           , VECT_SALARY_MIN_HOURLY_WAGE),
                            Pair(SOCIAL_MAX_ANNUALS_BASIS         , VECT_SOCIAL_MAX_ANNUALS_BASIS),
                            Pair(SOCIAL_FACTOR_EMPLOYER           , VECT_SOCIAL_FACTOR_EMPLOYER),
                            Pair(SOCIAL_FACTOR_EMPLOYER_HIGHER    , VECT_SOCIAL_FACTOR_EMPLOYER_HIGHER),
                            Pair(SOCIAL_FACTOR_EMPLOYEE           , VECT_SOCIAL_FACTOR_EMPLOYEE),
                            Pair(SOCIAL_FACTOR_EMPLOYEE_GARANT    , VECT_SOCIAL_FACTOR_EMPLOYEE_GARANT),
                            Pair(SOCIAL_FACTOR_EMPLOYEE_REDUCE    , VECT_SOCIAL_FACTOR_EMPLOYEE_REDUCE),
                            Pair(SOCIAL_MARGIN_INCOME_EMP         , VECT_SOCIAL_MARGIN_INCOME_EMP),
                            Pair(SOCIAL_MARGIN_INCOME_AGR         , VECT_SOCIAL_MARGIN_INCOME_AGR),
                            Pair(TAXING_ALLOWANCE_PAYER           , VECT_TAXING_ALLOWANCE_PAYER),
                            Pair(TAXING_ALLOWANCE_DISAB_1ST       , VECT_TAXING_ALLOWANCE_DISAB_1ST),
                            Pair(TAXING_ALLOWANCE_DISAB_2ND       , VECT_TAXING_ALLOWANCE_DISAB_2ND),
                            Pair(TAXING_ALLOWANCE_DISAB_3RD       , VECT_TAXING_ALLOWANCE_DISAB_3RD),
                            Pair(TAXING_ALLOWANCE_STUDY           , VECT_TAXING_ALLOWANCE_STUDY),
                            Pair(TAXING_ALLOWANCE_CHILD_1ST       , VECT_TAXING_ALLOWANCE_CHILD_1ST),
                            Pair(TAXING_ALLOWANCE_CHILD_2ND       , VECT_TAXING_ALLOWANCE_CHILD_2ND),
                            Pair(TAXING_ALLOWANCE_CHILD_3RD       , VECT_TAXING_ALLOWANCE_CHILD_3RD),
                            Pair(TAXING_FACTOR_ADVANCES           , VECT_TAXING_FACTOR_ADVANCES),
                            Pair(TAXING_FACTOR_WITHHOLD           , VECT_TAXING_FACTOR_WITHHOLD),
                            Pair(TAXING_FACTOR_SOLIDARY           , VECT_TAXING_FACTOR_SOLIDARY),
                            Pair(TAXING_FACTOR_TAXRATE2           , VECT_TAXING_FACTOR_TAXRATE2),
                            Pair(TAXING_MIN_AMOUNT_OF_TAXBONUS    , VECT_TAXING_MIN_AMOUNT_OF_TAXBONUS),
                            Pair(TAXING_MAX_AMOUNT_OF_TAXBONUS    , VECT_TAXING_MAX_AMOUNT_OF_TAXBONUS),
                            Pair(TAXING_MARGIN_INCOME_OF_TAXBONUS , VECT_TAXING_MARGIN_INCOME_OF_TAXBONUS),
                            Pair(TAXING_MARGIN_INCOME_OF_ROUNDING , VECT_TAXING_MARGIN_INCOME_OF_ROUNDING),
                            Pair(TAXING_MARGIN_INCOME_OF_WITHHOLD , VECT_TAXING_MARGIN_INCOME_OF_WITHHOLD),
                            Pair(TAXING_MARGIN_INCOME_OF_SOLIDARY , VECT_TAXING_MARGIN_INCOME_OF_SOLIDARY),
                            Pair(TAXING_MARGIN_INCOME_OF_TAXRATE2 , VECT_TAXING_MARGIN_INCOME_OF_TAXRATE2),
                            Pair(TAXING_MARGIN_INCOME_OF_WHT_EMP  , VECT_TAXING_MARGIN_INCOME_OF_WHT_EMP),
                            Pair(TAXING_MARGIN_INCOME_OF_WHT_AGR  , VECT_TAXING_MARGIN_INCOME_OF_WHT_AGR),
                        )

                        for (data in tableData) {
                            exportHistoryTerm(testProtokol, headerData, data)
                        }
                     }
                }
            }
        }
    }
})

val HEALTH_MIN_MONTHLY_BASIS        :Int = 101
val HEALTH_MAX_ANNUALS_BASIS        :Int = 102
val HEALTH_LIM_MONTHLY_STATE        :Int = 103
val HEALTH_LIM_MONTHLY_DIS50        :Int = 104
val HEALTH_FACTOR_COMPOUND          :Int = 105
val HEALTH_FACTOR_EMPLOYEE          :Int = 106
val HEALTH_MARGIN_INCOME_EMP        :Int = 107
val HEALTH_MARGIN_INCOME_AGR        :Int = 108

val SALARY_WORKING_SHIFT_WEEK       :Int = 201
val SALARY_WORKING_SHIFT_TIME       :Int = 202
val SALARY_MIN_MONTHLY_WAGE         :Int = 203
val SALARY_MIN_HOURLY_WAGE          :Int = 204

val SOCIAL_MAX_ANNUALS_BASIS        :Int = 301
val SOCIAL_FACTOR_EMPLOYER          :Int = 302
val SOCIAL_FACTOR_EMPLOYER_HIGHER   :Int = 303
val SOCIAL_FACTOR_EMPLOYEE          :Int = 304
val SOCIAL_FACTOR_EMPLOYEE_GARANT   :Int = 305
val SOCIAL_FACTOR_EMPLOYEE_REDUCE   :Int = 306
val SOCIAL_MARGIN_INCOME_EMP        :Int = 307
val SOCIAL_MARGIN_INCOME_AGR        :Int = 308

val TAXING_ALLOWANCE_PAYER          :Int = 401
val TAXING_ALLOWANCE_DISAB_1ST      :Int = 402
val TAXING_ALLOWANCE_DISAB_2ND      :Int = 403
val TAXING_ALLOWANCE_DISAB_3RD      :Int = 404
val TAXING_ALLOWANCE_STUDY          :Int = 405
val TAXING_ALLOWANCE_CHILD_1ST      :Int = 406
val TAXING_ALLOWANCE_CHILD_2ND      :Int = 407
val TAXING_ALLOWANCE_CHILD_3RD      :Int = 408
val TAXING_FACTOR_ADVANCES          :Int = 409
val TAXING_FACTOR_WITHHOLD          :Int = 410
val TAXING_FACTOR_SOLIDARY          :Int = 411
val TAXING_FACTOR_TAXRATE2          :Int = 412
val TAXING_MIN_AMOUNT_OF_TAXBONUS   :Int = 413
val TAXING_MAX_AMOUNT_OF_TAXBONUS   :Int = 414
val TAXING_MARGIN_INCOME_OF_TAXBONUS:Int = 415
val TAXING_MARGIN_INCOME_OF_ROUNDING:Int = 416
val TAXING_MARGIN_INCOME_OF_WITHHOLD:Int = 417
val TAXING_MARGIN_INCOME_OF_SOLIDARY:Int = 418
val TAXING_MARGIN_INCOME_OF_TAXRATE2:Int = 419
val TAXING_MARGIN_INCOME_OF_WHT_EMP :Int = 420
val TAXING_MARGIN_INCOME_OF_WHT_AGR :Int = 421

fun createHistoryFile(fileName : String): FileWriter {
    var currPath = Paths.get(".").toAbsolutePath()
    while (!currPath.endsWith(PARENT_HISTORY_FOLDER_NAME) || currPath.nameCount==1) {
        currPath = currPath.parent
    }
    val basePath = Paths.get(currPath.toString(), HISTORY_FOLDER_NAME)
    val path = Paths.get(basePath.toString(), fileName).toAbsolutePath().toString()
    return FileWriter(File(path))
}

fun exportHistoryStart(protokol: FileWriter, data: Iterable<Pair<Int, Boolean>>) {
    protokol.write("History Term")
    for (col in data) {
        if (col.second)
        {
            protokol.write("\t${col.first} Begin Value")
            protokol.write("\t${col.first} Change Month")
            protokol.write("\t${col.first} End Value")
        }
        else
        {
            protokol.write("\t${col.first} Value")
        }
    }
    protokol.write("\n")
}

fun exportHistoryTerm(protokol: FileWriter, head: Iterable<Pair<Int, Boolean>>, data: Pair<Int, List<Pair<Pair<Int, Int>, Pair<String, String>>>>): Unit {
    protokol.write(historyTermName(data.first))
    for (col in data.second)
    {
        val header = head.firstOrNull {x -> (x.first == col.first.first) }
        var yearOfChange: Boolean = false
        if (header != null)
        {
            yearOfChange = header.second
        }
        protokol.write("\t${col.second.first}")
        if (yearOfChange)
        {
            if (col.first.second == 0)
            {
                protokol.write("\t")
            }
            else
            {
                protokol.write("\t${col.first.second}")
            }
            protokol.write("\t${col.second.second}")
        }
    }
    protokol.write("\n")
}

fun historyTermName(termId: Int): String {
    return when (termId) {
        HEALTH_MIN_MONTHLY_BASIS -> "01_Health_01_MinMonthlyBasis"
        HEALTH_MAX_ANNUALS_BASIS -> "01_Health_02_MaxAnnualsBasis"
        HEALTH_LIM_MONTHLY_STATE -> "01_Health_03_LimMonthlyState"
        HEALTH_LIM_MONTHLY_DIS50 -> "01_Health_04_LimMonthlyDis50"
        HEALTH_FACTOR_COMPOUND -> "01_Health_05_FactorCompound"
        HEALTH_FACTOR_EMPLOYEE -> "01_Health_06_FactorEmployee"
        HEALTH_MARGIN_INCOME_EMP -> "01_Health_07_MarginIncomeEmp"
        HEALTH_MARGIN_INCOME_AGR -> "01_Health_08_MarginIncomeAgr"
        SALARY_WORKING_SHIFT_WEEK -> "02_Salary_01_WorkingShiftWeek"
        SALARY_WORKING_SHIFT_TIME -> "02_Salary_02_WorkingShiftTime"
        SALARY_MIN_MONTHLY_WAGE -> "02_Salary_03_MinMonthlyWage"
        SALARY_MIN_HOURLY_WAGE -> "02_Salary_04_MinHourlyWage"
        SOCIAL_MAX_ANNUALS_BASIS -> "03_Social_01_MaxAnnualsBasis"
        SOCIAL_FACTOR_EMPLOYER -> "03_Social_02_FactorEmployer"
        SOCIAL_FACTOR_EMPLOYER_HIGHER -> "03_Social_03_FactorEmployerHigher"
        SOCIAL_FACTOR_EMPLOYEE -> "03_Social_04_FactorEmployee"
        SOCIAL_FACTOR_EMPLOYEE_GARANT -> "03_Social_05_FactorEmployeeGarant"
        SOCIAL_FACTOR_EMPLOYEE_REDUCE -> "03_Social_06_FactorEmployeeReduce"
        SOCIAL_MARGIN_INCOME_EMP -> "03_Social_07_MarginIncomeEmp"
        SOCIAL_MARGIN_INCOME_AGR -> "03_Social_08_MarginIncomeAgr"
        TAXING_ALLOWANCE_PAYER -> "04_Taxing_01_AllowancePayer"
        TAXING_ALLOWANCE_DISAB_1ST -> "04_Taxing_02_AllowanceDisab1st"
        TAXING_ALLOWANCE_DISAB_2ND -> "04_Taxing_03_AllowanceDisab2nd"
        TAXING_ALLOWANCE_DISAB_3RD -> "04_Taxing_04_AllowanceDisab3rd"
        TAXING_ALLOWANCE_STUDY -> "04_Taxing_05_AllowanceStudy"
        TAXING_ALLOWANCE_CHILD_1ST -> "04_Taxing_06_AllowanceChild1st"
        TAXING_ALLOWANCE_CHILD_2ND -> "04_Taxing_07_AllowanceChild2nd"
        TAXING_ALLOWANCE_CHILD_3RD -> "04_Taxing_08_AllowanceChild3rd"
        TAXING_FACTOR_ADVANCES -> "04_Taxing_09_FactorAdvances"
        TAXING_FACTOR_WITHHOLD -> "04_Taxing_10_FactorWithhold"
        TAXING_FACTOR_SOLIDARY -> "04_Taxing_11_FactorSolidary"
        TAXING_FACTOR_TAXRATE2 -> "04_Taxing_12_FactorTaxRate2"
        TAXING_MIN_AMOUNT_OF_TAXBONUS -> "04_Taxing_13_MinAmountOfTaxBonus"
        TAXING_MAX_AMOUNT_OF_TAXBONUS -> "04_Taxing_14_MaxAmountOfTaxBonus"
        TAXING_MARGIN_INCOME_OF_TAXBONUS -> "04_Taxing_15_MarginIncomeOfTaxBonus"
        TAXING_MARGIN_INCOME_OF_ROUNDING -> "04_Taxing_16_MarginIncomeOfRounding"
        TAXING_MARGIN_INCOME_OF_WITHHOLD -> "04_Taxing_17_MarginIncomeOfWithhold"
        TAXING_MARGIN_INCOME_OF_SOLIDARY -> "04_Taxing_18_MarginIncomeOfSolidary"
        TAXING_MARGIN_INCOME_OF_TAXRATE2 -> "04_Taxing_18_MarginIncomeOfTaxRate2"
        TAXING_MARGIN_INCOME_OF_WHT_EMP -> "04_Taxing_20_MarginIncomeOfWthEmp"
        TAXING_MARGIN_INCOME_OF_WHT_AGR -> "04_Taxing_21_MarginIncomeOfWthAgr"
        else -> "Unknown Term"
    }
}

fun historyTermNameCZ(termId: Int): String {
    return when (termId)
    {
        HEALTH_MIN_MONTHLY_BASIS -> "01_Health_01 Minimální základ zdravotního pojištění na jednoho pracovníka"
        HEALTH_MAX_ANNUALS_BASIS -> "01_Health_02 Maximální roční vyměřovací základ na jednoho pracovníka (tzv.strop)"
        HEALTH_LIM_MONTHLY_STATE -> "01_Health_03 Vyměřovací základ ze kterého platí pojistné stát za státní pojištěnce (mateřská, studenti, důchodci)"
        HEALTH_LIM_MONTHLY_DIS50 -> "01_Health_04 Vyměřovací základ ze kterého platí pojistné stát za státní pojištěnce (mateřská, studenti, důchodci) u zaměstnavatele zaměstnávajícího více než 50% osob OZP"
        HEALTH_FACTOR_COMPOUND -> "01_Health_05 složená sazba zdravotního pojištění (zaměstnace + zaměstnavatele)"
        HEALTH_FACTOR_EMPLOYEE -> "01_Health_06 podíl sazby zdravotního pojištění připadajícího na zaměstnace (1/FACTOR_EMPLOYEE)"
        HEALTH_MARGIN_INCOME_EMP -> "01_Health_07 hranice příjmu pro vznik účasti na pojištění pro zaměstnace v pracovním poměru"
        HEALTH_MARGIN_INCOME_AGR -> "01_Health_08 hranice příjmu pro vznik účasti na pojištění pro zaměstnace na dohodu"
        SALARY_WORKING_SHIFT_WEEK -> "02_Salary_01 Počet pracovních dnů v týdnu"
        SALARY_WORKING_SHIFT_TIME -> "02_Salary_02 Počet pracovních hodin denně"
        SALARY_MIN_MONTHLY_WAGE -> "02_Salary_03 Minimální mzda měsíční"
        SALARY_MIN_HOURLY_WAGE -> "02_Salary_04 Minimální mzda hodinová (100*Kč)"
        SOCIAL_MAX_ANNUALS_BASIS -> "03_Social_01 Maximální roční vyměřovací základ na jednoho pracovníka (tzv.strop)"
        SOCIAL_FACTOR_EMPLOYER -> "03_Social_02 Sazba - standardní sociálního pojištění - zaměstnavatele"
        SOCIAL_FACTOR_EMPLOYER_HIGHER -> "03_Social_03 Sazba - vyší sociálního pojištění - zaměstnavatele"
        SOCIAL_FACTOR_EMPLOYEE -> "03_Social_04 Sazba sociálního pojištění - zaměstnance"
        SOCIAL_FACTOR_EMPLOYEE_GARANT -> "03_Social_05 Sazba důchodového spoření - zaměstnance - s důchodovým spořením"
        SOCIAL_FACTOR_EMPLOYEE_REDUCE -> "03_Social_06 Snížení sazby sociálního pojištění - zaměstnance - s důchodovým spořením"
        SOCIAL_MARGIN_INCOME_EMP -> "03_Social_07 hranice příjmu pro vznik účasti na pojištění pro zaměstnace v pracovním poměru"
        SOCIAL_MARGIN_INCOME_AGR -> "03_Social_08 hranice příjmu pro vznik účasti na pojištění pro zaměstnace na dohodu"
        TAXING_ALLOWANCE_PAYER -> "04_Taxing_01 Částka slevy na poplatníka"
        TAXING_ALLOWANCE_DISAB_1ST -> "04_Taxing_02 Částka slevy na invaliditu 1.stupně poplatníka"
        TAXING_ALLOWANCE_DISAB_2ND -> "04_Taxing_03 Částka slevy na invaliditu 2.stupně poplatníka"
        TAXING_ALLOWANCE_DISAB_3RD -> "04_Taxing_04 Částka slevy na invaliditu 3.stupně poplatníka"
        TAXING_ALLOWANCE_STUDY -> "04_Taxing_05 Částka slevy na poplatníka studenta"
        TAXING_ALLOWANCE_CHILD_1ST -> "04_Taxing_06 Částka slevy na dítě 1.pořadí"
        TAXING_ALLOWANCE_CHILD_2ND -> "04_Taxing_07 Částka slevy na dítě 2.pořadí"
        TAXING_ALLOWANCE_CHILD_3RD -> "04_Taxing_08 Částka slevy na dítě 3.pořadí"
        TAXING_FACTOR_ADVANCES -> "04_Taxing_09 Sazba daně na zálohový příjem"
        TAXING_FACTOR_WITHHOLD -> "04_Taxing_10 Sazba daně na srážkový příjem"
        TAXING_FACTOR_SOLIDARY -> "04_Taxing_11 Sazba daně na solidární zvýšení"
        TAXING_FACTOR_TAXRATE2 -> "04_Taxing_12 Sazba daně pro druhé pásmo daně"
        TAXING_MIN_AMOUNT_OF_TAXBONUS -> "04_Taxing_13 Minimální částka pro daňový bonus"
        TAXING_MAX_AMOUNT_OF_TAXBONUS -> "04_Taxing_14 Maximální částka pro daňový bonus"
        TAXING_MARGIN_INCOME_OF_TAXBONUS -> "04_Taxing_15 Minimální výše příjmu pro nároku na daňový bonus"
        TAXING_MARGIN_INCOME_OF_ROUNDING -> "04_Taxing_16 Maximální výše příjmu pro zaokrouhlování"
        TAXING_MARGIN_INCOME_OF_WITHHOLD -> "04_Taxing_17 Maximální výše příjmu pro srážkový příjem"
        TAXING_MARGIN_INCOME_OF_SOLIDARY -> "04_Taxing_18 Minimální výše příjmu pro solidární zvýšení daně"
        TAXING_MARGIN_INCOME_OF_TAXRATE2 -> "04_Taxing_18 Minimální výše příjmu pro druhé pásmo daně"
        TAXING_MARGIN_INCOME_OF_WHT_EMP -> "04_Taxing_20 hranice příjmu pro srážkovou daň pro zaměstnace v pracovním poměru (nepodepsal prohlášení)"
        TAXING_MARGIN_INCOME_OF_WHT_AGR -> "04_Taxing_21 hranice příjmu pro srážkovou daň pro zaměstnace na dohodu (nepodepsal prohlášení)"
        else -> "Neznámý Termín"
    }
}
fun propsValueToString(value: Int): String {
    return "$value"
}

fun propsValueToString(value: BigDecimal): String {
    val intValue: Int = (value*100.toBigDecimal()).toInt()
    return "$intValue"
}

