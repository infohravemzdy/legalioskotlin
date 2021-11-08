package org.hravemzdy.legalios.providers.period2020

import org.hravemzdy.legalios.providers.ProviderBase
import org.hravemzdy.legalios.providers.IProviderSocial
import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.props.PropsSocial
import java.math.BigDecimal

class ProviderSocial2020 : ProviderBase(HistoryConstSocial2020.VERSION_CODE), IProviderSocial {

    override fun getProps(period: IPeriod): IPropsSocial {
        return PropsSocial(
            version,
            maxAnnualsBasis(period),
            factorEmployer(period),
            factorEmployerHigher(period),
            factorEmployee(period),
            factorEmployeeGarant(period),
            factorEmployeeReduce(period),
            marginIncomeEmp(period),
            marginIncomeAgr(period))
    }

    override fun maxAnnualsBasis(period: IPeriod): Int {
        return HistoryConstSocial2020.MAX_ANNUALS_BASIS
    }

    override fun factorEmployer(period: IPeriod): BigDecimal {
        return HistoryConstSocial2020.FACTOR_EMPLOYER
    }

    override fun factorEmployerHigher(period: IPeriod): BigDecimal {
        return HistoryConstSocial2020.FACTOR_EMPLOYER_HIGHER
    }

    override fun factorEmployee(period: IPeriod): BigDecimal {
        return HistoryConstSocial2020.FACTOR_EMPLOYEE
    }

    override fun factorEmployeeGarant(period: IPeriod): BigDecimal {
        return HistoryConstSocial2020.FACTOR_EMPLOYEE_GARANT
    }

    override fun factorEmployeeReduce(period: IPeriod): BigDecimal {
        return HistoryConstSocial2020.FACTOR_EMPLOYEE_REDUCE
    }

    override fun marginIncomeEmp(period: IPeriod): Int {
        return HistoryConstSocial2020.MARGIN_INCOME_EMP
    }

    override fun marginIncomeAgr(period: IPeriod): Int {
        return HistoryConstSocial2020.MARGIN_INCOME_AGR
    }
}