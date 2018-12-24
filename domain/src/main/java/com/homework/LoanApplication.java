package com.homework;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class LoanApplication {

    private Integer term;
    private BigDecimal amount;
    private LocalDateTime loanApplicationCreateTime;

    private LoanApplication() {
    }

    public Integer getTerm() {
        return term;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getLoanApplicationCreateTime() {
        return loanApplicationCreateTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private LoanApplication loanApplication = new LoanApplication();

        public Builder setTerm(Integer term) {
            loanApplication.term = term;
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            loanApplication.amount = amount;
            return this;
        }

        public Builder setLoanApplicationCreateTime(LocalDateTime loanApplicationCreateTime) {
            loanApplication.loanApplicationCreateTime = loanApplicationCreateTime;
            return this;
        }

        public LoanApplication build() {
            return loanApplication;
        }
    }
}
