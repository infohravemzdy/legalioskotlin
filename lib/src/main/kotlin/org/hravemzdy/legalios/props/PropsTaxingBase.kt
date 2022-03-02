package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.service.types.*
import java.math.BigDecimal
import kotlin.math.min
import kotlin.math.max

abstract class PropsTaxingBase(version: VersionId,
                      override val allowancePayer: Int,
                      override val allowanceDisab1st: Int,
                      override val allowanceDisab2nd: Int,
                      override val allowanceDisab3rd: Int,
                      override val allowanceStudy: Int,
                      override val allowanceChild1st: Int,
                      override val allowanceChild2nd: Int,
                      override val allowanceChild3rd: Int,
                      override val factorAdvances: BigDecimal,
                      override val factorWithhold: BigDecimal,
                      override val factorSolidary: BigDecimal,
                      override val factorTaxRate2: BigDecimal,
                      override val minAmountOfTaxBonus: Int,
                      override val maxAmountOfTaxBonus: Int,
                      override val marginIncomeOfTaxBonus: Int,
                      override val marginIncomeOfRounding: Int,
                      override val marginIncomeOfWithhold: Int,
                      override val marginIncomeOfSolidary: Int,
                      override val marginIncomeOfTaxRate2: Int,
                      override val marginIncomeOfWthEmp: Int,
                      override val marginIncomeOfWthAgr: Int) :
    PropsBase(version), IPropsTaxing {

    override fun valueEquals(other: IPropsTaxing?): Boolean {
        if (other == null)
        {
            return false
        }
        return (this.allowancePayer == other.allowancePayer &&
                this.allowanceDisab1st == other.allowanceDisab1st &&
                this.allowanceDisab2nd == other.allowanceDisab2nd &&
                this.allowanceDisab3rd == other.allowanceDisab3rd &&
                this.allowanceStudy == other.allowanceStudy &&
                this.allowanceChild1st == other.allowanceChild1st &&
                this.allowanceChild2nd == other.allowanceChild2nd &&
                this.allowanceChild3rd == other.allowanceChild3rd &&
                this.factorAdvances == other.factorAdvances &&
                this.factorWithhold == other.factorWithhold &&
                this.factorSolidary == other.factorSolidary &&
                this.factorTaxRate2 == other.factorTaxRate2 &&
                this.minAmountOfTaxBonus == other.minAmountOfTaxBonus &&
                this.maxAmountOfTaxBonus == other.maxAmountOfTaxBonus &&
                this.marginIncomeOfTaxBonus == other.marginIncomeOfTaxBonus &&
                this.marginIncomeOfRounding == other.marginIncomeOfRounding &&
                this.marginIncomeOfWithhold == other.marginIncomeOfWithhold &&
                this.marginIncomeOfSolidary == other.marginIncomeOfSolidary &&
                this.marginIncomeOfTaxRate2 == other.marginIncomeOfTaxRate2 &&
                this.marginIncomeOfWthEmp == other.marginIncomeOfWthEmp &&
                this.marginIncomeOfWthAgr == other.marginIncomeOfWthAgr)
    }

    fun intTaxRoundUp(valueDec: BigDecimal): Int {
        return OperationsRound.roundUp(valueDec)
    }
    fun intTaxRoundNearUp(valueDec: BigDecimal, nearest: Int = 100): Int {
        return OperationsRound.nearRoundUp(valueDec, nearest)
    }
    fun intTaxRoundDown(valueDec: BigDecimal): Int {
        return OperationsRound.roundDown(valueDec)
    }
    fun intTaxRoundNearDown(valueDec: BigDecimal, nearest: Int = 100): Int {
        return OperationsRound.nearRoundDown(valueDec, nearest)
    }

    fun decTaxRoundUp(valueDec: BigDecimal): BigDecimal {
        return OperationsRound.decRoundUp(valueDec)
    }

    fun decTaxRoundNearUp(valueDec: BigDecimal, nearest: Int = 100): BigDecimal {
        return OperationsRound.decNearRoundUp(valueDec, nearest)
    }
    fun decTaxRoundDown(valueDec: BigDecimal): BigDecimal {
        return OperationsRound.decRoundDown(valueDec)
    }
    fun decTaxRoundNearDown(valueDec: BigDecimal, nearest: Int = 100): BigDecimal {
        return OperationsRound.decNearRoundDown(valueDec, nearest)
    }

    abstract override fun hasWithholdIncome(termOpt: WorkTaxingTerms, signOpt: TaxDeclSignOption, noneOpt: TaxNoneSignOption, incomeSum: Int): Boolean

    override fun benefitAllowancePayer(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption): Int {
        var benefitValue: Int = 0
        if (signOpts == TaxDeclSignOption.DECL_TAX_DO_SIGNED)
        {
            if (benefitOpts == TaxDeclBenfOption.DECL_TAX_BENEF1)
            {
                benefitValue = allowancePayer
            }
        }
        return benefitValue
    }
    override fun benefitAllowanceDisab(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclDisabOption): Int {
        var benefitValue: Int = 0
        if (signOpts == TaxDeclSignOption.DECL_TAX_DO_SIGNED)
        {
            benefitValue = when (benefitOpts)
            {
                TaxDeclDisabOption.DECL_TAX_DISAB1 -> allowanceDisab1st
                TaxDeclDisabOption.DECL_TAX_DISAB2 -> allowanceDisab2nd
                TaxDeclDisabOption.DECL_TAX_DISAB3 -> allowanceDisab3rd
                else -> 0
            }
        }
        return benefitValue
    }
    override fun benefitAllowanceStudy(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption): Int {
        var benefitValue: Int = 0

        if (signOpts == TaxDeclSignOption.DECL_TAX_DO_SIGNED)
        {
            if (benefitOpts == TaxDeclBenfOption.DECL_TAX_BENEF1)
            {
                benefitValue = allowanceStudy
            }
        }
        return benefitValue
    }
    override fun benefitAllowanceChild(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption, benefitOrds: Int, disabelOpts: Int): Int {
        var benefitValue: Int = 0
        if (signOpts == TaxDeclSignOption.DECL_TAX_DO_SIGNED)
        {
            val benefitUnits: Int = when (benefitOrds) {
                0 -> allowanceChild1st
                1 -> allowanceChild2nd
                2 -> allowanceChild3rd
                else -> 0
            }
            if (benefitOpts == TaxDeclBenfOption.DECL_TAX_BENEF1)
            {
                if (disabelOpts == 1)
                {
                    benefitValue = benefitUnits * 2
                }
                else
                {
                    benefitValue = benefitUnits
                }
            }
        }
        return benefitValue
    }
    override fun bonusChildRaw(income: Int, benefit: Int, rebated: Int): Int {
        var bonusForChild: BigDecimal = min(0, rebated - benefit).toBigDecimal().negate()

        if (marginIncomeOfTaxBonus > 0)
        {
            if (income < marginIncomeOfTaxBonus)
            {
                bonusForChild = BigDecimal.ZERO
            }
        }
        return OperationsRound.roundToInt(bonusForChild)
    }
    override fun bonusChildFix(income: Int, benefit: Int, rebated: Int): Int {
        var childBonus = bonusChildRaw(income, benefit, rebated)

        if (minAmountOfTaxBonus > 0)
        {
            if (childBonus < minAmountOfTaxBonus)
            {
                return 0
            }
        }
        if (maxAmountOfTaxBonus > 0)
        {
            if (childBonus > maxAmountOfTaxBonus)
            {
                return maxAmountOfTaxBonus
            }
        }
        return childBonus
    }

    override fun taxableIncomeSupers(incomeResult: Int, healthResult: Int, socialResult: Int): Int {
        return taxableIncomeBasis(incomeResult + healthResult + socialResult)
    }

    override fun taxableIncomeBasis(incomeResult: Int): Int {
        val taxableSuper: Int = max(0, incomeResult)
        return taxableSuper
    }

    override fun roundedBaseAdvances(incomeResult: Int, healthResult: Int, socialResult: Int): Int {
        val advanceBase = roundedBaseAdvances(incomeResult + healthResult + socialResult)

        return advanceBase
    }

    override fun roundedBaseAdvances(incomeResult: Int): Int {
        val amountForCalc: Int = taxableIncomeBasis(incomeResult)

        var advanceBase: Int
        if (amountForCalc <= marginIncomeOfRounding)
        {
            advanceBase = intTaxRoundUp(amountForCalc.toBigDecimal())
        }
        else
        {
            advanceBase = intTaxRoundNearUp(amountForCalc.toBigDecimal(), 100)
        }
        return advanceBase
    }

    override fun roundedBaseSolidary(incomeResult: Int): Int {
        var solidaryBase: Int = 0

        val taxableIncome: Int = max(0, incomeResult)
        if (marginIncomeOfSolidary != 0)
        {
            solidaryBase = max(0, taxableIncome - marginIncomeOfSolidary)
        }
        return solidaryBase
    }
    abstract override fun roundedAdvancesPaym(supersResult: Int, basisResult: Int): Int

    override fun roundedSolidaryPaym(basisResult: Int): Int {
        val factorSolidary = OperationsDec.divide(factorSolidary, 100.toBigDecimal())

        var solidaryTaxing: Int = 0
        if (marginIncomeOfSolidary != 0)
        {
            solidaryTaxing = intTaxRoundUp(OperationsDec.multiply(basisResult.toBigDecimal(), factorSolidary))
        }

        return solidaryTaxing
    }
    override fun roundedBaseWithhold(incomeResult: Int): Int {
        val amountForCalc: Int = max(0, incomeResult)
        val withholdBase: Int = intTaxRoundDown(amountForCalc.toBigDecimal())

        return withholdBase
    }
    override fun roundedWithholdPaym(supersResult: Int, basisResult: Int): Int {
        val factorWithhold = OperationsDec.divide(factorWithhold, 100.toBigDecimal())

        var withholdTaxing: Int = max(0, supersResult)
        if (withholdTaxing > 0)
        {
            withholdTaxing = intTaxRoundDown(OperationsDec.multiply(supersResult.toBigDecimal(), factorWithhold))
        }
        return withholdTaxing
    }
}