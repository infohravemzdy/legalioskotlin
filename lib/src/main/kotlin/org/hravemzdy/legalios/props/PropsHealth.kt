package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.service.types.VersionId
import java.math.BigDecimal

class PropsHealth(version: VersionId,
                  override val minMonthlyBasis: Int,
                  override val maxAnnualsBasis: Int,
                  override val limMonthlyState: Int,
                  override val limMonthlyDis50: Int,
                  override val factorCompound: BigDecimal,
                  override val factorEmployee: BigDecimal,
                  override val marginIncomeEmp: Int,
                  override val marginIncomeAgr: Int) :
    PropsBase(version), IPropsHealth {

    constructor(version: Int) : this(
        VersionId.get(version),
        0,0,0,0,
        BigDecimal.ZERO, BigDecimal.ZERO,
        0,0)

    companion object {
        fun empty(): IPropsHealth {
            return PropsHealth(VERSION_ZERO)
        }
    }
 }