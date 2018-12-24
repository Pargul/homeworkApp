package com.homework;

import com.homework.entity.LoanApplicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanApplicationEntityMapper {

    /**
     * Maps loanApplication to loanApplicationEntity
     *
     * @param loanApplication object to map
     * @return mapped entity object
     */
    LoanApplicationEntity toLoanApplicationEntity(LoanApplication loanApplication);
}
