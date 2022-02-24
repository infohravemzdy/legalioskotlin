package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.service.types.OperationsDec
import org.hravemzdy.legalios.service.types.OperationsRound
import org.hravemzdy.legalios.service.types.VersionId
import org.hravemzdy.legalios.service.types.WorkSocialTerms
import java.math.BigDecimal
import kotlin.math.max


abstract class PropsSocialBase(version: VersionId,
                      override val maxAnnualsBasis: Int,
                      override val factorEmployer: BigDecimal,
                      override val factorEmployerHigher: BigDecimal,
                      override val factorEmployee: BigDecimal,
                      override val factorEmployeeGarant: BigDecimal,
                      override val factorEmployeeReduce: BigDecimal,
                      override val marginIncomeEmp: Int,
                      override val marginIncomeAgr: Int) :
    PropsBase(version), IPropsSocial {

    override fun valueEquals(other: IPropsSocial?): Boolean {
        if (other == null) {
            return false
        }
        return (this.maxAnnualsBasis == other.maxAnnualsBasis &&
                this.factorEmployer == other.factorEmployer &&
                this.factorEmployerHigher == other.factorEmployerHigher &&
                this.factorEmployee == other.factorEmployee &&
                this.factorEmployeeGarant == other.factorEmployeeGarant &&
                this.factorEmployeeReduce == other.factorEmployeeReduce &&
                this.marginIncomeEmp == other.marginIncomeEmp &&
                this.marginIncomeAgr == other.marginIncomeAgr)
    }

    override fun hasParticy(term: WorkSocialTerms, incomeTerm: Int, incomeSpec: Int): Boolean {
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

    protected abstract fun hasTermExemptionParticy(term: WorkSocialTerms): Boolean
    protected abstract fun hasIncomeBasedEmploymentParticy(term: WorkSocialTerms): Boolean
    protected abstract fun hasIncomeBasedAgreementsParticy(term: WorkSocialTerms): Boolean
    protected abstract fun hasIncomeCumulatedParticy(term: WorkSocialTerms): Boolean

    private fun decInsuranceRoundUp(valueDec: BigDecimal): BigDecimal {
        return OperationsRound.decRoundUp(valueDec)
    }

    private fun intInsuranceRoundUp(valueDec: BigDecimal): Int {
        return OperationsRound.roundUp(valueDec)
    }

    override fun roundedEmployeePaym(basisResult: Int): Int {
        val factorEmployee = OperationsDec.divide(factorEmployee, 100.toBigDecimal())
        return intInsuranceRoundUp(OperationsDec.multiply(basisResult.toBigDecimal(), factorEmployee))
    }

    override fun roundedEmployerPaym(basisResult: Int): Int {
        val factorEmployer = OperationsDec.divide(factorEmployer, 100.toBigDecimal())
        return intInsuranceRoundUp(OperationsDec.multiply(basisResult.toBigDecimal(), factorEmployer))
    }

    override fun resultOvercaps(baseSuma: Int, overCaps: Int): Pair<Int, Int> {
        val maxBaseEmployee = max(0, baseSuma - overCaps)
        val empBaseOvercaps = max(0, baseSuma - maxBaseEmployee)
        val valBaseOvercaps = max(0, overCaps - empBaseOvercaps)
        return Pair<Int, Int>(maxBaseEmployee, valBaseOvercaps)
    }

    override fun annualsBasisCut(incomeList: Iterable<ParticySocialTarget>, annuityBasis: Int): Triple<Int, Int, Iterable<ParticySocialResult>> {
        val annualyMaxim: Int = maxAnnualsBasis
        val annualsBasis = max(0, annualyMaxim - annuityBasis)
        var resultInit = Triple<Int, Int, Iterable<ParticySocialResult>>(annualyMaxim, annualsBasis, emptyList<ParticySocialResult>())

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

            val r = ParticySocialResult(x.contractCode, x.subjectType, x.interestCode,
                x.subjectTerm, x.particyCode, x.targetsBase, max(0, cutAnnualsBasis))
            return Triple<Int, Int, Iterable<ParticySocialResult>>(agr.first, remAnnualsBasis, agr.third.plus(r))
        }

        return resultList
    }
}