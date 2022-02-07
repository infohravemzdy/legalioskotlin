package org.hravemzdy.legalios.service.types

import java.math.BigDecimal
import java.math.RoundingMode

object OperationsRound {
    private val INT_ROUNDING_CONST = BigDecimal("0.5")

    fun roundToInt(valueDec: BigDecimal): Int {
        val roundRet = (valueDec.abs() + INT_ROUNDING_CONST).setScale(0, RoundingMode.FLOOR)

        if (valueDec < BigDecimal.ZERO) {
            return roundRet.negate().toInt()
        }
        return roundRet.toInt()
    }
    fun roundUp(valueDec: BigDecimal): Int {
        val roundRet = valueDec.abs().setScale(0, RoundingMode.CEILING)

        if (valueDec < BigDecimal.ZERO) {
            return roundRet.negate().toInt()
        }
        return roundRet.toInt()
    }

    fun roundDown(valueDec: BigDecimal): Int {
        val roundRet = valueDec.abs().setScale(0, RoundingMode.FLOOR)

        if (valueDec < BigDecimal.ZERO) {
            return roundRet.negate().toInt()
        }
        return roundRet.toInt()
    }
    fun roundNorm(valueDec: BigDecimal): Int {
        val roundRet = (valueDec.abs() + INT_ROUNDING_CONST).setScale(0, RoundingMode.DOWN)

        if (valueDec < BigDecimal.ZERO) {
            return roundRet.negate().toInt()
        }
        return roundRet.toInt()
    }

    fun nearRoundUp(valueDec: BigDecimal, nearest: Int = 100): Int {
        val nearestBig = nearest.toBigDecimal()
        val dividRet = OperationsDec.divide(valueDec, nearestBig)

        val multiRet = OperationsDec.multiply(decRoundUp(dividRet), nearestBig)

        return roundToInt(multiRet)
    }

    fun nearRoundDown(valueDec: BigDecimal, nearest: Int = 100): Int {
        val nearestBig = nearest.toBigDecimal()
        val dividRet = OperationsDec.divide(valueDec, nearestBig)

        val multiRet = OperationsDec.multiply(decRoundDown(dividRet), nearestBig)

        return roundToInt(multiRet)
    }
    fun roundUp50(valueDec: BigDecimal): Int {
        val divider = 2.toBigDecimal()
        val dividRet = OperationsDec.divide(decRoundUp(OperationsDec.multiply(valueDec, divider)), divider)
        return roundToInt(dividRet)
    }
    fun roundUp25(valueDec: BigDecimal): Int {
        val divider = 4.toBigDecimal()
        val dividRet = OperationsDec.divide(decRoundUp(OperationsDec.multiply(valueDec, divider)), divider)
        return roundToInt(dividRet)
    }

    fun decRoundUp(valueDec: BigDecimal): BigDecimal {
        val roundRet = valueDec.abs().setScale(0, RoundingMode.CEILING)

        if (valueDec < BigDecimal.ZERO) {
            return roundRet.negate()
        }
        return roundRet
    }

    fun decRoundDown(valueDec: BigDecimal): BigDecimal {
        val roundRet = valueDec.abs().setScale(0, RoundingMode.FLOOR)

        if (valueDec < BigDecimal.ZERO) {
            return roundRet.negate()
        }
        return roundRet
    }
    fun decRoundNorm(valueDec: BigDecimal): BigDecimal {
        val roundRet = (valueDec.abs() + INT_ROUNDING_CONST).setScale(0, RoundingMode.DOWN)

        if (valueDec < BigDecimal.ZERO) {
            return roundRet.negate()
        }
        return roundRet
    }

    fun decNearRoundUp(valueDec: BigDecimal, nearest: Int = 100): BigDecimal {
        val nearestBig = nearest.toBigDecimal()
        val dividRet = OperationsDec.divide(valueDec, nearestBig)

        val multiRet = OperationsDec.multiply(decRoundUp(dividRet), nearestBig)

        return multiRet
    }

    fun decNearRoundDown(valueDec: BigDecimal, nearest: Int = 100): BigDecimal {
        val nearestBig = nearest.toBigDecimal()
        val dividRet = OperationsDec.divide(valueDec, nearestBig)

        val multiRet = OperationsDec.multiply(decRoundDown(dividRet), nearestBig)

        return multiRet
    }
    fun decRoundUp50(valueDec: BigDecimal): BigDecimal {
        val divider = 2.toBigDecimal()
        return OperationsDec.divide(decRoundUp(OperationsDec.multiply(valueDec, divider)), divider)
    }
    fun decRoundUp25(valueDec: BigDecimal): BigDecimal {
        val divider = 4.toBigDecimal()
        return OperationsDec.divide(decRoundUp(OperationsDec.multiply(valueDec, divider)), divider)
    }
    fun decRoundUp01(valueDec: BigDecimal): BigDecimal {
        val divider = 100.toBigDecimal()
        return OperationsDec.divide(decRoundUp(OperationsDec.multiply(valueDec, divider)), divider)
    }
    fun decRoundDown50(valueDec: BigDecimal): BigDecimal {
        val divider = 2.toBigDecimal()
        return OperationsDec.divide(decRoundDown(OperationsDec.multiply(valueDec, divider)), divider)
    }
    fun decRoundDown25(valueDec: BigDecimal): BigDecimal {
        val divider = 4.toBigDecimal()
        return OperationsDec.divide(decRoundDown(OperationsDec.multiply(valueDec, divider)), divider)
    }
    fun decRoundDown01(valueDec: BigDecimal): BigDecimal {
        val divider = 100.toBigDecimal()
        return OperationsDec.divide(decRoundDown(OperationsDec.multiply(valueDec, divider)), divider)
    }
    fun decRoundNorm50(valueDec: BigDecimal): BigDecimal {
        val divider = 2.toBigDecimal()
        return OperationsDec.divide(decRoundNorm(OperationsDec.multiply(valueDec, divider)), divider)
    }
    fun decRoundNorm25(valueDec: BigDecimal): BigDecimal {
        val divider = 4.toBigDecimal()
        return OperationsDec.divide(decRoundNorm(OperationsDec.multiply(valueDec, divider)), divider)
    }
    fun decRoundNorm01(valueDec: BigDecimal): BigDecimal {
        val divider = 100.toBigDecimal()
        return OperationsDec.divide(decRoundNorm(OperationsDec.multiply(valueDec, divider)), divider)
    }
}