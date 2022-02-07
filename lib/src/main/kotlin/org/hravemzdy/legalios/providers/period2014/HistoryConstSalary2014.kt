package org.hravemzdy.legalios.providers.period2014

import org.hravemzdy.legalios.providers.period2013.HistoryConstSalary2013
import org.hravemzdy.legalios.providers.period2013.HistoryConstSalary2013var08

// WORKING_SHIFT_WEEK      Počet pracovních dnů v týdnu
//
// WORKING_SHIFT_TIME      Počet pracovních hodin denně
//
// MIN_MONTHLY_WAGE        Minimální mzda měsíční
//
// MIN_HOURLY_WAGE         Minimální mzda hodinová (100*Kč)

object HistoryConstSalary2014 {
    const val VERSION_CODE = 2014

    const val WORKING_SHIFT_WEEK:Int = HistoryConstSalary2013.WORKING_SHIFT_WEEK
    const val WORKING_SHIFT_TIME:Int = HistoryConstSalary2013.WORKING_SHIFT_TIME
    const val MIN_MONTHLY_WAGE:Int = HistoryConstSalary2013var08.MIN_MONTHLY_WAGE
    const val MIN_HOURLY_WAGE:Int = HistoryConstSalary2013var08.MIN_HOURLY_WAGE
}

