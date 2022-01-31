package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.service.types.VersionId
import java.math.BigDecimal

open abstract class PropsHealthBase(version: VersionId,
                      override val minMonthlyBasis: Int,
                      override val maxAnnualsBasis: Int,
                      override val limMonthlyState: Int,
                      override val limMonthlyDis50: Int,
                      override val factorCompound: BigDecimal,
                      override val factorEmployee: BigDecimal,
                      override val marginIncomeEmp: Int,
                      override val marginIncomeAgr: Int) :
    PropsBase(version), IPropsHealth {
}