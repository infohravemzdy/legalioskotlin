package org.hravemzdy.legalios.service

import com.github.michaelbull.result.Result
import org.hravemzdy.legalios.service.errors.HistoryResultError
import org.hravemzdy.legalios.interfaces.IBundleProps
import org.hravemzdy.legalios.interfaces.IPeriod

interface IServiceLegalios {
    fun getBundle(period: IPeriod): Result<IBundleProps, HistoryResultError>
}