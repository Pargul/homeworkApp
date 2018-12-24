package com.homework;

import com.homework.dto.ApplyForLoanDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-24T10:08:56+0100",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class ApplyForLoanDtoMapperImpl extends ApplyForLoanDtoMapper {

    @Override
    public ApplyForLoanDto loanToApplyForLoanDto(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        ApplyForLoanDto applyForLoanDto = new ApplyForLoanDto();

        applyForLoanDto.setLoanId( loan.getLoanId() );
        applyForLoanDto.setLoanStartDate( loan.getLoanStartDate() );
        applyForLoanDto.setAmount( loan.getAmount() );
        applyForLoanDto.setLoanCost( loan.getLoanCost() );

        fillApplyForLoanDto( loan, applyForLoanDto );

        return applyForLoanDto;
    }
}
