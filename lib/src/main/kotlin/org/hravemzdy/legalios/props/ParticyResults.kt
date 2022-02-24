package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.service.types.WorkHealthTerms
import org.hravemzdy.legalios.service.types.WorkSocialTerms
import org.hravemzdy.legalios.service.types.WorkTaxingTerms

class ParticyHealthTarget(val contractCode: Int, val subjectType: WorkTaxingTerms, val interestCode: Int, val subjectTerm: WorkHealthTerms, val particyCode: Int, var targetsBase: Int) {

    fun addTargetBase(targetsBase: Int): Int {
        this.targetsBase += targetsBase
        return this.targetsBase
    }

    fun incomeScore(): Int {
        var resultType : Int = when (subjectType) {
            WorkTaxingTerms.TAXING_TERM_EMPLOYMENTS -> 900
            WorkTaxingTerms.TAXING_TERM_AGREEM_TASK -> 100
            WorkTaxingTerms.TAXING_TERM_STATUT_PART -> 500
            WorkTaxingTerms.TAXING_TERM_BY_CONTRACT -> 0
        }
        var resultBase : Int = when (subjectTerm) {
            WorkHealthTerms.HEALTH_TERM_EMPLOYMENTS -> 9000
            WorkHealthTerms.HEALTH_TERM_AGREEM_WORK -> 5000
            WorkHealthTerms.HEALTH_TERM_AGREEM_TASK -> 4000
            WorkHealthTerms.HEALTH_TERM_BY_CONTRACT -> 0
        }
        var interestRes : Int = 0
        if (interestCode == 1) {
            interestRes = 10000
        }
        var particyRes : Int = 0
        if (particyCode == 1) {
            particyRes = 100000
        }
        return (resultType + resultBase + interestRes + particyRes)
    }
    fun resultComparator(): (ParticyHealthTarget, ParticyHealthTarget) -> Int {
        return fun(x: ParticyHealthTarget, y: ParticyHealthTarget): Int {
            val xIncomeScore = x.incomeScore()
            val yIncomeScore = y.incomeScore()

            if (xIncomeScore.compareTo(yIncomeScore) == 0) {
                return x.contractCode.compareTo(y.contractCode)
            }
            return yIncomeScore.compareTo(xIncomeScore)
        }
    }
}

data class ParticyHealthResult(val contractCode: Int, val subjectType: WorkTaxingTerms, val interestCode: Int, val subjectTerm: WorkHealthTerms, val particyCode: Int, var targetsBase: Int, val resultsBase: Int)

class ParticySocialTarget(val contractCode: Int, val subjectType: WorkTaxingTerms, val interestCode: Int, val subjectTerm: WorkSocialTerms, val particyCode: Int, var targetsBase: Int, val resultsBase: Int) {
    fun addTargetBase(targetsBase: Int): Int {
        this.targetsBase += targetsBase
        return this.targetsBase
    }

    fun incomeScore(): Int {
        var resultType : Int = when (subjectType) {
            WorkTaxingTerms.TAXING_TERM_EMPLOYMENTS -> 900
            WorkTaxingTerms.TAXING_TERM_AGREEM_TASK -> 100
            WorkTaxingTerms.TAXING_TERM_STATUT_PART -> 500
            WorkTaxingTerms.TAXING_TERM_BY_CONTRACT -> 0
        }
        var resultBase : Int = when (subjectTerm) {
            WorkSocialTerms.SOCIAL_TERM_EMPLOYMENTS -> 9000
            WorkSocialTerms.SOCIAL_TERM_SMALLS_EMPL -> 5000
            WorkSocialTerms.SOCIAL_TERM_SHORTS_MEET -> 4000
            WorkSocialTerms.SOCIAL_TERM_SHORTS_DENY -> 0
            WorkSocialTerms.SOCIAL_TERM_BY_CONTRACT -> 0
            WorkSocialTerms.SOCIAL_TERM_AGREEM_TASK -> 0
        }
        var interestRes : Int = 0
        if (interestCode == 1) {
            interestRes = 10000
        }
        var particyRes : Int = 0
        if (particyCode == 1) {
            particyRes = 100000
        }
        return (resultType + resultBase + interestRes + particyRes)
    }
    fun resultComparator(): (ParticySocialTarget, ParticySocialTarget) -> Int {
        return fun(x: ParticySocialTarget, y: ParticySocialTarget): Int {
            val xIncomeScore = x.incomeScore()
            val yIncomeScore = y.incomeScore()

            if (xIncomeScore.compareTo(yIncomeScore) == 0) {
                return x.contractCode.compareTo(y.contractCode)
            }
            return yIncomeScore.compareTo(xIncomeScore)
        }
    }
}

data class ParticySocialResult(val contractCode: Int, val subjectType: WorkTaxingTerms, val interestCode: Int, val subjectTerm: WorkSocialTerms, val particyCode: Int, var targetsBase: Int, val resultsBase: Int)

