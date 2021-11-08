package org.hravemzdy.legalios.providers.period2014

import org.hravemzdy.legalios.providers.period2013.HistoryConstSocial2013
import org.hravemzdy.legalios.providers.period2013.HistoryConstSocial2013var02
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

object HistoryConstSocial2014 {
    const val VERSION_CODE:Int = 2014

    const val MAX_ANNUALS_BASIS:Int = 1245216
    val FACTOR_EMPLOYER:BigDecimal = HistoryConstSocial2013.FACTOR_EMPLOYER
    val FACTOR_EMPLOYER_HIGHER:BigDecimal = HistoryConstSocial2013.FACTOR_EMPLOYER_HIGHER
    val FACTOR_EMPLOYEE:BigDecimal = HistoryConstSocial2013.FACTOR_EMPLOYEE
    val FACTOR_EMPLOYEE_REDUCE:BigDecimal = HistoryConstSocial2013var02.FACTOR_EMPLOYEE_REDUCE
    val FACTOR_EMPLOYEE_GARANT:BigDecimal = HistoryConstSocial2013var02.FACTOR_EMPLOYEE_GARANT
    const val MARGIN_INCOME_EMP:Int = HistoryConstSocial2013.MARGIN_INCOME_EMP
    const val MARGIN_INCOME_AGR:Int = HistoryConstSocial2013.MARGIN_INCOME_AGR
}


