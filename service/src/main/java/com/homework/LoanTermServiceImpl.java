package com.homework;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanTermServiceImpl implements LoanTermService {

    @Override
    public LocalDate calculateLoanEndDate(Loan loan) {
        Integer term = loan.getTerm();
        for (LoanAnnex loanAnnex : loan.getLoanAnnexList()) {
            term += loanAnnex.getAdditionalTerm();
        }
        return LocalDate.now().plusDays(term);
    }
}
