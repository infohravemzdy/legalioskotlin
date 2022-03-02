package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.service.types.*
import java.math.BigDecimal
import kotlin.math.max
import kotlin.math.min

class PropsTaxing(version: VersionId,
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
        // Tax income for advance from Year 2014 to Year 2017
        //*****************************************************************************
        // - withhold tax (non-signed declaration) and income
        // if (period.Year >= 2018)
        // -- income from DPP is less than X CZK
        // -- income from low-income employment is less than X CZK
        // -- income from statutory employment and non-resident is always withhold tax

        var withholdIncome: Boolean = false
        if (signOpt != TaxDeclSignOption.DECL_TAX_NO_SIGNED)
        {
            return false
        }
        if (noneOpt != TaxNoneSignOption.NOSIGN_TAX_WITHHOLD)
        {
            return false
        }
        if (termOpt == WorkTaxingTerms.TAXING_TERM_AGREEM_TASK)
        {
            if (marginIncomeOfWthAgr == 0 || incomeSum <= marginIncomeOfWthAgr)
            {
                if (incomeSum > 0)
                {
                    withholdIncome = true
                }
            }
        }
        else if (termOpt == WorkTaxingTerms.TAXING_TERM_EMPLOYMENTS)
        {
            if (marginIncomeOfWthEmp == 0 || incomeSum <= marginIncomeOfWthEmp)
            {
                if (incomeSum > 0)
                {
                    withholdIncome = true
                }
            }
        }
        else if (termOpt == WorkTaxingTerms.TAXING_TERM_STATUT_PART)
        {
            if (incomeSum > 0)
            {
                withholdIncome = true
            }
        }
        return withholdIncome
    }
    override fun roundedAdvancesPaym(supersResult: Int, basisResult: Int): Int {
        val factorAdvances = OperationsDec.divide(factorAdvances, 100.toBigDecimal())
        val factorTaxRate2 = OperationsDec.divide(factorTaxRate2, 100.toBigDecimal())

        var taxRate1Basis: Int = basisResult
        var taxRate2Basis: Int = 0
        if (marginIncomeOfTaxRate2 != 0)
        {
            taxRate1Basis = min(basisResult, marginIncomeOfTaxRate2)
            taxRate2Basis = max(0, basisResult - marginIncomeOfTaxRate2)
        }
        var taxRate1Taxing: BigDecimal
        if (basisResult <= marginIncomeOfRounding)
        {
            taxRate1Taxing = OperationsDec.multiply(taxRate1Basis.toBigDecimal(), factorAdvances)
        }
        else
        {
            taxRate1Taxing = OperationsDec.multiply(taxRate1Basis.toBigDecimal(), factorAdvances)
        }
        var taxRate2Taxing: BigDecimal = BigDecimal.ZERO
        if (marginIncomeOfTaxRate2 != 0)
        {
            taxRate2Taxing = OperationsDec.multiply(taxRate2Basis.toBigDecimal(), factorTaxRate2)
        }
        return intTaxRoundUp(taxRate1Taxing + taxRate2Taxing)
    }

    companion object {
        fun empty(): IPropsTaxing {
            return PropsTaxing(VERSION_ZERO)
        }
    }
}