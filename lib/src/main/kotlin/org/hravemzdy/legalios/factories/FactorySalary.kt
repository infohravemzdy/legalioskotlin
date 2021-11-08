package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.providers.period2022.ProviderSalary2022
import org.hravemzdy.legalios.providers.IProviderSalary
import org.hravemzdy.legalios.interfaces.IPropsSalary
import org.hravemzdy.legalios.props.PropsSalary

class FactorySalary : ProviderFactory<IProviderSalary, IPropsSalary>() {
    override val defaultProvider: IProviderSalary = ProviderSalary2022()

    override val emptyPeriodProps: IPropsSalary = PropsSalary.empty()

    override val versions: Map<VERSION, IProviderSalary> =
        buildVersions<IProviderSalary, IPropsSalary>()
}