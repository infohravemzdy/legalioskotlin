package org.hravemzdy.legalios.service.errors

sealed class HistoryResultError(val  message: String) {
    class BundleNoneError() : HistoryResultError("service hasn't returned bundle")
    class BundleNullError() : HistoryResultError("service returned null bundle")
    class BundleEmptyError() : HistoryResultError("service returned empty bundle")
    class BundleInvalidError() : HistoryResultError("service returned invalid bundle")
}
