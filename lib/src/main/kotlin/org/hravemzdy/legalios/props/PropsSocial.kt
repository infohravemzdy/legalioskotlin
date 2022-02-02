package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.service.types.VersionId
import org.hravemzdy.legalios.service.types.WorkSocialTerms
import java.math.BigDecimal

class PropsSocial(version: VersionId,
                  _maxAnnualsBasis: Int,
                  _factorEmployer: BigDecimal,
                  _factorEmployerHigher: BigDecimal,
                  _factorEmployee: BigDecimal,
                  _factorEmployeeGarant: BigDecimal,
                  _factorEmployeeReduce: BigDecimal,
                  _marginIncomeEmp: Int,
                  _marginIncomeAgr: Int) :
    PropsSocialBase(version,
        _maxAnnualsBasis,
        _factorEmployer,
        _factorEmployerHigher,
        _factorEmployee,
        _factorEmployeeGarant,
        _factorEmployeeReduce,
        _marginIncomeEmp,
        _marginIncomeAgr), IPropsSocial {

    constructor(version: Int) : this(
        VersionId.get(version),
        0,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        0,
        0)

    override fun hasTermExemptionParticy(term: WorkSocialTerms): Boolean {
        return false
    }
    override fun hasIncomeBasedEmploymentParticy(term: WorkSocialTerms): Boolean {
        return (term == WorkSocialTerms.SOCIAL_TERM_SMALLS_EMPL)
    }
    override fun hasIncomeBasedAgreementsParticy(term: WorkSocialTerms): Boolean {
        return (term == WorkSocialTerms.SOCIAL_TERM_AGREEM_TASK)
    }
    override fun hasIncomeCumulatedParticy(term: WorkSocialTerms): Boolean {
        val particy = when (term) {
            WorkSocialTerms.SOCIAL_TERM_EMPLOYMENTS -> false
            WorkSocialTerms.SOCIAL_TERM_AGREEM_TASK -> true
            WorkSocialTerms.SOCIAL_TERM_SMALLS_EMPL -> true
            WorkSocialTerms.SOCIAL_TERM_SHORTS_MEET -> false
            WorkSocialTerms.SOCIAL_TERM_SHORTS_DENY -> false
            WorkSocialTerms.SOCIAL_TERM_BY_CONTRACT -> false
        }
        return particy
    }

    companion object {
        fun empty(): IPropsSocial {
            return PropsSocial(VERSION_ZERO)
        }
    }
}