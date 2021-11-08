package org.hravemzdy.legalios.providers.period2019

import org.hravemzdy.legalios.providers.ProviderBase
import org.hravemzdy.legalios.providers.IProviderSocial
import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.props.PropsSocial
import org.hravemzdy.legalios.providers.period2013.HistoryConstHealth2013var08
import java.math.BigDecimal

class ProviderSocial2019 : ProviderBase(HistoryConstSocial2019.VERSION_CODE), IProviderSocial {

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
        return HistoryConstSocial2019.MAX_ANNUALS_BASIS
    }

    override fun factorEmployer(period: IPeriod): BigDecimal {
        if (isPeriodGreaterOrEqualThan(period, 2019, 7)) {
            return HistoryConstSocial2019var07.FACTOR_EMPLOYER
        }
        return HistoryConstSocial2019.FACTOR_EMPLOYER
    }

    override fun factorEmployerHigher(period: IPeriod): BigDecimal {
        return HistoryConstSocial2019.FACTOR_EMPLOYER_HIGHER
    }

    override fun factorEmployee(period: IPeriod): BigDecimal {
        return HistoryConstSocial2019.FACTOR_EMPLOYEE
    }

    override fun factorEmployeeGarant(period: IPeriod): BigDecimal {
        return HistoryConstSocial2019.FACTOR_EMPLOYEE_GARANT
    }

    override fun factorEmployeeReduce(period: IPeriod): BigDecimal {
        return HistoryConstSocial2019.FACTOR_EMPLOYEE_REDUCE
    }

    override fun marginIncomeEmp(period: IPeriod): Int {
        return HistoryConstSocial2019.MARGIN_INCOME_EMP
    }

    override fun marginIncomeAgr(period: IPeriod): Int {
        return HistoryConstSocial2019.MARGIN_INCOME_AGR
    }
}