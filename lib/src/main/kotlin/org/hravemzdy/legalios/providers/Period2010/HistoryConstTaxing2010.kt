package org.hravemzdy.legalios.providers.Period2010

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
// MARGIN_INCOME_OF_SOLIDARY        Minimální výše příjmu pro solidární zvýšení daně
//
// MARGIN_INCOME_OF_TAXRATE2        Minimální výše příjmu pro druhé pásmo daně
//
// MARGIN_INCOME_OF_WHT_AGR         hranice příjmu pro srážkovou daň pro zaměstnace v pracovním poměru (nepodepsal prohlášení)
//
// MARGIN_INCOME_OF_WHT_EMP         hranice příjmu pro srážkovou daň pro zaměstnace na dohodu (nepodepsal prohlášení)

object HistoryConstTaxing2010 {
    const val VERSION_CODE:Int = 2010

    const val ALLOWANCE_PAYER:Int = 2070
    const val ALLOWANCE_DISAB_1ST:Int = 210
    const val ALLOWANCE_DISAB_2ND:Int = 420
    const val ALLOWANCE_DISAB_3RD:Int = 1345
    const val ALLOWANCE_STUDY:Int = 335
    const val ALLOWANCE_CHILD_1ST:Int = 967
    const val ALLOWANCE_CHILD_2ND:Int = 967
    const val ALLOWANCE_CHILD_3RD:Int = 967
    val FACTOR_ADVANCES:BigDecimal = BigDecimal("15")
    val FACTOR_WITHHOLD:BigDecimal = BigDecimal("15")
    val FACTOR_SOLIDARY:BigDecimal = BigDecimal.ZERO
    val FACTOR_TAXRATE2:BigDecimal = BigDecimal.ZERO
    const val MIN_AMOUNT_OF_TAXBONUS:Int = 50
    const val MAX_AMOUNT_OF_TAXBONUS:Int = 4350
    const val MARGIN_INCOME_OF_TAXBONUS:Int = (HistoryConstSalary2010.MIN_MONTHLY_WAGE / 2)
    const val MARGIN_INCOME_OF_ROUNDING:Int = 100
    const val MARGIN_INCOME_OF_WITHHOLD:Int = 5000
    const val MARGIN_INCOME_OF_SOLIDARY:Int = 0
    const val MARGIN_INCOME_OF_TAXRATE2:Int = 0
    const val MARGIN_INCOME_OF_WHT_EMP:Int = 0
    const val MARGIN_INCOME_OF_WHT_AGR:Int = 0
}
