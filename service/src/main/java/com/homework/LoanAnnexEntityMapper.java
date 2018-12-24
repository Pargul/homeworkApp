package com.homework;

import com.homework.entity.LoanAnnexEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class LoanAnnexEntityMapper {

    public abstract LoanAnnexEntity toAnnexEntity(LoanAnnex loanAnnex);

    public LoanAnnex toAnnex(LoanAnnexEntity loanAnnexEntity) {
        return LoanAnnex.builder()
                .setAdditionalTerm(loanAnnexEntity.getAdditionalTerm())
                .setCreateDate(loanAnnexEntity.getCreateDate())
                .build();
    }
}
