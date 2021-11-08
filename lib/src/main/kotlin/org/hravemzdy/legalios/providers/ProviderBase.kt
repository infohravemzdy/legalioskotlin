package org.hravemzdy.legalios.providers

import org.hravemzdy.legalios.interfaces.IPeriod
import org.hravemzdy.legalios.service.types.VersionId


abstract class ProviderBase(val version: VersionId) {
    constructor(versionId: Int) : this(VersionId.get(versionId))

    protected fun isPeriodGreaterOrEqualThan(period: IPeriod, yearFrom: Int, monthFrom: Int): Boolean {
        return period.year > yearFrom || (period.year == yearFrom && period.month >= monthFrom)
    }
}