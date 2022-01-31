package org.hravemzdy.legalios.factories

import org.hravemzdy.legalios.interfaces.*
import org.hravemzdy.legalios.service.types.BundleProps

class BundleBuilder : IBundleBuilder {
    private val salaryFactory : IProviderFactory<IPropsSalary>
    private val healthFactory : IProviderFactory<IPropsHealth>
    private val socialFactory : IProviderFactory<IPropsSocial>
    private val taxingFactory : IProviderFactory<IPropsTaxing>

    constructor() {
        salaryFactory = FactorySalary()
        healthFactory = FactoryHealth()
        socialFactory = FactorySocial()
        taxingFactory = FactoryTaxing()
    }

    override fun getBundle(period: IPeriod): IBundleProps? {
        val salary: IPropsSalary = getSalaryProps(period)
        val health: IPropsHealth = getHealthProps(period)
        val social: IPropsSocial = getSocialProps(period)
        val taxing: IPropsTaxing = getTaxingProps(period)

        if (isValidBundle(salary, health, social, taxing)) {
            return BundleProps(period, salary, health, social, taxing)
        }
        return null
    }
    private fun getSalaryProps(period: IPeriod): IPropsSalary {
        return salaryFactory.getProps(period)
    }

    private fun getHealthProps(period: IPeriod): IPropsHealth {
        return healthFactory.getProps(period)
    }

    private fun getSocialProps(period: IPeriod): IPropsSocial {
        return socialFactory.getProps(period)
    }

    private fun getTaxingProps(period: IPeriod): IPropsTaxing {
        return taxingFactory.getProps(period)
    }
    companion object {
        private const val MIN_VERSION: Int = 2010

        private fun isNullOrEmpty(props : IProps): Boolean {
            return (props.version.value < MIN_VERSION)
        }
        private fun isValidBundle(
            salary: IProps,
            health: IProps,
            social: IProps,
            taxing: IProps): Boolean {
            if (isNullOrEmpty(salary)) {
                return false
            }
            if (isNullOrEmpty(health)) {
                return false
            }
            if (isNullOrEmpty(social)) {
                return false
            }
            if (isNullOrEmpty(taxing)) {
                return false
            }
            return true
        }
    }
}