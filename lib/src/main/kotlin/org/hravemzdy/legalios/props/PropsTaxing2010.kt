package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.service.types.*
import java.math.BigDecimal
import kotlin.math.max
import kotlin.math.min

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
                      _factorSolidary: BigDecimal,
                      _factorTaxRate2: BigDecimal,
                      _minAmountOfTaxBonus: Int,
                      _maxAmountOfTaxBonus: Int,
                      _marginIncomeOfTaxBonus: Int,
                      _marginIncomeOfRounding: Int,
                      _marginIncomeOfWithhold: Int,
                      _marginIncomeOfSolidary: Int,
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
        _factorSolidary,
        _factorTaxRate2,
        _minAmountOfTaxBonus,
        _maxAmountOfTaxBonus,
        _marginIncomeOfTaxBonus,
        _marginIncomeOfRounding,
        _marginIncomeOfWithhold,
        _marginIncomeOfSolidary,
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

    override fun hasWithholdIncome(termOpt: WorkTaxingTerms, signOpt: TaxDeclSignOption, noneOpt: TaxNoneSignOption, incomeSum: Int): Boolean {
        //*****************************************************************************
        // Tax income for advance from Year 2008 to Year 2013
        //*****************************************************************************
        // - withhold tax (non-signed declaration) and income is less than X CZK
        //*****************************************************************************

        var withholdIncome: Boolean = false
        if (signOpt != TaxDeclSignOption.DECL_TAX_NO_SIGNED)
        {
            return false
        }
        if (noneOpt != TaxNoneSignOption.NOSIGN_TAX_WITHHOLD)
        {
            return false
        }
        if (marginIncomeOfWithhold == 0 || incomeSum <= marginIncomeOfWithhold)
        {
            withholdIncome = true
        }
        return withholdIncome
    }
    override fun roundedAdvancesPaym(supersResult: Int, basisResult: Int): Int {
        val factorAdvances = OperationsDec.divide(factorAdvances, 100.toBigDecimal())

        var advanceTaxing: Int
        if (basisResult <= marginIncomeOfRounding)
        {
            advanceTaxing = intTaxRoundUp(OperationsDec.multiply(supersResult.toBigDecimal(), factorAdvances))
        }
        else
        {
            advanceTaxing = intTaxRoundUp(OperationsDec.multiply(supersResult.toBigDecimal(), factorAdvances))
        }

        return advanceTaxing
    }

    companion object {
        fun empty(): IPropsTaxing {
            return PropsTaxing2010(VERSION_ZERO)
        }
    }
}