package com.homework;

import com.homework.conf.LoanConfigurationProperties;
import com.homework.exception.LoanApplicationValidationException;
import org.springframework.stereotype.Service;

@Service
public class LoanAmountRangeValidator implements ApplyForLoanValidator {

    @Override
    public void apply(LoanApplication loanApplication) {
        if (LoanConfigurationProperties.MIN_AMOUNT.compareTo(loanApplication.getAmount()) > 0 || LoanConfigurationProperties.MAX_AMOUNT.compareTo(loanApplication.getAmount()) < 0) {
            throw new LoanApplicationValidationException();
        }
    }
}
