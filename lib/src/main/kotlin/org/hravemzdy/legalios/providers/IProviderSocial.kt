package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.interfaces.IPropsSocial
import java.math.BigDecimal

interface IProviderSocial : IPropsProvider<IPropsSocial> {
    fun maxAnnualsBasis(period: IPeriod): Int
    fun factorEmployer(period: IPeriod): BigDecimal
    fun factorEmployerHigher(period: IPeriod): BigDecimal
    fun factorEmployee(period: IPeriod): BigDecimal
    fun factorEmployeeGarant(period: IPeriod): BigDecimal
    fun factorEmployeeReduce(period: IPeriod): BigDecimal
    fun marginIncomeEmp(period: IPeriod): Int
    fun marginIncomeAgr(period: IPeriod): Int
}