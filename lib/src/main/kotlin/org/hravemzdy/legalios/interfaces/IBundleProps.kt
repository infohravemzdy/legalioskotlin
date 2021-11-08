package org.hravemzdy.legalios.interfaces

interface IBundleProps {
    val periodProps: IPeriod
    val salaryProps: IPropsSalary?
    val healthProps: IPropsHealth?
    val socialProps: IPropsSocial?
    val taxingProps: IPropsTaxing?

    fun getPeriodYear(): Int
    fun getPeriodMonth(): Int
    fun getPeriodCode(): Int
}

