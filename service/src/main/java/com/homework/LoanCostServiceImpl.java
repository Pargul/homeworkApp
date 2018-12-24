package com.homework;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoanCostServiceImpl implements LoanCostService {

    @Override
    public BigDecimal calculateAmountToRepay(Loan loan) {
        BigDecimal amount = loan.getAmount();
        Double cost = loan.getLoanCost();
        return amount.add(amount.multiply(BigDecimal.valueOf(cost)));
    }
}
