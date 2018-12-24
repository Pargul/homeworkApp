package com.homework;

import com.homework.dto.ApplyForLoanDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
class ApplyForLoanServiceImpl implements ApplyForLoanService {

    private LoanService loanService;
    private List<ApplyForLoanValidator> validators;
    private ApplyForLoanDtoMapper applyForLoanDtoMapper;

    public ApplyForLoanServiceImpl(LoanService loanService, List<ApplyForLoanValidator> validators,
                                   ApplyForLoanDtoMapper applyForLoanDtoMapper) {
        this.loanService = loanService;
        this.validators = validators;
        this.applyForLoanDtoMapper = applyForLoanDtoMapper;
    }

    @Override
    public ApplyForLoanDto applyForLoan(Integer term, BigDecimal amount) {

        LoanApplication loanApplication = LoanApplication.builder()
                .setLoanApplicationCreateTime(LocalDateTime.now())
                .setAmount(amount)
                .setTerm(term)
                .build();

        validateApplication(loanApplication);
        Loan loan = loanService.save(loanApplication);
        return applyForLoanDtoMapper.loanToApplyForLoanDto(loan);
    }

    private void validateApplication(LoanApplication loanApplication) {
        for (ApplyForLoanValidator applyForLoanValidator : validators) {
            applyForLoanValidator.apply(loanApplication);
        }
    }
}
