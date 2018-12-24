package com.homework;

import java.time.LocalDate;

public interface LoanTermService {

    /**
     * Calculate loan end date
     *
     * @param loan loan
     * @return end date of loan
     */
    LocalDate calculateLoanEndDate(Loan loan);
}
