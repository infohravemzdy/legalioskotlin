package org.hravemzdy.legalios.providers.period2020

import org.hravemzdy.legalios.providers.period2019.HistoryConstSocial2019
import org.hravemzdy.legalios.providers.period2019.HistoryConstSocial2019var07
import java.math.BigDecimal

// MAX_ANNUALS_BASIS            Maximální roční vyměřovací základ na jednoho pracovníka (tzv.strop)
//
// FACTOR_EMPLOYER              Sazba - standardní sociálního pojištění - zaměstnavatele
//
// FACTOR_EMPLOYER_HIGHER       Sazba - vyší sociálního pojištění - zaměstnavatele
//
// FACTOR_EMPLOYEE              Sazba sociálního pojištění - zaměstnance
//
// FACTOR_EMPLOYEE_REDUCE       Snížení sazby sociálního pojištění - zaměstnance - s důchodovým spořením
//
// FACTOR_EMPLOYEE_GARANT       Sazba důchodového spoření - zaměstnance - s důchodovým spořením
//
// MARGIN_INCOME_EMP            hranice příjmu pro vznik účasti na pojištění pro zaměstnace v pracovním poměru
//
// MARGIN_INCOME_AGR            hranice příjmu pro vznik účasti na pojištění pro zaměstnace na dohodu

object HistoryConstSocial2020 {
    const val VERSION_CODE:Int = 2020

    const val MAX_ANNUALS_BASIS:Int = 1672080
    val FACTOR_EMPLOYER:BigDecimal = HistoryConstSocial2019var07.FACTOR_EMPLOYER
    val FACTOR_EMPLOYER_HIGHER:BigDecimal = HistoryConstSocial2019.FACTOR_EMPLOYER_HIGHER
    val FACTOR_EMPLOYEE:BigDecimal = HistoryConstSocial2019.FACTOR_EMPLOYEE
    val FACTOR_EMPLOYEE_REDUCE:BigDecimal = HistoryConstSocial2019.FACTOR_EMPLOYEE_REDUCE
    val FACTOR_EMPLOYEE_GARANT:BigDecimal = HistoryConstSocial2019.FACTOR_EMPLOYEE_GARANT
    const val MARGIN_INCOME_EMP:Int = HistoryConstSocial2019.MARGIN_INCOME_EMP
    const val MARGIN_INCOME_AGR:Int = HistoryConstSocial2019.MARGIN_INCOME_AGR
}

