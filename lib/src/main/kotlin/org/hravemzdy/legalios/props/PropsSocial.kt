package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.service.types.VersionId
import java.math.BigDecimal

class PropsSocial(version: VersionId,
                  override val maxAnnualsBasis: Int,
                  override val factorEmployer: BigDecimal,
                  override val factorEmployerHigher: BigDecimal,
                  override val factorEmployee: BigDecimal,
                  override val factorEmployeeGarant: BigDecimal,
                  override val factorEmployeeReduce: BigDecimal,
                  override val marginIncomeEmp: Int,
                  override val marginIncomeAgr: Int) :
    PropsBase(version), IPropsSocial {

    constructor(version: Int) : this(
        VersionId.get(version),
        0,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        BigDecimal.ZERO,
        0,
        0)

    companion object {
        fun empty(): IPropsSocial {
            return PropsSocial(VERSION_ZERO)
        }
    }
}