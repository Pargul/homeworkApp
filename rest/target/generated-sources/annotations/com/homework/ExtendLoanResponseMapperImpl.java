package com.homework;

import com.homework.dto.ExtendLoanDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-24T10:09:14+0100",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class ExtendLoanResponseMapperImpl implements ExtendLoanResponseMapper {

    @Override
    public ExtendLoanResponse toExtendLoanResponse(ExtendLoanDto extendLoanDto) {
        if ( extendLoanDto == null ) {
            return null;
        }

        ExtendLoanResponse extendLoanResponse = new ExtendLoanResponse();

        extendLoanResponse.setLoanId( extendLoanDto.getLoanId() );
        extendLoanResponse.setLoanStartDate( extendLoanDto.getLoanStartDate() );
        extendLoanResponse.setLoanEndDate( extendLoanDto.getLoanEndDate() );
        extendLoanResponse.setAmount( extendLoanDto.getAmount() );
        extendLoanResponse.setAmountToPay( extendLoanDto.getAmountToPay() );
        extendLoanResponse.setLoanCost( extendLoanDto.getLoanCost() );

        return extendLoanResponse;
    }
}
