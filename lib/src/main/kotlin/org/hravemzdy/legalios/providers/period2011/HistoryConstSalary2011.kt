package org.hravemzdy.legalios.providers.period2011

import org.hravemzdy.legalios.providers.Period2010.HistoryConstSalary2010

// WORKING_SHIFT_WEEK      Počet pracovních dnů v týdnu
//
// WORKING_SHIFT_TIME      Počet pracovních hodin denně
//
// MIN_MONTHLY_WAGE        Minimální mzda měsíční
//
// MIN_HOURLY_WAGE         Minimální mzda hodinová (100*Kč)

object HistoryConstSalary2011 {
    const val VERSION_CODE = 2011

    const val WORKING_SHIFT_WEEK:Int = HistoryConstSalary2010.WORKING_SHIFT_WEEK
    const val WORKING_SHIFT_TIME:Int = HistoryConstSalary2010.WORKING_SHIFT_TIME
    const val MIN_MONTHLY_WAGE:Int = HistoryConstSalary2010.MIN_MONTHLY_WAGE
    const val MIN_HOURLY_WAGE:Int = HistoryConstSalary2010.MIN_HOURLY_WAGE
}