package com.homework;

import com.homework.dto.ApplyForLoanDto;
import com.homework.dto.ExtendLoanDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ExtendLoanDtoMapperImpl.class, LoanCostServiceImpl.class, LoanTermServiceImpl.class})
public class ExtendLoanDtoMapperTest {

    @Autowired
    private ExtendLoanDtoMapper extendLoanDtoMapper;

    @Test
    public void testMapper() {
        Loan loan = Loan.builder()
                .setLoanId(11L)
                .setLoanCost(0.1)
                .setAmount(BigDecimal.TEN)
                .setLoanStartDate(LocalDate.now())
                .setTerm(20)
                .build();
        ExtendLoanDto extendLoanDto = extendLoanDtoMapper.loanToExtendLoanDto(loan);
        Assert.assertEquals(loan.getLoanId(), extendLoanDto.getLoanId());
        Assert.assertEquals(loan.getAmount(), extendLoanDto.getAmount());
        Assert.assertEquals(loan.getLoanCost(), extendLoanDto.getLoanCost());
        Assert.assertEquals(BigDecimal.valueOf(11.0), extendLoanDto.getAmountToPay());
        Assert.assertEquals(loan.getLoanStartDate(), extendLoanDto.getLoanStartDate());
        Assert.assertEquals(LocalDate.now().plusDays(20), extendLoanDto.getLoanEndDate());
    }
}
