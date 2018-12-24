package com.homework;

import com.homework.entity.LoanEntity;
import com.homework.exception.LoanNotExistException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class LoanServiceTest {

    private static final Long LOAN_ID = 100l;
    private LoanService tested;

    @Before
    public void setUp() {
        LoanDao loanDao = Mockito.mock(LoanDao.class);
        LoanEntity loanEntity = new LoanEntity();
        loanEntity.setId(LOAN_ID);
        Mockito.when(loanDao.save(Mockito.any())).thenReturn(loanEntity);
        Mockito.when(loanDao.findById(LOAN_ID)).thenReturn(Optional.of(loanEntity));
        LoanApplicationService loanApplicationService = Mockito.mock(LoanApplicationService.class);
        LoanEntityMapper loanEntityMapper = Mockito.mock(LoanEntityMapper.class);
        LoanAnnexService loanAnnexService = Mockito.mock(LoanAnnexService.class);
        tested = new LoanServiceImpl(loanApplicationService, loanEntityMapper, loanDao, loanAnnexService);
    }

    @Test
    public void testSave() {
        Assert.assertEquals(LOAN_ID, tested.save(LoanApplication.builder().build()).getLoanId());
    }

    @Test
    public void testFindBy() {
        Assert.assertEquals(LOAN_ID, tested.findById(LOAN_ID).getId());
    }

    @Test(expected = LoanNotExistException.class)
    public void testFindByFail() {
        Assert.assertEquals(LOAN_ID, tested.findById(-1L).getId());
    }
}
