package com.homework;

import com.homework.entity.LoanApplicationEntity;
import com.homework.entity.LoanEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class LoanApplicationServiceTest {
    private static final Long LOAN_APP_ID = 100l;
    private LoanApplicationService tested;

    @Before
    public void setUp() {
        LoanApplicationDao loanApplicationDao = Mockito.mock(LoanApplicationDao.class);
        LoanApplicationEntityMapper loanApplicationEntityMapper = Mockito.mock(LoanApplicationEntityMapper.class);
        Mockito.when(loanApplicationEntityMapper.toLoanApplicationEntity(Mockito.any())).thenReturn(new LoanApplicationEntity());
        tested = new LoanApplicationServiceImpl(loanApplicationDao, loanApplicationEntityMapper);
    }

    @Test
    public void test() {
        tested.save(LoanApplication.builder().build(), new LoanEntity());
    }
}
