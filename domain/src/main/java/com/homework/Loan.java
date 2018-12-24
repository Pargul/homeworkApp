package com.homework;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Loan {

    private Long loanId;
    private LocalDate loanStartDate;
    private Integer term;
    private BigDecimal amount;
    private Double loanCost;
    private List<LoanAnnex> loanAnnexList = new ArrayList<>();
    private LoanApplication loanApplication;

    public static Builder builder() {
        return new Builder();
    }

    public Long getLoanId() {
        return loanId;
    }

    public LocalDate getLoanStartDate() {
        return loanStartDate;
    }

    public Integer getTerm() {
        return term;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Double getLoanCost() {
        return loanCost;
    }

    public List<LoanAnnex> getLoanAnnexList() {
        return loanAnnexList;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    private Loan() {
    }

    public static class Builder {
        private Loan loan = new Loan();

        public Builder setLoanId(Long loanId) {
            loan.loanId = loanId;
            return this;
        }

        public Builder setLoanStartDate(LocalDate loanStartDate) {
            loan.loanStartDate = loanStartDate;
            return this;
        }

        public Builder setTerm(Integer term) {
            loan.term = term;
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            loan.amount = amount;
            return this;
        }

        public Builder setLoanCost(Double loanCost) {
            loan.loanCost = loanCost;
            return this;
        }

        public Builder setAnnexList(List<LoanAnnex> loanAnnexList) {
            loan.loanAnnexList = loanAnnexList;
            return this;
        }

        public Builder setLoanAppilication(LoanApplication loanApplication) {
            loan.loanApplication = loanApplication;
            return this;
        }

        public Builder copyOf(Loan copy) {
            loan.amount = copy.getAmount();
            loan.loanAnnexList = copy.getLoanAnnexList();
            loan.loanApplication = copy.getLoanApplication();
            loan.loanCost = copy.getLoanCost();
            loan.loanId = copy.getLoanId();
            loan.loanStartDate = copy.getLoanStartDate();
            loan.term = copy.getTerm();
            return this;
        }

        public Loan build() {
            return loan;
        }
    }
}
