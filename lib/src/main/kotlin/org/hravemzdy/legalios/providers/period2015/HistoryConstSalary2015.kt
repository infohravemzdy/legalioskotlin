package org.hravemzdy.legalios.providers.period2015

import org.hravemzdy.legalios.providers.period2014.HistoryConstSalary2014

// WORKING_SHIFT_WEEK      Počet pracovních dnů v týdnu
//
// WORKING_SHIFT_TIME      Počet pracovních hodin denně
//
// MIN_MONTHLY_WAGE        Minimální mzda měsíční
//
// MIN_HOURLY_WAGE         Minimální mzda hodinová (100*Kč)

object HistoryConstSalary2015 {
    const val VERSION_CODE = 2015

    const val WORKING_SHIFT_WEEK:Int = HistoryConstSalary2014.WORKING_SHIFT_WEEK
    const val WORKING_SHIFT_TIME:Int = HistoryConstSalary2014.WORKING_SHIFT_TIME
    const val MIN_MONTHLY_WAGE:Int = 9200
    const val MIN_HOURLY_WAGE:Int = 5500
}

