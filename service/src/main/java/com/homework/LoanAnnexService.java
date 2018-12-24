package com.homework;

import com.homework.entity.LoanEntity;

import java.util.List;

public interface LoanAnnexService {

    /**
     * Save loan annex
     *
     * @param loanEntity loan entity
     * @return saved loan annex
     */
    LoanAnnex save(LoanEntity loanEntity);

    /**
     * List of loan annex
     *
     * @param loanId loan id
     * @return loan annex list
     */
    List<LoanAnnex> findAnnexByLoanId(Long loanId);
}
