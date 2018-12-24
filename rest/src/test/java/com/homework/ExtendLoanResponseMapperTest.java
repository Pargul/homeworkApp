package com.homework;

import com.homework.dto.ExtendLoanDto;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExtendLoanResponseMapperTest {

    private ExtendLoanResponseMapper tested = Mappers.getMapper(ExtendLoanResponseMapper.class);

    @Test
    public void test() {
        ExtendLoanDto extendLoanDto = new ExtendLoanDto();
        extendLoanDto.setLoanId(10L);
        extendLoanDto.setAmountToPay(BigDecimal.valueOf(10));
        extendLoanDto.setAmount(BigDecimal.TEN);
        extendLoanDto.setLoanCost(0.1);
        extendLoanDto.setLoanEndDate(LocalDate.now().plusDays(10));
        extendLoanDto.setLoanStartDate(LocalDate.now());
        ExtendLoanResponse extendLoanResponse = tested.toExtendLoanResponse(extendLoanDto);
        Assert.assertEquals(extendLoanDto.getAmount(), extendLoanResponse.getAmount());
        Assert.assertEquals(extendLoanDto.getAmountToPay(), extendLoanResponse.getAmountToPay());
        Assert.assertEquals(extendLoanDto.getLoanCost(), extendLoanResponse.getLoanCost());
        Assert.assertEquals(extendLoanDto.getLoanEndDate(), extendLoanResponse.getLoanEndDate());
        Assert.assertEquals(extendLoanDto.getLoanId(), extendLoanResponse.getLoanId());
        Assert.assertEquals(extendLoanDto.getLoanStartDate(), extendLoanResponse.getLoanStartDate());

    }
}
