package com.homework;

import com.homework.dto.ApplyForLoanDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ApplyForLoanServiceTest {
    private static final Long LOAN_ID = 100l;
    private static final Integer TERM = 10;
    private static final BigDecimal AMOUNT = BigDecimal.TEN;
    private ApplyForLoanService tested;

    @Before
    public void setUp() {
        LoanService loanService = Mockito.mock(LoanService.class);
        Mockito.when(loanService.save(Mockito.any())).thenReturn(Loan.builder().setAmount(AMOUNT).setTerm(TERM).build());
        List<ApplyForLoanValidator> validators = new ArrayList<>();
        ApplyForLoanDtoMapper applyForLoanDtoMapper = Mockito.mock(ApplyForLoanDtoMapper.class);
        Mockito.when(applyForLoanDtoMapper.loanToApplyForLoanDto(Mockito.any())).thenReturn(new ApplyForLoanDto());
        tested = new ApplyForLoanServiceImpl(loanService, validators, applyForLoanDtoMapper);
    }

    @Test
    public void test() {
        Assert.assertNotNull(tested.applyForLoan(TERM, AMOUNT));
    }

}
