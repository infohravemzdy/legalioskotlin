package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IParticyResult
import org.hravemzdy.legalios.interfaces.IProps
import org.hravemzdy.legalios.service.types.VersionId
import kotlin.math.max

abstract class PropsBase(override val version: VersionId) : IProps {
    constructor(versionId: Int) : this(VersionId.get(versionId))

    fun isValid(): Boolean { return version.value != VERSION_ZERO }

    fun maximResultCut(incomeList: Iterable<IParticyResult>, annuityBasis: Int, annualyMaxim: Int): Triple<Int, Int, Iterable<IParticyResult>> {
        val annualsBasis = max(0, annualyMaxim - annuityBasis)
        var resultInit = Triple<Int, Int, Iterable<IParticyResult>>(annualyMaxim, annualsBasis, emptyArray<IParticyResult>().toList());

        var resultList = incomeList.fold(resultInit) { agr, x ->
            var cutAnnualsBasis: Int = 0
            val rawAnnualsBasis: Int = x.resultBasis
            var remAnnualsBasis: Int = agr.second

            if (x.particyCode != 0)
            {
                cutAnnualsBasis = rawAnnualsBasis;
                if (agr.first > 0)
                {
                    var ovrAnnualsBasis = max(0, rawAnnualsBasis - agr.second)
                    cutAnnualsBasis = (rawAnnualsBasis - ovrAnnualsBasis)
                }
                remAnnualsBasis = max(0, (agr.second - cutAnnualsBasis))
            }

            x.setResultValue(max(0, cutAnnualsBasis))
            return Triple<Int, Int, Iterable<IParticyResult>>(agr.first, remAnnualsBasis, agr.third.plus(x))
        }

        return resultList
    }

    companion object {
        const val VERSION_ZERO: Int = 0
    }
}