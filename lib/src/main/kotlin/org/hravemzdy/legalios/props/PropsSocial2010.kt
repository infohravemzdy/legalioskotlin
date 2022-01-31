package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.service.types.VersionId
import java.math.BigDecimal

class PropsSocial2010(version: VersionId,
                      _maxAnnualsBasis: Int,
                      _factorEmployer: BigDecimal,
                      _factorEmployerHigher: BigDecimal,
                      _factorEmployee: BigDecimal,
                      _factorEmployeeGarant: BigDecimal,
                      _factorEmployeeReduce: BigDecimal,
                      _marginIncomeEmp: Int,
                      _marginIncomeAgr: Int) :
    PropsSocialBase(version,
        _maxAnnualsBasis,
        _factorEmployer,
        _factorEmployerHigher,
        _factorEmployee,
        _factorEmployeeGarant,
        _factorEmployeeReduce,
        _marginIncomeEmp,
        _marginIncomeAgr), IPropsSocial {

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
            return PropsSocial2010(VERSION_ZERO)
        }
    }
}