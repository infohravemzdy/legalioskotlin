package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.IBundleProps
import org.hravemzdy.legalios.interfaces.IPeriod

interface IBundleBuilder {
    fun getBundle(period: IPeriod): IBundleProps?
}

