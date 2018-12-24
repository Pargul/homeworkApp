package com.homework;

import com.homework.entity.LoanAnnexEntity;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

public class LoanAnnexEntityMapperTest {

    private LoanAnnexEntityMapper tested = Mappers.getMapper(LoanAnnexEntityMapper.class);

    @Test
    public void testToAnnexEntity() {
        LoanAnnex loanAnnex = LoanAnnex.builder()
                .setAdditionalTerm(10)
                .setCreateDate(LocalDateTime.now())
                .build();
        LoanAnnexEntity loanAnnexEntity = tested.toAnnexEntity(loanAnnex);
        Assert.assertEquals(loanAnnex.getAdditionalTerm(), loanAnnexEntity.getAdditionalTerm());
        Assert.assertEquals(loanAnnex.getCreateDate(), loanAnnexEntity.getCreateDate());
    }

    @Test
    public void testToAnnex() {
        LoanAnnexEntity loanAnnexEntity = new LoanAnnexEntity();
        loanAnnexEntity.setAdditionalTerm(10);
        loanAnnexEntity .setCreateDate(LocalDateTime.now());
        LoanAnnex loanAnnex = tested.toAnnex(loanAnnexEntity);
        Assert.assertEquals(loanAnnexEntity.getAdditionalTerm(), loanAnnex.getAdditionalTerm());
        Assert.assertEquals(loanAnnexEntity.getCreateDate(), loanAnnex.getCreateDate());
    }


}
