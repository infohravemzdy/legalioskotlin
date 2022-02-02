package org.hravemzdy.legalios.interfaces

import java.math.BigDecimal

interface IPropsSalary : IProps {
    val workingShiftWeek : Int
    val workingShiftTime : Int
    val minMonthlyWage : Int
    val minHourlyWage : Int

    fun valueEquals(other: IPropsSalary?): Boolean
    fun coeffWithPartAndFullHours(fullWorkHours: BigDecimal, partWorkHours: BigDecimal): BigDecimal
    fun paymentWithMonthlyAndFullWeekAndFullAndWorkHours(amountMonthly: BigDecimal,
                                                         fullWeekHours: Int, partWeekHours: Int,
                                                         fullWorkHours: Int, partWorkHours: Int): BigDecimal
    fun paymentRoundUpWithMonthlyAndFullWeekAndFullAndWorkHours(amountMonthly: BigDecimal,
                                                                fullWeekHours: Int, partWeekHours: Int,
                                                                fullWorkHours: Int, partWorkHours: Int): BigDecimal
    fun paymentWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly: BigDecimal,
                                                      monthlyCoeff: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal
    fun paymentRoundUpWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly: BigDecimal,
                                                             monthlyCoeff: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal
    fun paymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal,
                                               monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
    fun paymentRoundUpWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal,
                                                      monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
    fun relativeAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
    fun relativeTariffWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
    fun relativePaymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
    fun reverzedAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
    fun reverzedTariffWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
    fun reverzedPaymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal
    fun paymentWithTariffAndHours(tariffHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal
    fun paymentRoundUpWithTariffAndHours(tariffHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal
    fun tariffWithPaymentAndHours(amountHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal
    fun paymentWithAmountFixed(amountFixed: BigDecimal): BigDecimal
    fun paymentRoundUpWithAmountFixed(amountFixed: BigDecimal): BigDecimal
    fun hoursToHalfHoursUp(hoursValue: BigDecimal): BigDecimal
    fun hoursToQuartHoursUp(hoursValue: BigDecimal): BigDecimal
    fun hoursToHalfHoursDown(hoursValue: BigDecimal): BigDecimal
    fun hoursToQuartHoursDown(hoursValue: BigDecimal): BigDecimal
    fun hoursToHalfHoursNorm(hoursValue: BigDecimal): BigDecimal
    fun hoursToQuartHoursNorm(hoursValue: BigDecimal): BigDecimal
    fun moneyToRoundDown(moneyValue: BigDecimal): BigDecimal
    fun moneyToRoundUp(moneyValue: BigDecimal): BigDecimal
    fun moneyToRoundNorm(moneyValue: BigDecimal): BigDecimal
}