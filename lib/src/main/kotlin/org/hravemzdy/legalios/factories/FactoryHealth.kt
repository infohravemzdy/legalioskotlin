package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.providers.period2022.ProviderHealth2022
import org.hravemzdy.legalios.providers.IProviderHealth
import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.props.PropsHealth

class FactoryHealth : ProviderFactory<IProviderHealth, IPropsHealth>() {
    override val defaultProvider: IProviderHealth = ProviderHealth2022()

    override val emptyPeriodProps: IPropsHealth = PropsHealth.empty()

    override val versions: Map<VERSION, IProviderHealth> =
        buildVersions<IProviderHealth, IPropsHealth>()


}