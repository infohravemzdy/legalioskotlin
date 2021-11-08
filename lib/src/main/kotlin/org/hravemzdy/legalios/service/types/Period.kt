package org.hravemzdy.legalios.service.types

import org.hravemzdy.legalios.interfaces.IPeriod

data class Period(override val code:Int) : IPeriod, Comparable<Period> {
    override val year: Int  get() { return (code / 100) }
    override val month: Int get() { return (code % 100) }

    constructor(year: Int, month: Int) : this(year * 100 + month)

    companion object {
        const val ZeroCode: Int = 0

        val zero: Period = new()
        fun new(): Period = Period(ZeroCode)
        fun get(code: Int): Period {return Period(code) }
        fun getWithYearMonth(year: Int, month: Int): Period {return Period(year, month) }

    }

    override fun compareTo(other: Period): Int {
        if (this.code == other.code) return 0
        return this.code.compareTo(other.code)
    }
}
