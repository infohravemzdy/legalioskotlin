package org.hravemzdy.legalios.interfaces

import java.math.BigDecimal

interface IPropsSocial : IProps {
    val maxAnnualsBasis: Int
    val factorEmployer: BigDecimal
    val factorEmployerHigher: BigDecimal
    val factorEmployee: BigDecimal
    val factorEmployeeGarant: BigDecimal
    val factorEmployeeReduce: BigDecimal
    val marginIncomeEmp: Int
    val marginIncomeAgr: Int
}