package com.homework;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExtendLoanResponse {

    private Long loanId;
    private LocalDate loanStartDate;
    private LocalDate loanEndDate;
    private BigDecimal amount;
    private BigDecimal amountToPay;
    private Double loanCost;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public LocalDate getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(LocalDate loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public LocalDate getLoanEndDate() {
        return loanEndDate;
    }

    public void setLoanEndDate(LocalDate loanEndDate) {
        this.loanEndDate = loanEndDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(BigDecimal amountToPay) {
        this.amountToPay = amountToPay;
    }

    public Double getLoanCost() {
        return loanCost;
    }

    public void setLoanCost(Double loanCost) {
        this.loanCost = loanCost;
    }
}
