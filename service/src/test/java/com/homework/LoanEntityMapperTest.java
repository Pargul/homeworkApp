package com.homework;

import com.homework.entity.LoanEntity;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class LoanEntityMapperTest {

    private LoanEntityMapper tested = Mappers.getMapper(LoanEntityMapper.class);

    @Test
    public void testToLoanEntity() {
        Loan loan = Loan.builder()
                .setLoanStartDate(LocalDate.now())
                .setTerm(10)
                .setLoanCost(0.1)
                .setAmount(BigDecimal.TEN)
                .build();
        LoanEntity loanEntity = tested.toLoanEntity(loan);
        Assert.assertEquals(loan.getLoanCost(), loanEntity.getLoanCost());
        Assert.assertEquals(loan.getTerm(), loanEntity.getTerm());
        Assert.assertEquals(loan.getAmount(), loanEntity.getAmount());
        Assert.assertEquals(loan.getLoanStartDate(), loanEntity.getLoanStartDate());
    }

    @Test
    public void testToLoan() {
        LoanEntity loanEntity = new LoanEntity();
        loanEntity.setLoanStartDate(LocalDate.now());
        loanEntity.setTerm(10);
        loanEntity.setLoanCost(0.1);
        loanEntity.setAmount(BigDecimal.TEN);
        Loan loan = tested.toLoan(loanEntity, new ArrayList<>());
        Assert.assertEquals(loanEntity.getLoanCost(), loan.getLoanCost());
        Assert.assertEquals(loanEntity.getTerm(), loan.getTerm());
        Assert.assertEquals(loanEntity.getAmount(), loan.getAmount());
        Assert.assertEquals(loanEntity.getLoanStartDate(), loan.getLoanStartDate());
    }
}
