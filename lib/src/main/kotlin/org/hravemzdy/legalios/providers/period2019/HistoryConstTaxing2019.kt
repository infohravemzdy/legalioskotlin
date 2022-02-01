package org.hravemzdy.legalios.providers.period2019

import org.hravemzdy.legalios.providers.Period2010.HistoryConstTaxing2010
import org.hravemzdy.legalios.providers.period2018.HistoryConstTaxing2018
import java.math.BigDecimal

// ALLOWANCE_PAYER                  Částka slevy na poplatníka
//
// ALLOWANCE_DISAB_1ST              Částka slevy na invaliditu 1.stupně poplatníka
//
// ALLOWANCE_DISAB_2ND              Částka slevy na invaliditu 2.stupně poplatníka
//
// ALLOWANCE_DISAB_3RD              Částka slevy na invaliditu 3.stupně poplatníka
//
// ALLOWANCE_STUDY                  Částka slevy na poplatníka studenta
//
// ALLOWANCE_CHILD_1ST              Částka slevy na dítě 1.pořadí
//
// ALLOWANCE_CHILD_2ND              Částka slevy na dítě 2.pořadí
//
// ALLOWANCE_CHILD_3RD              Částka slevy na dítě 3.pořadí
//
// FACTOR_ADVANCES                  Sazba daně na zálohový příjem
//
// FACTOR_WITHHOLD                  Sazba daně na srážkový příjem
//
// FACTOR_SOLIDARY                  Sazba daně na solidární zvýšení
//
// FACTOR_TAXRATE2                  Sazba daně pro druhé pásmo daně
//
// MIN_AMOUNT_OF_TAXBONUS           Minimální částka pro daňový bonus
//
// MAX_AMOUNT_OF_TAXBONUS           Maximální částka pro daňový bonus
//
// MARGIN_INCOME_OF_TAXBONUS        Minimální výše příjmu pro nároku na daňový bonus
//
// MARGIN_INCOME_OF_ROUNDING        Maximální výše příjmu pro zaokrouhlování
//
// MARGIN_INCOME_OF_WITHHOLD        Maximální výše příjmu pro srážkový příjem
//
// MARGIN_INCOME_OF_TAXRATE2        Minimální výše příjmu pro druhé pásmo daně
//
// MARGIN_INCOME_OF_SOLIDARY        Minimální výše příjmu pro solidární zvýšení daně
//
// MARGIN_INCOME_OF_WHT_AGR         hranice příjmu pro srážkovou daň pro zaměstnace v pracovním poměru (nepodepsal prohlášení)
//
// MARGIN_INCOME_OF_WHT_EMP         hranice příjmu pro srážkovou daň pro zaměstnace na dohodu (nepodepsal prohlášení)

object HistoryConstTaxing2019var05 {
    const val MARGIN_INCOME_OF_WHT_EMP:Int = 3000
}

object HistoryConstTaxing2019 {
    const val VERSION_CODE:Int = 2019

    const val ALLOWANCE_PAYER:Int = HistoryConstTaxing2018.ALLOWANCE_PAYER
    const val ALLOWANCE_DISAB_1ST:Int = HistoryConstTaxing2018.ALLOWANCE_DISAB_1ST
    const val ALLOWANCE_DISAB_2ND:Int = HistoryConstTaxing2018.ALLOWANCE_DISAB_2ND
    const val ALLOWANCE_DISAB_3RD:Int = HistoryConstTaxing2018.ALLOWANCE_DISAB_3RD
    const val ALLOWANCE_STUDY:Int = HistoryConstTaxing2018.ALLOWANCE_STUDY
    const val ALLOWANCE_CHILD_1ST:Int = HistoryConstTaxing2018.ALLOWANCE_CHILD_1ST
    const val ALLOWANCE_CHILD_2ND:Int = HistoryConstTaxing2018.ALLOWANCE_CHILD_2ND
    const val ALLOWANCE_CHILD_3RD:Int = HistoryConstTaxing2018.ALLOWANCE_CHILD_3RD
    val FACTOR_ADVANCES:BigDecimal = HistoryConstTaxing2018.FACTOR_ADVANCES
    val FACTOR_WITHHOLD:BigDecimal = HistoryConstTaxing2018.FACTOR_WITHHOLD
    val FACTOR_SOLIDARY:BigDecimal = HistoryConstTaxing2018.FACTOR_SOLIDARY
    val FACTOR_TAXRATE2:BigDecimal = HistoryConstTaxing2018.FACTOR_TAXRATE2
    const val MIN_AMOUNT_OF_TAXBONUS:Int = HistoryConstTaxing2018.MIN_AMOUNT_OF_TAXBONUS
    const val MAX_AMOUNT_OF_TAXBONUS:Int = HistoryConstTaxing2018.MAX_AMOUNT_OF_TAXBONUS
    const val MARGIN_INCOME_OF_TAXBONUS:Int = (HistoryConstSalary2019.MIN_MONTHLY_WAGE / 2)
    const val MARGIN_INCOME_OF_ROUNDING:Int = HistoryConstTaxing2018.MARGIN_INCOME_OF_ROUNDING
    const val MARGIN_INCOME_OF_WITHHOLD:Int = HistoryConstTaxing2018.MARGIN_INCOME_OF_WITHHOLD
    const val MARGIN_INCOME_OF_SOLIDARY:Int = (4 * 32699)
    const val MARGIN_INCOME_OF_TAXRATE2:Int = HistoryConstTaxing2018.MARGIN_INCOME_OF_TAXRATE2
    const val MARGIN_INCOME_OF_WHT_EMP:Int = HistoryConstTaxing2018.MARGIN_INCOME_OF_WHT_EMP
    const val MARGIN_INCOME_OF_WHT_AGR:Int = HistoryConstTaxing2018.MARGIN_INCOME_OF_WHT_AGR
}

