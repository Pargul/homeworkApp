package com.homework;

import java.math.BigDecimal;

public interface LoanCostService {

    /**
     * Calculate loan cost
     *
     * @param loan loan
     * @return amount to repay
     */
    BigDecimal calculateAmountToRepay(Loan loan);
}
