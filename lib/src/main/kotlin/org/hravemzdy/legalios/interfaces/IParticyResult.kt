package org.hravemzdy.legalios.interfaces

interface IParticyResult {
    val particyCode: Int
    val resultBasis: Int
    val resultValue: Int
    fun setResultValue(value: Int): Int
}