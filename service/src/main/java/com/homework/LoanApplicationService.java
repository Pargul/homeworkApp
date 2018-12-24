package com.homework;

import com.homework.entity.LoanEntity;

interface LoanApplicationService {

    /**
     * Save loan application object
     *
     * @param loanApplication loan application object
     * @param loanEntity      loan
     */
    void save(LoanApplication loanApplication, LoanEntity loanEntity);
}
