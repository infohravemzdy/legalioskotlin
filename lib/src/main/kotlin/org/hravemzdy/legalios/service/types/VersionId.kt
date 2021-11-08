package org.hravemzdy.legalios.service.types

import org.hravemzdy.legalios.interfaces.IVersionId

data class VersionId(override val value: Int) : IVersionId<Int>
{
    companion object {
        const val VERSION_ZERO: Int = 0
        fun new(): VersionId {return VersionId(VERSION_ZERO) }
        fun get(value: Int): VersionId {return VersionId(value) }
    }
}

