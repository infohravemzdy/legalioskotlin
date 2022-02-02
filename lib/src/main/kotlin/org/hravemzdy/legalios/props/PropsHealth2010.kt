package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.service.types.VersionId
import org.hravemzdy.legalios.service.types.WorkHealthTerms
import java.math.BigDecimal

class PropsHealth2010(version: VersionId,
                      _minMonthlyBasis: Int,
                      _maxAnnualsBasis: Int,
                      _limMonthlyState: Int,
                      _limMonthlyDis50: Int,
                      _factorCompound: BigDecimal,
                      _factorEmployee: BigDecimal,
                      _marginIncomeEmp: Int,
                      _marginIncomeAgr: Int) :
    PropsHealthBase(version,
        _minMonthlyBasis,
        _maxAnnualsBasis,
        _limMonthlyState,
        _limMonthlyDis50,
        _factorCompound,
        _factorEmployee,
        _marginIncomeEmp,
        _marginIncomeAgr), IPropsHealth {

    constructor(version: Int) : this(
        VersionId.get(version),
        0,0,0,0,
        BigDecimal.ZERO, BigDecimal.ZERO,
        0,0)

    override fun hasTermExemptionParticy(term: WorkHealthTerms): Boolean {
        return false
    }
    override fun hasIncomeBasedEmploymentParticy(term: WorkHealthTerms): Boolean {
        return (term == WorkHealthTerms.HEALTH_TERM_AGREEM_WORK)
    }
    override fun hasIncomeBasedAgreementsParticy(term: WorkHealthTerms): Boolean {
        return false
    }
    override fun hasIncomeCumulatedParticy(term: WorkHealthTerms): Boolean {
        val particy = when (term) {
            WorkHealthTerms.HEALTH_TERM_EMPLOYMENTS -> false
            WorkHealthTerms.HEALTH_TERM_AGREEM_WORK -> false
            WorkHealthTerms.HEALTH_TERM_AGREEM_TASK -> false
            WorkHealthTerms.HEALTH_TERM_BY_CONTRACT -> false
         }
        return particy
    }

    companion object {
        fun empty(): IPropsHealth {
            return PropsHealth2010(VERSION_ZERO)
        }
    }
 }