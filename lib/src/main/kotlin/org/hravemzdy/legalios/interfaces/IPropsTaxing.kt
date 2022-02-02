package org.hravemzdy.legalios.interfaces

import org.hravemzdy.legalios.service.types.*
import java.math.BigDecimal


interface IPropsTaxing : IProps {
   val allowancePayer: Int
   val allowanceDisab1st: Int
   val allowanceDisab2nd : Int
   val allowanceDisab3rd: Int
   val allowanceStudy: Int
   val allowanceChild1st: Int
   val allowanceChild2nd: Int
   val allowanceChild3rd: Int
   val factorAdvances: BigDecimal
   val factorWithhold: BigDecimal
   val factorSolidary: BigDecimal
   val factorTaxRate2: BigDecimal
   val minAmountOfTaxBonus: Int
   val maxAmountOfTaxBonus: Int
   val marginIncomeOfTaxBonus: Int
   val marginIncomeOfRounding: Int
   val marginIncomeOfWithhold: Int
   val marginIncomeOfSolidary: Int
   val marginIncomeOfTaxRate2: Int
   val marginIncomeOfWthEmp: Int
   val marginIncomeOfWthAgr: Int

   fun valueEquals(other: IPropsTaxing?): Boolean
   fun hasWithholdIncome(termOpt: WorkTaxingTerms,
      signOpt: TaxDeclSignOption, noneOpt: TaxNoneSignOption, incomeSum: Int): Boolean
   fun benefitAllowancePayer(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption): Int
   fun benefitAllowanceDisab(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclDisabOption): Int
   fun benefitAllowanceStudy(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption): Int
   fun benefitAllowanceChild(signOpts: TaxDeclSignOption, benefitOpts: TaxDeclBenfOption, benefitOrds: Int, disabelOpts: Int): Int
   fun bonusChildRaw(income: Int, benefit: Int, rebated: Int): Int
   fun bonusChildFix(income: Int, benefit: Int, rebated: Int): Int
   fun taxableIncomeSupers(incomeResult: Int, healthResult: Int, socialResult: Int): Int
   fun taxableIncomeBasis(incomeResult: Int): Int
   fun roundedBaseAdvances(incomeResult: Int): Int
   fun roundedBaseAdvances(incomeResult: Int, healthResult: Int, socialResult: Int): Int
   fun roundedBaseSolidary(incomeResult: Int): Int
   fun roundedAdvancesPaym(supersResult: Int, basisResult: Int): Int
   fun roundedSolidaryPaym(basisResult: Int): Int
   fun roundedBaseWithhold(incomeResult: Int): Int
   fun roundedWithholdPaym(supersResult: Int, basisResult: Int): Int
}