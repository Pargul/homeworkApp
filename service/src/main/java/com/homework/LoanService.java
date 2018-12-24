package com.homework;

import com.homework.entity.LoanEntity;

public interface LoanService {

    /**
     * Save loan
     *
     * @param loanApplication loan application
     * @return loan id
     */
    Loan save(LoanApplication loanApplication);

    /**
     * Find loan entity by id
     *
     * @param lonaId loan id
     * @return loan entity
     */
    LoanEntity findById(Long lonaId);

    /**
     * Create annex for loan
     *
     * @param loanId loan id
     */
    void createAnnexForLoan(Long loanId);
}
