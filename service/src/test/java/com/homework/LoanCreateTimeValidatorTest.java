package com.homework;

import com.homework.exception.LoanApplicationValidationException;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanCreateTimeValidatorTest {

    private LoanCreateTimeValidator tested = new LoanCreateTimeValidator();

    @Test
    public void testValidatorSuccess() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 23, 12, 30);
        LoanApplication loan = LoanApplication.builder()
                .setAmount(BigDecimal.valueOf(110))
                .setLoanApplicationCreateTime(localDateTime)
                .build();
        tested.apply(loan);
    }

    @Test
    public void testValidatorNightSuccess() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 23, 1, 30);
        LoanApplication loan = LoanApplication.builder()
                .setAmount(BigDecimal.valueOf(110))
                .setLoanApplicationCreateTime(localDateTime)
                .build();
        tested.apply(loan);
    }

    @Test(expected = LoanApplicationValidationException.class)
    public void testValidatorFail() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 23, 1, 30);
        LoanApplication loanApplication = LoanApplication.builder()
                .setAmount(BigDecimal.valueOf(10000))
                .setLoanApplicationCreateTime(localDateTime)
                .build();
        tested.apply(loanApplication);
    }

}
