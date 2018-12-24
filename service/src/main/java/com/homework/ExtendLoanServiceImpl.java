package com.homework;

import com.homework.dto.ExtendLoanDto;
import com.homework.entity.LoanEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtendLoanServiceImpl implements ExtendLoanService {

    private LoanService loanService;
    private ExtendLoanDtoMapper extendLoanDtoMapper;
    private LoanAnnexService loanAnnexService;
    private LoanEntityMapper loanEntityMapper;

    public ExtendLoanServiceImpl(LoanService loanService, ExtendLoanDtoMapper extendLoanDtoMapper, LoanAnnexService loanAnnexService, LoanEntityMapper loanEntityMapper) {
        this.loanService = loanService;
        this.extendLoanDtoMapper = extendLoanDtoMapper;
        this.loanAnnexService = loanAnnexService;
        this.loanEntityMapper = loanEntityMapper;
    }

    @Override
    public ExtendLoanDto extendLoan(Long lonaId) {
        LoanEntity loanEntity = loanService.findById(lonaId);
        loanService.createAnnexForLoan(lonaId);
        List<LoanAnnex> loanAnnexList = loanAnnexService.findAnnexByLoanId(lonaId);
        Loan loan = loanEntityMapper.toLoan(loanEntity, loanAnnexList);
        return extendLoanDtoMapper.loanToExtendLoanDto(loan);
    }
}
