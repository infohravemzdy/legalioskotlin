package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.service.types.VersionId

interface IPropsProvider<P> {
    fun getProps(period: IPeriod): P
    val version: VersionId
}