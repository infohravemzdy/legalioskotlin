package org.hravemzdy.legalios.providers.period2018

import org.hravemzdy.legalios.providers.ProviderBase
import org.hravemzdy.legalios.providers.IProviderTaxing
import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.props.PropsTaxing
import org.hravemzdy.legalios.props.PropsTaxing2018
import org.hravemzdy.legalios.providers.Period2010.HistoryConstTaxing2010
import java.math.BigDecimal

class ProviderTaxing2018 : ProviderBase(HistoryConstTaxing2018.VERSION_CODE), IProviderTaxing {

    override fun getProps(period: IPeriod): IPropsTaxing {
        return PropsTaxing2018(
            version,
            allowancePayer(period),
            allowanceDisab1st(period),
            allowanceDisab2nd(period),
            allowanceDisab3rd(period),
            allowanceStudy(period),
            allowanceChild1st(period),
            allowanceChild2nd(period),
            allowanceChild3rd(period),
            factorAdvances(period),
            factorWithhold(period),
            factorSolidary(period),
            factorTaxRate2(period),
            minAmountOfTaxBonus(period),
            maxAmountOfTaxBonus(period),
            marginIncomeOfTaxBonus(period),
            marginIncomeOfRounding(period),
            marginIncomeOfWithhold(period),
            marginIncomeOfSolidary(period),
            marginIncomeOfTaxRate2(period),
            marginIncomeOfWthEmp(period),
            marginIncomeOfWthAgr(period))
    }

    override fun allowancePayer(period: IPeriod): Int {
        return HistoryConstTaxing2018.ALLOWANCE_PAYER
    }

    override fun allowanceDisab1st(period: IPeriod): Int {
        return HistoryConstTaxing2018.ALLOWANCE_DISAB_1ST
    }

    override fun allowanceDisab2nd(period: IPeriod): Int {
        return HistoryConstTaxing2018.ALLOWANCE_DISAB_2ND
    }

    override fun allowanceDisab3rd(period: IPeriod): Int {
        return HistoryConstTaxing2018.ALLOWANCE_DISAB_3RD
    }

    override fun allowanceStudy(period: IPeriod): Int {
        return HistoryConstTaxing2018.ALLOWANCE_STUDY
    }

    override fun allowanceChild1st(period: IPeriod): Int {
        return HistoryConstTaxing2018.ALLOWANCE_CHILD_1ST
    }

    override fun allowanceChild2nd(period: IPeriod): Int {
        return HistoryConstTaxing2018.ALLOWANCE_CHILD_2ND
    }

    override fun allowanceChild3rd(period: IPeriod): Int {
        return HistoryConstTaxing2018.ALLOWANCE_CHILD_3RD
    }

    override fun factorAdvances(period: IPeriod): BigDecimal {
        return HistoryConstTaxing2018.FACTOR_ADVANCES
    }

    override fun factorWithhold(period: IPeriod): BigDecimal {
        return HistoryConstTaxing2018.FACTOR_WITHHOLD
    }

    override fun factorSolidary(period: IPeriod): BigDecimal {
        return HistoryConstTaxing2018.FACTOR_SOLIDARY
    }

    override fun factorTaxRate2(period: IPeriod): BigDecimal {
        return HistoryConstTaxing2018.FACTOR_TAXRATE2
    }

    override fun minAmountOfTaxBonus(period: IPeriod): Int {
        return HistoryConstTaxing2018.MIN_AMOUNT_OF_TAXBONUS
    }

    override fun maxAmountOfTaxBonus(period: IPeriod): Int {
        return HistoryConstTaxing2018.MAX_AMOUNT_OF_TAXBONUS
    }

    override fun marginIncomeOfTaxBonus(period: IPeriod): Int {
        return HistoryConstTaxing2018.MARGIN_INCOME_OF_TAXBONUS
    }

    override fun marginIncomeOfRounding(period: IPeriod): Int {
        return HistoryConstTaxing2018.MARGIN_INCOME_OF_ROUNDING
    }

    override fun marginIncomeOfWithhold(period: IPeriod): Int {
        return HistoryConstTaxing2018.MARGIN_INCOME_OF_WITHHOLD
    }

    override fun marginIncomeOfSolidary(period: IPeriod): Int {
        return HistoryConstTaxing2018.MARGIN_INCOME_OF_SOLIDARY
    }

    override fun marginIncomeOfTaxRate2(period: IPeriod): Int {
        return HistoryConstTaxing2018.MARGIN_INCOME_OF_TAXRATE2
    }

    override fun marginIncomeOfWthEmp(period: IPeriod): Int {
        return HistoryConstTaxing2018.MARGIN_INCOME_OF_WHT_EMP
    }

    override fun marginIncomeOfWthAgr(period: IPeriod): Int {
        return HistoryConstTaxing2018.MARGIN_INCOME_OF_WHT_AGR
    }
}