package org.hravemzdy.legalios.providers.period2019

import org.hravemzdy.legalios.providers.ProviderBase
import org.hravemzdy.legalios.providers.IProviderHealth
import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.props.PropsHealth
import java.math.BigDecimal

class ProviderHealth2019 : ProviderBase(HistoryConstHealth2019.VERSION_CODE), IProviderHealth {

    override fun getProps(period: IPeriod): IPropsHealth {
        return PropsHealth(
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
        return HistoryConstHealth2019.MIN_MONTHLY_BASIS
    }

    override fun maxAnnualsBasis(period: IPeriod): Int {
        return HistoryConstHealth2019.MAX_ANNUALS_BASIS
    }

    override fun limMonthlyState(period: IPeriod): Int {
        return HistoryConstHealth2019.LIM_MONTHLY_STATE
    }

    override fun limMonthlyDis50(period: IPeriod): Int {
        return HistoryConstHealth2019.LIM_MONTHLY_DIS50
    }

    override fun factorCompound(period: IPeriod): BigDecimal {
        return HistoryConstHealth2019.FACTOR_COMPOUND
    }

    override fun factorEmployee(period: IPeriod):BigDecimal {
        return HistoryConstHealth2019.FACTOR_EMPLOYEE
    }

    override fun marginIncomeEmp(period: IPeriod): Int {
        return HistoryConstHealth2019.MARGIN_INCOME_EMP
    }

    override fun marginIncomeAgr(period: IPeriod): Int {
        return HistoryConstHealth2019.MARGIN_INCOME_AGR
    }
}