package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSalary
import org.hravemzdy.legalios.service.types.VersionId

class PropsSalary(version: VersionId,
                  override val workingShiftWeek: Int,
                  override val workingShiftTime: Int,
                  override val minMonthlyWage: Int,
                  override val minHourlyWage: Int) :
    PropsBase(version), IPropsSalary {

    constructor(version: Int) : this(
        VersionId.get(version),
        0,0,0,0) {
    }

    companion object {
        fun empty(): IPropsSalary {
            return PropsSalary(VERSION_ZERO)
        }
    }
}