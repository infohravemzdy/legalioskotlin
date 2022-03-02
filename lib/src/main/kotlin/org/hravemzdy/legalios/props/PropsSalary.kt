package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSalary
import org.hravemzdy.legalios.service.types.OperationsDec
import org.hravemzdy.legalios.service.types.OperationsRound
import org.hravemzdy.legalios.service.types.VersionId
import java.math.BigDecimal
import kotlin.math.max
import kotlin.math.min

class PropsSalary(version: VersionId,
                       override val workingShiftWeek: Int,
                       override val workingShiftTime: Int,
                       override val minMonthlyWage: Int,
                       override val minHourlyWage: Int) :
    PropsBase(version), IPropsSalary {

    constructor(version: Int) : this(
        VersionId.get(version),
        0,0,0,0) {
    }

    override fun valueEquals(other: IPropsSalary?): Boolean {
        if (other == null)
        {
            return false
        }
        return (this.workingShiftWeek == other.workingShiftWeek &&
                this.workingShiftTime == other.workingShiftTime &&
                this.minMonthlyWage == other.minMonthlyWage &&
                this.minHourlyWage == other.minHourlyWage)
    }

    private fun totalHoursWithFullAndPartHours(fullWorkHours: Int, partWorkHours: Int): Int {
        val totalsHours = max(0, partWorkHours)

        val resultHours = min(fullWorkHours, totalsHours)

        return resultHours
    }
    private fun decPaymentWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal {
        val coeffAmount = factorizeValue(amountMonthly, monthlyCoeff)

        val payment = decPaymentWithMonthlyAndFullAndWorkHours(coeffAmount, fullWorkHours, partWorkHours)

        return payment
    }
    private fun decPaymentWithMonthlyAndFullAndWorkHours(amountMonthly: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal {
        val paymWorkHours = totalHoursWithFullAndPartHours(fullWorkHours, partWorkHours)

        val payment = OperationsDec.multiplyAndDivide(amountMonthly, paymWorkHours.toBigDecimal(), fullWorkHours.toBigDecimal())

        return payment
    }
    private fun decPaymentWithTariffAndHours(tariffHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal {
        val totalHours = BigDecimal.ZERO.max(workingsHours)

        val payment = OperationsDec.multiply(totalHours, tariffHourly)

        return payment
    }
    private fun decTariffWithPaymentAndHours(amountHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal {
        val totalHours = BigDecimal.ZERO.max(workingsHours)

        val tariff = OperationsDec.divide(amountHourly, totalHours)

        return tariff
    }
    private fun decPaymentWithAmountFixed(amountFixed: BigDecimal): BigDecimal {
        val payment = amountFixed

        return payment
    }

    override fun coeffWithPartAndFullHours(fullWorkHours: BigDecimal, partWorkHours: BigDecimal): BigDecimal {
        val coeffWorking = 1.toBigDecimal().min(OperationsDec.divide(partWorkHours, fullWorkHours))

        return coeffWorking
    }

    override fun paymentWithMonthlyAndFullWeekAndFullAndWorkHours(amountMonthly: BigDecimal,
                                                                  fullWeekHours: Int, partWeekHours: Int,
                                                                  fullWorkHours: Int, partWorkHours: Int): BigDecimal {
        val coeffSalary = coeffWithPartAndFullHours(partWeekHours.toBigDecimal(), fullWeekHours.toBigDecimal())

        val salaryValue = paymentWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly, coeffSalary, fullWorkHours, partWorkHours)

        return salaryValue
    }
    override fun paymentRoundUpWithMonthlyAndFullWeekAndFullAndWorkHours(amountMonthly: BigDecimal,
                                                                         fullWeekHours: Int, partWeekHours: Int,
                                                                         fullWorkHours: Int, partWorkHours: Int): BigDecimal {
        val coeffSalary = coeffWithPartAndFullHours(partWeekHours.toBigDecimal(), fullWeekHours.toBigDecimal())

        val salaryValue = paymentRoundUpWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly, coeffSalary, fullWorkHours, partWorkHours)

        return salaryValue
    }
    override fun paymentWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal {
        val amountCoeffs = factorizeValue(amountMonthly, monthlyCoeff)

        val paymentValue = decPaymentWithMonthlyAndFullAndWorkHours(amountCoeffs, fullWorkHours, partWorkHours)

        return OperationsRound.decRoundNorm(paymentValue)
    }
    override fun paymentRoundUpWithMonthlyAndCoeffAndFullAndWorkHours(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, fullWorkHours: Int, partWorkHours: Int): BigDecimal {
        val amountCoeffs = factorizeValue(amountMonthly, monthlyCoeff)

        val paymentValue = decPaymentWithMonthlyAndFullAndWorkHours(amountCoeffs, fullWorkHours, partWorkHours)

        return OperationsRound.decRoundUp(paymentValue)
    }
    override fun paymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal {
        val amountFactor = factorizeValue(amountMonthly, monthlyCoeff)

        val paymentValue = factorizeValue(amountFactor, workingCoeff)

        return OperationsRound.decRoundNorm(paymentValue)
    }
    override fun paymentRoundUpWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal {
        val amountFactor = factorizeValue(amountMonthly, monthlyCoeff)

        val paymentValue = factorizeValue(amountFactor, workingCoeff)

        return OperationsRound.decRoundUp(paymentValue)
    }
    override fun relativeAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal {
        val amountCoeffs = factorizeValue(amountMonthly, monthlyCoeff)

        val relativeAmount = factorizeValue(amountCoeffs, workingCoeff)

        return relativeAmount
    }

    override fun relativeTariffWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal {
        val paymentValue = relativeAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly, monthlyCoeff, workingCoeff)

        return OperationsRound.decRoundNorm01(paymentValue)
    }

    override fun relativePaymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal {
        val paymentValue = relativeAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly, monthlyCoeff, workingCoeff)

        return OperationsRound.decRoundNorm(paymentValue)
    }

    override fun reverzedAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal {
        val amountCoeffs = reverzedFactorizeValue(amountMonthly, monthlyCoeff)

        val reverzedAmount = reverzedFactorizeValue(amountCoeffs, workingCoeff)

        return reverzedAmount
    }

    override fun reverzedTariffWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal {
        val paymentValue = reverzedAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly, monthlyCoeff, workingCoeff)

        return OperationsRound.decRoundNorm01(paymentValue)
    }

    override fun reverzedPaymentWithMonthlyAndCoeffAndWorkCoeff(amountMonthly: BigDecimal, monthlyCoeff: BigDecimal, workingCoeff: BigDecimal): BigDecimal {
        val paymentValue = reverzedAmountWithMonthlyAndCoeffAndWorkCoeff(amountMonthly, monthlyCoeff, workingCoeff)

        return OperationsRound.decRoundNorm(paymentValue)
    }

    override fun paymentWithTariffAndHours(tariffHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal {
        val paymentValue = decPaymentWithTariffAndHours(tariffHourly, workingsHours)

        return OperationsRound.decRoundNorm(paymentValue)
    }
    override fun paymentRoundUpWithTariffAndHours(tariffHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal {
        val paymentValue = decPaymentWithTariffAndHours(tariffHourly, workingsHours)

        return OperationsRound.decRoundUp(paymentValue)
    }
    override fun tariffWithPaymentAndHours(amountHourly: BigDecimal, workingsHours: BigDecimal): BigDecimal {
        val tariffValue = decTariffWithPaymentAndHours(amountHourly, workingsHours)

        return moneyToRoundNorm(tariffValue)
    }
    override fun paymentWithAmountFixed(amountFixed: BigDecimal): BigDecimal {
        val paymentValue = decPaymentWithAmountFixed(amountFixed)

        return OperationsRound.decRoundNorm(paymentValue)
    }
    override fun paymentRoundUpWithAmountFixed(amountFixed: BigDecimal): BigDecimal {
        val paymentValue = decPaymentWithAmountFixed(amountFixed)

        return OperationsRound.decRoundUp(paymentValue)
    }
    override fun hoursToHalfHoursUp(hoursValue: BigDecimal): BigDecimal {
        return OperationsRound.decRoundUp50(hoursValue)
    }
    override fun hoursToQuartHoursUp(hoursValue: BigDecimal): BigDecimal {
        return OperationsRound.decRoundUp25(hoursValue)
    }
    override fun hoursToHalfHoursDown(hoursValue: BigDecimal): BigDecimal {
        return OperationsRound.decRoundDown50(hoursValue)
    }
    override fun hoursToQuartHoursDown(hoursValue: BigDecimal): BigDecimal {
        return OperationsRound.decRoundDown25(hoursValue)
    }
    override fun hoursToHalfHoursNorm(hoursValue: BigDecimal): BigDecimal {
        return OperationsRound.decRoundNorm50(hoursValue)
    }
    override fun hoursToQuartHoursNorm(hoursValue: BigDecimal): BigDecimal {
        return OperationsRound.decRoundNorm25(hoursValue)
    }
    override fun moneyToRoundDown(moneyValue: BigDecimal): BigDecimal {
        return OperationsRound.decRoundDown01(moneyValue)
    }
    override fun moneyToRoundUp(moneyValue: BigDecimal): BigDecimal {
        return OperationsRound.decRoundUp01(moneyValue)
    }
    override fun moneyToRoundNorm(moneyValue: BigDecimal): BigDecimal {
        return OperationsRound.decRoundNorm01(moneyValue)
    }

    companion object {
        fun empty(): IPropsSalary {
            return PropsSalary(VERSION_ZERO)
        }
        fun factorizeValue(baseValue: BigDecimal, factor: BigDecimal): BigDecimal {
            val result = OperationsDec.multiply(baseValue, factor)

            return result
        }
        fun reverzedFactorizeValue(baseValue: BigDecimal, factor: BigDecimal): BigDecimal {
            val result = OperationsDec.multiply(baseValue, OperationsDec.divide(1.toBigDecimal(), factor))

            return result
        }
    }
}