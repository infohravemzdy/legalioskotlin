package org.hravemzdy.legalios.interfaces

import org.hravemzdy.legalios.props.ParticySocialResult
import org.hravemzdy.legalios.props.ParticySocialTarget
import org.hravemzdy.legalios.service.types.WorkSocialTerms
import java.math.BigDecimal

interface IPropsSocial : IProps {
    val maxAnnualsBasis: Int
    val factorEmployer: BigDecimal
    val factorEmployerHigher: BigDecimal
    val factorEmployee: BigDecimal
    val factorEmployeeGarant: BigDecimal
    val factorEmployeeReduce: BigDecimal
    val marginIncomeEmp: Int
    val marginIncomeAgr: Int

    fun valueEquals(other: IPropsSocial?): Boolean
    fun hasParticy(term: WorkSocialTerms, incomeTerm: Int, incomeSpec: Int): Boolean
    fun roundedEmployeePaym(basisResult: Int): Int
    fun roundedEmployerPaym(basisResult: Int): Int
    fun resultOvercaps(baseSuma: Int, overCaps: Int): Pair<Int, Int>
    fun annualsBasisCut(incomeList: Iterable<ParticySocialTarget>, annuityBasis: Int): Triple<Int, Int, Iterable<ParticySocialResult>>
}