package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.interfaces.IPropsTaxing
import java.math.BigDecimal

interface IProviderTaxing : IPropsProvider<IPropsTaxing> {
    fun allowancePayer(period: IPeriod): Int
    fun allowanceDisab1st(period: IPeriod): Int
    fun allowanceDisab2nd(period: IPeriod): Int
    fun allowanceDisab3rd(period: IPeriod): Int
    fun allowanceStudy(period: IPeriod): Int
    fun allowanceChild1st(period: IPeriod): Int
    fun allowanceChild2nd(period: IPeriod): Int
    fun allowanceChild3rd(period: IPeriod): Int
    fun factorAdvances(period: IPeriod): BigDecimal
    fun factorWithhold(period: IPeriod): BigDecimal
    fun factorSolidary(period: IPeriod): BigDecimal
    fun factorTaxRate2(period: IPeriod): BigDecimal
    fun minAmountOfTaxBonus(period: IPeriod): Int
    fun maxAmountOfTaxBonus(period: IPeriod): Int
    fun marginIncomeOfTaxBonus(period: IPeriod): Int
    fun marginIncomeOfRounding(period: IPeriod): Int
    fun marginIncomeOfWithhold(period: IPeriod): Int
    fun marginIncomeOfSolidary(period: IPeriod): Int
    fun marginIncomeOfTaxRate2(period: IPeriod): Int
    fun marginIncomeOfWthEmp(period: IPeriod): Int
    fun marginIncomeOfWthAgr(period: IPeriod): Int
}