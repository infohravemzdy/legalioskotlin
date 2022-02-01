package org.hravemzdy.legalios.providers.period2014

import org.hravemzdy.legalios.providers.ProviderBase
import org.hravemzdy.legalios.providers.IProviderHealth
import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.props.PropsHealth
import org.hravemzdy.legalios.props.PropsHealth2014
import org.hravemzdy.legalios.providers.period2013.HistoryConstHealth2013var08
import java.math.BigDecimal

class ProviderHealth2014 : ProviderBase(HistoryConstHealth2014.VERSION_CODE), IProviderHealth {

    override fun getProps(period: IPeriod): IPropsHealth {
        return PropsHealth2014(
            version,
            minMonthlyBasis(period),
            maxAnnualsBasis(period),
            limMonthlyState(period),
            limMonthlyDis50(period),
            factorCompound(period),
            factorEmployee(period),
            marginIncomeEmp(period),
            marginIncomeAgr(period)
        )
    }

    override fun minMonthlyBasis(period: IPeriod): Int {
        return HistoryConstHealth2014.MIN_MONTHLY_BASIS
    }

    override fun maxAnnualsBasis(period: IPeriod): Int {
        return HistoryConstHealth2014.MAX_ANNUALS_BASIS
    }

    override fun limMonthlyState(period: IPeriod): Int {
        return HistoryConstHealth2014.LIM_MONTHLY_STATE
    }

    override fun limMonthlyDis50(period: IPeriod): Int {
        if (isPeriodGreaterOrEqualThan(period, 2014, 7)) {
            return HistoryConstHealth2014var07.LIM_MONTHLY_DIS50
        }
        return HistoryConstHealth2014.LIM_MONTHLY_DIS50
    }

    override fun factorCompound(period: IPeriod): BigDecimal {
        return HistoryConstHealth2014.FACTOR_COMPOUND
    }

    override fun factorEmployee(period: IPeriod):BigDecimal {
        return HistoryConstHealth2014.FACTOR_EMPLOYEE
    }

    override fun marginIncomeEmp(period: IPeriod): Int {
        return HistoryConstHealth2014.MARGIN_INCOME_EMP
    }

    override fun marginIncomeAgr(period: IPeriod): Int {
        return HistoryConstHealth2014.MARGIN_INCOME_AGR
    }
}