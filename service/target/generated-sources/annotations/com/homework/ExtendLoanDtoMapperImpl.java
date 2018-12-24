package com.homework;

import com.homework.dto.ExtendLoanDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-24T10:08:55+0100",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class ExtendLoanDtoMapperImpl extends ExtendLoanDtoMapper {

    @Override
    public ExtendLoanDto loanToExtendLoanDto(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        ExtendLoanDto extendLoanDto = new ExtendLoanDto();

        extendLoanDto.setLoanId( loan.getLoanId() );
        extendLoanDto.setLoanStartDate( loan.getLoanStartDate() );
        extendLoanDto.setAmount( loan.getAmount() );
        extendLoanDto.setLoanCost( loan.getLoanCost() );

        fillExtendLoanDto( loan, extendLoanDto );

        return extendLoanDto;
    }
}
