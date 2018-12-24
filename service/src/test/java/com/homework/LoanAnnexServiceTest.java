package com.homework;

import com.homework.conf.LoanConfigurationProperties;
import com.homework.entity.LoanAnnexEntity;
import com.homework.entity.LoanEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class LoanAnnexServiceTest {

    private LoanAnnexService tested;

    @Before
    public void setUp() {
        LoanAnnexDao loanAnnexDao = Mockito.mock(LoanAnnexDao.class);
        LoanAnnexEntity loanAnnexEntity = new LoanAnnexEntity();
        loanAnnexEntity.setAdditionalTerm(LoanConfigurationProperties.ADDITIONAL_TERM);
        loanAnnexEntity.setCreateDate(LocalDateTime.now());
        Mockito.when(loanAnnexDao.save(Mockito.any())).thenReturn(loanAnnexEntity);
        LoanAnnexEntityMapper loanAnnexEntityMapper = Mockito.mock(LoanAnnexEntityMapper.class);
        tested = new LoanAnnexServiceImpl(loanAnnexDao, loanAnnexEntityMapper);
    }

    @Test
    public void testSave() {
        LoanAnnex loanAnnex = tested.save(new LoanEntity());
        Assert.assertNotNull(loanAnnex);
        Assert.assertEquals(LoanConfigurationProperties.ADDITIONAL_TERM, loanAnnex.getAdditionalTerm());
    }


}
