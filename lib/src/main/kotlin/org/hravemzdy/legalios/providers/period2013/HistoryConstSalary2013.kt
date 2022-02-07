package org.hravemzdy.legalios.providers.period2013

import org.hravemzdy.legalios.providers.period2012.HistoryConstSalary2012

// WORKING_SHIFT_WEEK      Počet pracovních dnů v týdnu
//
// WORKING_SHIFT_TIME      Počet pracovních hodin denně
//
// MIN_MONTHLY_WAGE        Minimální mzda měsíční
//
// MIN_HOURLY_WAGE         Minimální mzda hodinová (100*Kč)

object HistoryConstSalary2013var08 {
    const val MIN_MONTHLY_WAGE:Int = 8500
    const val MIN_HOURLY_WAGE:Int = 5060
}

object HistoryConstSalary2013 {
    const val VERSION_CODE:Int = 2013

    const val WORKING_SHIFT_WEEK:Int = HistoryConstSalary2012.WORKING_SHIFT_WEEK
    const val WORKING_SHIFT_TIME:Int = HistoryConstSalary2012.WORKING_SHIFT_TIME
    const val MIN_MONTHLY_WAGE:Int = HistoryConstSalary2012.MIN_MONTHLY_WAGE
    const val MIN_HOURLY_WAGE:Int = HistoryConstSalary2012.MIN_HOURLY_WAGE
}

