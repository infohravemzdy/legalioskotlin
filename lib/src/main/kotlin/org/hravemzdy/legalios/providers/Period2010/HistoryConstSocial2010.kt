package org.hravemzdy.legalios.providers.Period2010

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

object HistoryConstSocial2010 {
    const val VERSION_CODE:Int = 2010

    const val MAX_ANNUALS_BASIS:Int = 1707048
    val FACTOR_EMPLOYER: BigDecimal = BigDecimal("25")
    val FACTOR_EMPLOYER_HIGHER:BigDecimal = BigDecimal.ZERO
    val FACTOR_EMPLOYEE:BigDecimal = BigDecimal("6.5")
    val FACTOR_EMPLOYEE_REDUCE:BigDecimal = BigDecimal.ZERO
    val FACTOR_EMPLOYEE_GARANT:BigDecimal = BigDecimal.ZERO
    const val MARGIN_INCOME_EMP:Int = 2000
    const val MARGIN_INCOME_AGR:Int = 0
}
