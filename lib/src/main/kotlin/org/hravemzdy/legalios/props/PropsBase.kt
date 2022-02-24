package org.hravemzdy.legalios.props

import org.hravemzdy.legalios.interfaces.IProps
import org.hravemzdy.legalios.service.types.VersionId

abstract class PropsBase(override val version: VersionId) : IProps {
    constructor(versionId: Int) : this(VersionId.get(versionId))

    fun isValid(): Boolean { return version.value != VERSION_ZERO }

    companion object {
        const val VERSION_ZERO: Int = 0
    }
}