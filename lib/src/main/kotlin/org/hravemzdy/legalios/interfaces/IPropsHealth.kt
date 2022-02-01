package org.hravemzdy.legalios.interfaces

import org.hravemzdy.legalios.service.types.WorkHealthTerms
import java.math.BigDecimal

interface IPropsHealth : IProps {
    val minMonthlyBasis: Int
    val maxAnnualsBasis: Int
    val limMonthlyState: Int
    val limMonthlyDis50: Int
    val factorCompound: BigDecimal
    val factorEmployee: BigDecimal
    val marginIncomeEmp: Int
    val marginIncomeAgr: Int

    fun valueEquals(other: IPropsHealth): Boolean
    fun hasParticy(term: WorkHealthTerms, incomeTerm: Int, incomeSpec: Int): Boolean
    fun roundedCompoundPaym(basisResult: Int): Int
    fun roundedEmployeePaym(basisResult: Int): Int
    fun roundedAugmentEmployeePaym(basisGenerals: Int, basisAugment: Int): Int
    fun roundedAugmentEmployerPaym(basisGenerals: Int, baseEmployee: Int, baseEmployer: Int): Int
    fun roundedEmployerPaym(basisResult: Int): Int
    fun <T : IParticyResult>annualsBasisCut(incomeList: Iterable<T>, annuityBasis: Int): Triple<Int, Int, Array<T>>
}