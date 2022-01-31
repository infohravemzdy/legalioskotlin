package org.hravemzdy.legalios.service.types

enum class WorkContractTerms(val code: Int) {
    WORKTERM_EMPLOYMENT_1(0),
    WORKTERM_CONTRACTER_A(1),
    WORKTERM_CONTRACTER_T(2),
    WORKTERM_PARTNER_STAT(3),
}

enum class WorkTaxingTerms(val code: Int) {
    TAXING_TERM_BY_CONTRACT(0),
    TAXING_TERM_EMPLOYMENTS(1),
    TAXING_TERM_AGREEM_TASK(2),
    TAXING_TERM_STATUT_PART(3),
}

enum class WorkHealthTerms(val code: Int) {
    HEALTH_TERM_BY_CONTRACT(0),
    HEALTH_TERM_EMPLOYMENTS(1),
    HEALTH_TERM_AGREEM_WORK(2),
    HEALTH_TERM_AGREEM_TASK(3),
}

enum class WorkSocialTerms(val code: Int) {
    SOCIAL_TERM_BY_CONTRACT (0),
    SOCIAL_TERM_EMPLOYMENTS (1),
    SOCIAL_TERM_SMALLS_EMPL (2),
    SOCIAL_TERM_SHORTS_MEET (3),
    SOCIAL_TERM_SHORTS_DENY (4),
    SOCIAL_TERM_AGREEM_TASK (5),
}

