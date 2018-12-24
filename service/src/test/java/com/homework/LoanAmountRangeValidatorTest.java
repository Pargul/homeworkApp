package com.homework;

import com.homework.exception.LoanApplicationValidationException;
import org.junit.Test;

import java.math.BigDecimal;

public class LoanAmountRangeValidatorTest {

    private LoanAmountRangeValidator tested = new LoanAmountRangeValidator();

    @Test
    public void testValidatorSuccess() {
        LoanApplication loan = LoanApplication.builder()
                .setAmount(BigDecimal.valueOf(110))
                .build();
        tested.apply(loan);
    }

    @Test(expected = LoanApplicationValidationException.class)
    public void testValidatorMin() {
        LoanApplication loan = LoanApplication.builder()
                .setAmount(BigDecimal.ZERO)
                .build();
        tested.apply(loan);
    }

    @Test(expected = LoanApplicationValidationException.class)
    public void testValidatorMax() {
        LoanApplication loan = LoanApplication.builder()
                .setAmount(BigDecimal.valueOf(110000))
                .build();
        tested.apply(loan);
    }

}
