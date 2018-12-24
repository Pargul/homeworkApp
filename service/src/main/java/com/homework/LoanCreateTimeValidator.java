package com.homework;

import com.homework.conf.LoanConfigurationProperties;
import com.homework.exception.LoanApplicationValidationException;

public class LoanCreateTimeValidator implements ApplyForLoanValidator {

    @Override
    public void apply(LoanApplication loanApplication) {
        if (LoanConfigurationProperties.MAX_AMOUNT.compareTo(loanApplication.getAmount()) == 0) {
            if (loanApplication.getLoanApplicationCreateTime().getHour() > LoanConfigurationProperties.MIN_HOUR && loanApplication.getLoanApplicationCreateTime().getHour() < LoanConfigurationProperties.MAX_HOUR) {
                throw new LoanApplicationValidationException();
            }
        }
    }
}
