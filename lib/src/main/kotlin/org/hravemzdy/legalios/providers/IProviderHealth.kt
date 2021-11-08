package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.interfaces.IPropsHealth
import java.math.BigDecimal

interface IProviderHealth : IPropsProvider<IPropsHealth> {
    fun minMonthlyBasis(period: IPeriod): Int
    fun maxAnnualsBasis(period: IPeriod): Int
    fun limMonthlyState(period: IPeriod): Int
    fun limMonthlyDis50(period: IPeriod): Int
    fun factorCompound(period: IPeriod): BigDecimal
    fun factorEmployee(period: IPeriod): BigDecimal
    fun marginIncomeEmp(period: IPeriod): Int
    fun marginIncomeAgr(period: IPeriod): Int
}