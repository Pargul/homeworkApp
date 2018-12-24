package com.homework;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ApplyForLoanResponse {

    private Long loanId;
    private LocalDate loanStartDate;
    private LocalDate loanEnd;
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

    public LocalDate getLoanEnd() {
        return loanEnd;
    }

    public void setLoanEnd(LocalDate loanEnd) {
        this.loanEnd = loanEnd;
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
