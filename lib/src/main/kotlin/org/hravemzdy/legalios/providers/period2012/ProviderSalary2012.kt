package org.hravemzdy.legalios.providers.period2012

import org.hravemzdy.legalios.providers.ProviderBase
import org.hravemzdy.legalios.providers.IProviderSalary
import org.hravemzdy.legalios.interfaces.IPropsSalary
import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.props.PropsSalary

class ProviderSalary2012 : ProviderBase(HistoryConstSalary2012.VERSION_CODE), IProviderSalary {

    override fun getProps(period: IPeriod): IPropsSalary {
        return PropsSalary(
            version,
            workingShiftWeek(period),
            workingShiftTime(period),
            minMonthlyWage(period),
            minHourlyWage(period)
        )
    }
    override fun workingShiftWeek(period: IPeriod): Int {
        return HistoryConstSalary2012.WORKING_SHIFT_WEEK
    }

    override fun workingShiftTime(period: IPeriod): Int {
        return HistoryConstSalary2012.WORKING_SHIFT_TIME
    }

    override fun minMonthlyWage(period: IPeriod): Int {
        return HistoryConstSalary2012.MIN_MONTHLY_WAGE
    }

    override fun minHourlyWage(period: IPeriod): Int {
        return HistoryConstSalary2012.MIN_HOURLY_WAGE
    }
}