package org.hravemzdy.legalios.interfaces

interface IPropsSalary : IProps {
    val workingShiftWeek : Int
    val workingShiftTime : Int
    val minMonthlyWage : Int
    val minHourlyWage : Int
}