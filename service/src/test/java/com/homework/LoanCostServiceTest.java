package com.homework;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class LoanCostServiceTest {

    private LoanCostService tested = new LoanCostServiceImpl();

    @Test
    public void testCalculateLoanRepayAmount() {
        Loan loan = Loan.builder()
                .setAmount(BigDecimal.TEN)
                .setLoanCost(0.1)
                .build();
        BigDecimal amountToRepay = tested.calculateAmountToRepay(loan);
        BigDecimal expected = BigDecimal.valueOf(11.0);
        Assert.assertEquals(expected, amountToRepay);
    }
}
