package com.homework;

import com.homework.dto.ApplyForLoanDto;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ApplyForLoanResponseMapperTest {

    private ApplyForLoanResponseMapper tested = Mappers.getMapper(ApplyForLoanResponseMapper.class);

    @Test
    public void test() {
        ApplyForLoanDto applyForLoanDto = new ApplyForLoanDto();
        applyForLoanDto.setLoanId(10L);
        applyForLoanDto.setAmountToPay(BigDecimal.valueOf(10));
        applyForLoanDto.setAmount(BigDecimal.TEN);
        applyForLoanDto.setLoanCost(0.1);
        applyForLoanDto.setLoanEnd(LocalDate.now().plusDays(10));
        applyForLoanDto.setLoanStartDate(LocalDate.now());
        ApplyForLoanResponse applyForLoanResponse = tested.toApplyForLoanResponse(applyForLoanDto);
        Assert.assertEquals(applyForLoanDto.getAmount(), applyForLoanResponse.getAmount());
        Assert.assertEquals(applyForLoanDto.getAmountToPay(), applyForLoanResponse.getAmountToPay());
        Assert.assertEquals(applyForLoanDto.getLoanCost(), applyForLoanResponse.getLoanCost());
        Assert.assertEquals(applyForLoanDto.getLoanEnd(), applyForLoanResponse.getLoanEnd());
        Assert.assertEquals(applyForLoanDto.getLoanId(), applyForLoanResponse.getLoanId());
        Assert.assertEquals(applyForLoanDto.getLoanStartDate(), applyForLoanResponse.getLoanStartDate());

    }
}
