package com.homework;

import com.homework.dto.ExtendLoanDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {LoanCostService.class, LoanTermService.class})
public abstract class ExtendLoanDtoMapper {

    @Autowired
    private LoanCostService loanCostService;

    @Autowired
    private LoanTermService loanTermService;

    public abstract ExtendLoanDto loanToExtendLoanDto(Loan loan);

    @AfterMapping
    protected void fillExtendLoanDto(Loan loan, @MappingTarget ExtendLoanDto extendLoanDto) {
        extendLoanDto.setAmountToPay(loanCostService.calculateAmountToRepay(loan));
        extendLoanDto.setLoanEndDate(loanTermService.calculateLoanEndDate(loan));
    }
}
