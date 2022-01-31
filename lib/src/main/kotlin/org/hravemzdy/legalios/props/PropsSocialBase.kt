package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.service.types.VersionId
import java.math.BigDecimal

open abstract class PropsSocialBase(version: VersionId,
                      override val maxAnnualsBasis: Int,
                      override val factorEmployer: BigDecimal,
                      override val factorEmployerHigher: BigDecimal,
                      override val factorEmployee: BigDecimal,
                      override val factorEmployeeGarant: BigDecimal,
                      override val factorEmployeeReduce: BigDecimal,
                      override val marginIncomeEmp: Int,
                      override val marginIncomeAgr: Int) :
    PropsBase(version), IPropsSocial {
}