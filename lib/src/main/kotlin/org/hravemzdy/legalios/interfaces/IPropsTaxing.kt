package org.hravemzdy.legalios.interfaces

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
   val factorSolitary: BigDecimal
   val minAmountOfTaxBonus: Int
   val maxAmountOfTaxBonus: Int
   val marginIncomeOfTaxBonus: Int
   val marginIncomeOfRounding: Int
   val marginIncomeOfWithhold: Int
   val marginIncomeOfSolitary: Int
   val marginIncomeOfWthEmp: Int
   val marginIncomeOfWthAgr: Int
}