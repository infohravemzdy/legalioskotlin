package org.hravemzdy.legalios.service.types

import java.math.BigDecimal

object OperationsDec {
    fun multiply(op1: BigDecimal, op2: BigDecimal): BigDecimal {
        return op1.multiply(op2)
    }

    fun divide(op1: BigDecimal, div: BigDecimal) : BigDecimal {
        if (div == BigDecimal.ZERO)
        {
            return BigDecimal.ZERO
        }
        return op1.divide(div)
    }

    fun multiplyAndDivide(op1: BigDecimal, op2: BigDecimal, div: BigDecimal) : BigDecimal {
            if (div == BigDecimal.ZERO)
            {
                return BigDecimal.ZERO
            }
            val multiRet = op1.multiply(op2)

            val dividRet = multiRet.divide(div)

            return dividRet
        }

    fun decimalCast(number: Int) : BigDecimal {
        return BigDecimal(number)
    }

    fun minIncMaxDecValue(valueToMinMax: BigDecimal, accValueToMax: BigDecimal, minLimitTo: BigDecimal, maxLimitTo: BigDecimal) : BigDecimal {
        val minBase = minIncValue(valueToMinMax, minLimitTo)

        val maxBase = maxDecAccumValue(minBase, accValueToMax, maxLimitTo)

        return maxBase
    }

    fun maxDecAccumValue(valueToMax: BigDecimal, accumToMax: BigDecimal, maxLimitTo: BigDecimal) : BigDecimal {
        if (maxLimitTo > BigDecimal.ZERO)
        {
            val valueToReduce = valueToMax.add(accumToMax).max(maxLimitTo)

            return BigDecimal.ZERO.max(valueToReduce.subtract(accumToMax))
        }
        return valueToMax
    }

    fun maxDecAccumAbove(valueToMax: BigDecimal, accumToMax: BigDecimal, maxLimitTo: BigDecimal) : BigDecimal {
        if (maxLimitTo > BigDecimal.ZERO)
        {
            val underToLimits = maxDecAccumValue(valueToMax, accumToMax, maxLimitTo)

            return BigDecimal.ZERO.max(valueToMax - underToLimits)
        }
        return BigDecimal.ZERO
    }

    fun minIncValue(valueToMin: BigDecimal, minLimitTo: BigDecimal) : BigDecimal {
        if (minLimitTo > BigDecimal.ZERO)
        {
            if (minLimitTo > valueToMin)
            {
                return minLimitTo
            }
        }
        return valueToMin
    }

    fun maxDecValue(valueToMax: BigDecimal, maxLimitTo: BigDecimal) : BigDecimal {
        if (maxLimitTo > BigDecimal.ZERO)
        {
            return valueToMax.min(maxLimitTo)
        }
        return valueToMax
    }

    fun suppressNegative(suppress: Boolean, valueDec: BigDecimal) : BigDecimal {
        if (suppress && valueDec < BigDecimal.ZERO)
        {
            return BigDecimal.ZERO
        }
        return valueDec
    }
}