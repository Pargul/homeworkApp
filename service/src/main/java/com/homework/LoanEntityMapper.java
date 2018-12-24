package com.homework;

import com.homework.entity.LoanEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class LoanEntityMapper {

    public abstract LoanEntity toLoanEntity(Loan loan);

    public Loan toLoan(LoanEntity loanEntity, List<LoanAnnex> loanAnnexes) {
        return Loan.builder()
                .setAmount(loanEntity.getAmount())
                .setAnnexList(loanAnnexes)
                .setLoanCost(loanEntity.getLoanCost())
                .setLoanId(loanEntity.getId())
                .setLoanStartDate(loanEntity.getLoanStartDate())
                .setTerm(loanEntity.getTerm())
                .build();
    }
}
