package com.homework;

import com.homework.dto.ApplyForLoanDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {LoanCostService.class, LoanTermService.class})
public abstract class ApplyForLoanDtoMapper {

    @Autowired
    private LoanCostService loanCostService;

    @Autowired
    private LoanTermService loanTermService;

    public abstract ApplyForLoanDto loanToApplyForLoanDto(Loan loan);

    @AfterMapping
    protected void fillApplyForLoanDto(Loan loan, @MappingTarget ApplyForLoanDto applyForLoanDto) {
        applyForLoanDto.setAmountToPay(loanCostService.calculateAmountToRepay(loan));
        applyForLoanDto.setLoanEnd(loanTermService.calculateLoanEndDate(loan));
    }
}
