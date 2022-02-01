package org.hravemzdy.legalios.providers.period2017

import org.hravemzdy.legalios.providers.period2016.HistoryConstHealth2016
import java.math.BigDecimal

// MIN_MONTHLY_BASIS     Minimální základ zdravotního pojištění na jednoho pracovníka
//
// MAX_ANNUALS_BASIS     Maximální roční vyměřovací základ na jednoho pracovníka (tzv.strop)
//
// LIM_MONTHLY_STATE     Vyměřovací základ ze kterého platí pojistné stát za státní pojištěnce (mateřská, studenti, důchodci)
//
// LIM_MONTHLY_DIS50     Vyměřovací základ ze kterého platí pojistné stát za státní pojištěnce (mateřská, studenti, důchodci)
//                      u zaměstnavatele zaměstnávajícího více než 50% osob OZP
// FACTOR_COMPOUND       složená sazba zdravotního pojištění (zaměstnace + zaměstnavatele)
//
// FACTOR_EMPLOYEE       podíl sazby zdravotního pojištění připadajícího na zaměstnace (1/FACTOR_EMPLOYEE)
//
// MARGIN_INCOME_EMP     hranice příjmu pro vznik účasti na pojištění pro zaměstnace v pracovním poměru
//
// MARGIN_INCOME_AGR     hranice příjmu pro vznik účasti na pojištění pro zaměstnace na dohodu

object HistoryConstHealth2017 {
    const val VERSION_CODE = 2017

    const val MIN_MONTHLY_BASIS:Int = HistoryConstSalary2017.MIN_MONTHLY_WAGE
    const val MAX_ANNUALS_BASIS:Int = HistoryConstHealth2016.MAX_ANNUALS_BASIS
    const val LIM_MONTHLY_STATE:Int = HistoryConstHealth2016.LIM_MONTHLY_STATE
    const val LIM_MONTHLY_DIS50:Int = 6814
    val FACTOR_COMPOUND:BigDecimal = HistoryConstHealth2016.FACTOR_COMPOUND
    val FACTOR_EMPLOYEE:BigDecimal = HistoryConstHealth2016.FACTOR_EMPLOYEE
    const val MARGIN_INCOME_EMP:Int = HistoryConstHealth2016.MARGIN_INCOME_EMP
    const val MARGIN_INCOME_AGR:Int = HistoryConstHealth2016.MARGIN_INCOME_AGR
}
