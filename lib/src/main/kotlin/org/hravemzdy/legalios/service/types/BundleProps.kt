package org.hravemzdy.legalios.service.types

import org.hravemzdy.legalios.interfaces.*
import org.hravemzdy.legalios.props.PropsHealth
import org.hravemzdy.legalios.props.PropsSalary
import org.hravemzdy.legalios.props.PropsSocial
import org.hravemzdy.legalios.props.PropsTaxing

class BundleProps(
    override val periodProps: IPeriod,
    override val salaryProps: IPropsSalary,
    override val healthProps: IPropsHealth,
    override val socialProps: IPropsSocial,
    override val taxingProps: IPropsTaxing) :
    IBundleProps {
    override fun getPeriodYear(): Int {
        return periodProps.year
    }

    override fun getPeriodMonth(): Int {
        return periodProps.month
    }

    override fun getPeriodCode(): Int {
        return periodProps.code
    }

    companion object {
        fun empty(period: IPeriod): IBundleProps {
            return BundleProps(
                period,
                PropsSalary.empty(),
                PropsHealth.empty(),
                PropsSocial.empty(),
                PropsTaxing.empty())
        }
    }
}
