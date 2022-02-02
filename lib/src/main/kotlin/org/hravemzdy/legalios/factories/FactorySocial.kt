package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.providers.period2022.ProviderSocial2022
import org.hravemzdy.legalios.providers.IProviderSocial
import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.props.PropsSocial

class FactorySocial : ProviderFactory<IProviderSocial, IPropsSocial>() {
    override val defaultProvider: IProviderSocial = ProviderSocial2022()

    override val emptyPeriodProps: IPropsSocial = PropsSocial.empty()

    override val versions: Map<VERSION, IProviderSocial> =
        buildVersions<IProviderSocial, IPropsSocial>()
}