package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.service.types.VersionId
import java.math.BigDecimal

open abstract class PropsTaxingBase(version: VersionId,
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
                      override val factorSolitary: BigDecimal,
                      override val factorTaxRate2: BigDecimal,
                      override val minAmountOfTaxBonus: Int,
                      override val maxAmountOfTaxBonus: Int,
                      override val marginIncomeOfTaxBonus: Int,
                      override val marginIncomeOfRounding: Int,
                      override val marginIncomeOfWithhold: Int,
                      override val marginIncomeOfSolitary: Int,
                      override val marginIncomeOfTaxRate2: Int,
                      override val marginIncomeOfWthEmp: Int,
                      override val marginIncomeOfWthAgr: Int) :
    PropsBase(version), IPropsTaxing {
}