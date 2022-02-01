package org.hravemzdy.legalios.service.types

enum class TaxDeclSignOption(val code: Int) {
    DECL_TAX_NO_SIGNED(0),
    DECL_TAX_DO_SIGNED(1),
}

enum class TaxNoneSignOption(val code: Int) {
    NOSIGN_TAX_WITHHOLD (0),
    NOSIGN_TAX_ADVANCES (1),
}

enum class TaxDeclBenfOption(val code: Int) {
    DECL_TAX_BENEF0 (0),
    DECL_TAX_BENEF1 (1),
}

enum class TaxDeclDisabOption(val code: Int) {
    DECL_TAX_BENEF0(0),
    DECL_TAX_DISAB1(1),
    DECL_TAX_DISAB2(2),
    DECL_TAX_DISAB3(3),
}
