package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.providers.period2022.ProviderTaxing2022
import org.hravemzdy.legalios.providers.IProviderTaxing
import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.hravemzdy.legalios.props.PropsTaxing

class FactoryTaxing : ProviderFactory<IProviderTaxing, IPropsTaxing>() {
    override val defaultProvider: IProviderTaxing = ProviderTaxing2022()

    override val emptyPeriodProps: IPropsTaxing = PropsTaxing.empty()

    override val versions: Map<VERSION, IProviderTaxing> =
        buildVersions<IProviderTaxing, IPropsTaxing>()
}