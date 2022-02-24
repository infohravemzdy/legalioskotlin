package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.service.types.OperationsDec
import org.hravemzdy.legalios.service.types.OperationsRound
import org.hravemzdy.legalios.service.types.VersionId
import org.hravemzdy.legalios.service.types.WorkHealthTerms
import java.math.BigDecimal
import kotlin.math.max


abstract class PropsHealthBase(version: VersionId,
                      override val minMonthlyBasis: Int,
                      override val maxAnnualsBasis: Int,
                      override val limMonthlyState: Int,
                      override val limMonthlyDis50: Int,
                      override val factorCompound: BigDecimal,
                      override val factorEmployee: BigDecimal,
                      override val marginIncomeEmp: Int,
                      override val marginIncomeAgr: Int) :
    PropsBase(version), IPropsHealth {

    override fun valueEquals(other: IPropsHealth?): Boolean {
        if (other == null)
        {
            return false
        }
        return (this.minMonthlyBasis == other.minMonthlyBasis &&
                this.maxAnnualsBasis == other.maxAnnualsBasis &&
                this.limMonthlyState == other.limMonthlyState &&
                this.limMonthlyDis50 == other.limMonthlyDis50 &&
                this.factorCompound == other.factorCompound &&
                this.factorEmployee == other.factorEmployee &&
                this.marginIncomeEmp == other.marginIncomeEmp &&
                this.marginIncomeAgr == other.marginIncomeAgr)
    }

    override fun hasParticy(term: WorkHealthTerms, incomeTerm: Int, incomeSpec: Int): Boolean {
        var particySpec: Boolean = true
        if (hasTermExemptionParticy(term)) {
            particySpec = false
        } else if (hasIncomeBasedAgreementsParticy(term) && marginIncomeAgr > 0) {
            particySpec = false
            if (hasIncomeCumulatedParticy(term)) {
                if (incomeTerm >= marginIncomeAgr) {
                    particySpec = true
                }
            } else {
                if (incomeSpec >= marginIncomeAgr) {
                    particySpec = true
                }
            }
        } else if (hasIncomeBasedEmploymentParticy(term) && marginIncomeEmp > 0) {
            particySpec = false
            if (hasIncomeCumulatedParticy(term)) {
                if (incomeTerm >= marginIncomeEmp) {
                    particySpec = true
                }
            } else {
                if (incomeSpec >= marginIncomeEmp) {
                    particySpec = true
                }
            }
        }
        return particySpec
    }

    protected abstract fun hasTermExemptionParticy(term: WorkHealthTerms): Boolean
    protected abstract fun hasIncomeBasedEmploymentParticy(term: WorkHealthTerms): Boolean
    protected abstract fun hasIncomeBasedAgreementsParticy(term: WorkHealthTerms): Boolean
    protected abstract fun hasIncomeCumulatedParticy(term: WorkHealthTerms): Boolean

    private fun decInsuranceRoundUp(valueDec: BigDecimal): BigDecimal {
        return OperationsRound.decRoundUp(valueDec)
    }

    private fun intInsuranceRoundUp(valueDec: BigDecimal): Int {
        return OperationsRound.roundUp(valueDec)
    }

    override fun roundedCompoundPaym(basisResult: Int): Int {
        val factorCompound = OperationsDec.divide(factorCompound, 100.toBigDecimal())

        return intInsuranceRoundUp(OperationsDec.multiply(basisResult.toBigDecimal(), factorCompound))
    }

    override fun roundedEmployeePaym(basisResult: Int): Int {
        val factorCompound = OperationsDec.divide(factorCompound, 100.toBigDecimal())
        return intInsuranceRoundUp(OperationsDec.multiplyAndDivide(basisResult.toBigDecimal(), factorCompound, factorEmployee))
    }

    override fun roundedAugmentEmployeePaym(basisGenerals: Int, basisAugment: Int): Int {
        val factorCompound = OperationsDec.divide(factorCompound, 100.toBigDecimal())

        return intInsuranceRoundUp(
            OperationsDec.multiply(basisAugment.toBigDecimal(), factorCompound)
                    + OperationsDec.multiplyAndDivide(basisGenerals.toBigDecimal(), factorCompound, factorEmployee)
        )
    }

    override fun roundedAugmentEmployerPaym(basisGenerals: Int, baseEmployee: Int, baseEmployer: Int): Int {
        val factorCompound = OperationsDec.divide(factorCompound, 100.toBigDecimal())

        val compoundBasis = baseEmployer + baseEmployee + basisGenerals

        val compoundPayment = intInsuranceRoundUp(OperationsDec.multiply(compoundBasis.toBigDecimal(), factorCompound))
        val employeePayment = intInsuranceRoundUp(
            OperationsDec.multiply(baseEmployee.toBigDecimal(), factorCompound)
                    + OperationsDec.multiplyAndDivide(basisGenerals.toBigDecimal(), factorCompound, factorEmployee)
        )

        return max(0, compoundPayment - employeePayment)
    }

    override fun roundedEmployerPaym(basisResult: Int): Int {
        val compoundPayment = roundedCompoundPaym(basisResult)
        val employeePayment = roundedEmployeePaym(basisResult)

        return max(0, compoundPayment - employeePayment)
    }

    override fun annualsBasisCut(incomeList: Iterable<ParticyHealthTarget>, annuityBasis: Int): Triple<Int, Int, Iterable<ParticyHealthResult>> {
        val annualyMaxim: Int = maxAnnualsBasis
        val annualsBasis = max(0, annualyMaxim - annuityBasis)
        var resultInit = Triple<Int, Int, Iterable<ParticyHealthResult>>(annualyMaxim, annualsBasis, emptyList<ParticyHealthResult>())

        var resultList = incomeList.fold(resultInit) { agr, x ->
            var cutAnnualsBasis: Int = 0
            val rawAnnualsBasis: Int = x.targetsBase
            var remAnnualsBasis: Int = agr.second

            if (x.particyCode != 0) {
                cutAnnualsBasis = rawAnnualsBasis
                if (agr.first > 0)
                {
                    var ovrAnnualsBasis = max(0, rawAnnualsBasis - agr.second)
                    cutAnnualsBasis = (rawAnnualsBasis - ovrAnnualsBasis)
                }
                remAnnualsBasis = max(0, (agr.second - cutAnnualsBasis))
            }

            val r = ParticyHealthResult(x.contractCode, x.subjectType, x.interestCode,
                x.subjectTerm, x.particyCode, x.targetsBase, max(0, cutAnnualsBasis))
            return Triple<Int, Int, Iterable<ParticyHealthResult>>(agr.first, remAnnualsBasis, agr.third.plus(r))
        }

        return resultList
    }
}