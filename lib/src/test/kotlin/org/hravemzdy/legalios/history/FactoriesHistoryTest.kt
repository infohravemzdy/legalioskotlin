package org.hravemzdy.legalios.history

import org.hravemzdy.legalios.factories.*
import org.hravemzdy.legalios.interfaces.IPropsHealth
import org.hravemzdy.legalios.interfaces.IPropsSalary
import org.hravemzdy.legalios.interfaces.IPropsSocial
import org.hravemzdy.legalios.interfaces.IPropsTaxing
import org.spekframework.spek2.Spek

class FactoriesHistoryTest() : Spek({
    val HEALTH_MIN_MONTHLY_BASIS        :Int = 101
    val HEALTH_MAX_ANNUALS_BASIS        :Int = 102
    val HEALTH_LIM_MONTHLY_STATE        :Int = 103
    val HEALTH_LIM_MONTHLY_DIS50        :Int = 104
    val HEALTH_FACTOR_COMPOUND          :Int = 105
    val HEALTH_FACTOR_EMPLOYEE          :Int = 106
    val HEALTH_MARGIN_INCOME_EMP        :Int = 107
    val HEALTH_MARGIN_INCOME_AGR        :Int = 108

    val SALARY_WORKING_SHIFT_WEEK       :Int = 201
    val SALARY_WORKING_SHIFT_TIME       :Int = 202
    val SALARY_MIN_MONTHLY_WAGE         :Int = 203
    val SALARY_MIN_HOURLY_WAGE          :Int = 204

    val SOCIAL_MAX_ANNUALS_BASIS        :Int = 301
    val SOCIAL_FACTOR_EMPLOYER          :Int = 302
    val SOCIAL_FACTOR_EMPLOYER_HIGHER   :Int = 303
    val SOCIAL_FACTOR_EMPLOYEE          :Int = 304
    val SOCIAL_FACTOR_EMPLOYEE_GARANT   :Int = 305
    val SOCIAL_FACTOR_EMPLOYEE_REDUCE   :Int = 306
    val SOCIAL_MARGIN_INCOME_EMP        :Int = 307
    val SOCIAL_MARGIN_INCOME_AGR        :Int = 308

    val TAXING_ALLOWANCE_PAYER          :Int = 401
    val TAXING_ALLOWANCE_DISAB_1ST      :Int = 402
    val TAXING_ALLOWANCE_DISAB_2ND      :Int = 403
    val TAXING_ALLOWANCE_DISAB_3RD      :Int = 404
    val TAXING_ALLOWANCE_STUDY          :Int = 405
    val TAXING_ALLOWANCE_CHILD_1ST      :Int = 406
    val TAXING_ALLOWANCE_CHILD_2ND      :Int = 407
    val TAXING_ALLOWANCE_CHILD_3RD      :Int = 408
    val TAXING_FACTOR_ADVANCES          :Int = 409
    val TAXING_FACTOR_WITHHOLD          :Int = 410
    val TAXING_FACTOR_SOLIDARY          :Int = 411
    val TAXING_FACTOR_TAXRATE2          :Int = 412
    val TAXING_MIN_AMOUNT_OF_TAXBONUS   :Int = 413
    val TAXING_MAX_AMOUNT_OF_TAXBONUS   :Int = 414
    val TAXING_MARGIN_INCOME_OF_TAXBONUS:Int = 415
    val TAXING_MARGIN_INCOME_OF_ROUNDING:Int = 416
    val TAXING_MARGIN_INCOME_OF_WITHHOLD:Int = 417
    val TAXING_MARGIN_INCOME_OF_SOLIDARY:Int = 418
    val TAXING_MARGIN_INCOME_OF_TAXRATE2:Int = 419
    val TAXING_MARGIN_INCOME_OF_WHT_EMP :Int = 420
    val TAXING_MARGIN_INCOME_OF_WHT_AGR :Int = 421

    val _sutSalary : IProviderFactory<IPropsSalary> = FactorySalary()
    val _sutHealth : IProviderFactory<IPropsHealth> = FactoryHealth()
    val _sutSocial : IProviderFactory<IPropsSocial> = FactorySocial()
    val _sutTaxing : IProviderFactory<IPropsTaxing> = FactoryTaxing()

    val HISTORY_TEST_FOLDER = "../../../test_history";

})