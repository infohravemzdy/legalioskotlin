﻿package org.hravemzdy.legalios.providers.period2019

import org.hravemzdy.legalios.providers.period2018.HistoryConstHealth2018
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

object HistoryConstHealth2019 {
    const val VERSION_CODE = 2019

    const val MIN_MONTHLY_BASIS:Int = HistoryConstSalary2019.MIN_MONTHLY_WAGE
    const val MAX_ANNUALS_BASIS:Int = HistoryConstHealth2018.MAX_ANNUALS_BASIS
    const val LIM_MONTHLY_STATE:Int = HistoryConstHealth2018.LIM_MONTHLY_STATE
    const val LIM_MONTHLY_DIS50:Int = 7540
    val FACTOR_COMPOUND:BigDecimal = HistoryConstHealth2018.FACTOR_COMPOUND
    val FACTOR_EMPLOYEE:BigDecimal = HistoryConstHealth2018.FACTOR_EMPLOYEE
    const val MARGIN_INCOME_EMP:Int = 3000
    const val MARGIN_INCOME_AGR:Int = HistoryConstHealth2018.MARGIN_INCOME_AGR
}
