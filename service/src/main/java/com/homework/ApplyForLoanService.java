package com.homework;

import com.homework.dto.ApplyForLoanDto;

import java.math.BigDecimal;

interface ApplyForLoanService {

    /**
     * Creates loan depends of params
     *
     * @param term   term of loan
     * @param amount amount of loan
     * @return loan or validation exception
     */
    ApplyForLoanDto applyForLoan(Integer term, BigDecimal amount);
}
