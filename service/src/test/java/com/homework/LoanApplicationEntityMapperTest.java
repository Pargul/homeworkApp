package com.homework;

import com.homework.entity.LoanApplicationEntity;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanApplicationEntityMapperTest {

    private LoanApplicationEntityMapper tested = Mappers.getMapper(LoanApplicationEntityMapper.class);

    @Test
    public void test() {
        LoanApplication loanApplication = LoanApplication.builder()
                .setTerm(10)
                .setAmount(BigDecimal.TEN)
                .setLoanApplicationCreateTime(LocalDateTime.now())
                .build();
        LoanApplicationEntity loanApplicationEntity = tested.toLoanApplicationEntity(loanApplication);
        Assert.assertEquals(loanApplication.getTerm(), loanApplicationEntity.getTerm());
        Assert.assertEquals(loanApplication.getAmount(), loanApplicationEntity.getAmount());
    }
}
