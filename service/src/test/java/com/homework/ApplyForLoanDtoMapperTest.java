package com.homework;

import com.homework.dto.ApplyForLoanDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplyForLoanDtoMapperImpl.class, LoanCostServiceImpl.class, LoanTermServiceImpl.class})
public class ApplyForLoanDtoMapperTest {

    @Autowired
    private ApplyForLoanDtoMapper applyForLoanDtoMapper;

    @Test
    public void testMapper() {
        Loan loan = Loan.builder()
                .setLoanId(11L)
                .setLoanCost(0.1)
                .setAmount(BigDecimal.TEN)
                .setLoanStartDate(LocalDate.now())
                .setTerm(20)
                .build();
        ApplyForLoanDto applyForLoanDto = applyForLoanDtoMapper.loanToApplyForLoanDto(loan);
        Assert.assertEquals(loan.getLoanId(), applyForLoanDto.getLoanId());
        Assert.assertEquals(loan.getAmount(), applyForLoanDto.getAmount());
        Assert.assertEquals(loan.getLoanCost(), applyForLoanDto.getLoanCost());
        Assert.assertEquals(BigDecimal.valueOf(11.0), applyForLoanDto.getAmountToPay());
        Assert.assertEquals(loan.getLoanStartDate(), applyForLoanDto.getLoanStartDate());
        Assert.assertEquals(LocalDate.now().plusDays(20), applyForLoanDto.getLoanEnd());
    }
}
