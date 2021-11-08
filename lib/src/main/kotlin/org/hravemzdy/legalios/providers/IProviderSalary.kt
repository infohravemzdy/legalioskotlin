package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.interfaces.IPropsSalary

interface IProviderSalary : IPropsProvider<IPropsSalary> {
    fun workingShiftWeek(period: IPeriod): Int
    fun workingShiftTime(period: IPeriod): Int
    fun minMonthlyWage(period: IPeriod): Int
    fun minHourlyWage(period: IPeriod): Int
}