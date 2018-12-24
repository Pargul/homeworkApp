package com.homework;

import com.homework.dto.ExtendLoanDto;

public interface ExtendLoanService {

    /**
     * Extend loan term
     *
     * @param lonaId loan id
     * @return loan info
     */
    ExtendLoanDto extendLoan(Long lonaId);
}
