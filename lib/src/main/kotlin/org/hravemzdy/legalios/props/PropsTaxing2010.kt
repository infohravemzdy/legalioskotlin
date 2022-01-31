package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.service.types.VersionId
import java.math.BigDecimal

class PropsTaxing2010(version: VersionId,
                      _allowancePayer: Int,
                      _allowanceDisab1st: Int,
                      _allowanceDisab2nd: Int,
                      _allowanceDisab3rd: Int,
                      _allowanceStudy: Int,
                      _allowanceChild1st: Int,
                      _allowanceChild2nd: Int,
                      _allowanceChild3rd: Int,
                      _factorAdvances: BigDecimal,
                      _factorWithhold: BigDecimal,
                      _factorSolitary: BigDecimal,
                      _factorTaxRate2: BigDecimal,
                      _minAmountOfTaxBonus: Int,
                      _maxAmountOfTaxBonus: Int,
                      _marginIncomeOfTaxBonus: Int,
                      _marginIncomeOfRounding: Int,
                      _marginIncomeOfWithhold: Int,
                      _marginIncomeOfSolitary: Int,
                      _marginIncomeOfTaxRate2: Int,
                      _marginIncomeOfWthEmp: Int,
                      _marginIncomeOfWthAgr: Int) :
    PropsTaxingBase(version,
        _allowancePayer,
        _allowanceDisab1st,
        _allowanceDisab2nd,
        _allowanceDisab3rd,
        _allowanceStudy,
        _allowanceChild1st,
        _allowanceChild2nd,
        _allowanceChild3rd,
        _factorAdvances,
        _factorWithhold,
        _factorSolitary,
        _factorTaxRate2,
        _minAmountOfTaxBonus,
        _maxAmountOfTaxBonus,
        _marginIncomeOfTaxBonus,
        _marginIncomeOfRounding,
        _marginIncomeOfWithhold,
        _marginIncomeOfSolitary,
        _marginIncomeOfTaxRate2,
        _marginIncomeOfWthEmp,
        _marginIncomeOfWthAgr), IPropsTaxing {

    constructor(version: Int) : this(
        VersionId.get(version),
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0)

    companion object {
        fun empty(): IPropsTaxing {
            return PropsTaxing2010(VERSION_ZERO)
        }
    }
}