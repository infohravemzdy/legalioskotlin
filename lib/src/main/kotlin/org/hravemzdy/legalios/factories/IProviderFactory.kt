package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.interfaces.IProps

interface IProviderFactory<P : IProps> {
    fun getProps(period: IPeriod): P
}

