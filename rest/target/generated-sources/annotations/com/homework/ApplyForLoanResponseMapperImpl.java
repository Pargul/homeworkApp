package com.homework;

import com.homework.dto.ApplyForLoanDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-24T10:09:14+0100",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class ApplyForLoanResponseMapperImpl implements ApplyForLoanResponseMapper {

    @Override
    public ApplyForLoanResponse toApplyForLoanResponse(ApplyForLoanDto applyForLoanDto) {
        if ( applyForLoanDto == null ) {
            return null;
        }

        ApplyForLoanResponse applyForLoanResponse = new ApplyForLoanResponse();

        applyForLoanResponse.setLoanId( applyForLoanDto.getLoanId() );
        applyForLoanResponse.setLoanStartDate( applyForLoanDto.getLoanStartDate() );
        applyForLoanResponse.setLoanEnd( applyForLoanDto.getLoanEnd() );
        applyForLoanResponse.setAmount( applyForLoanDto.getAmount() );
        applyForLoanResponse.setAmountToPay( applyForLoanDto.getAmountToPay() );
        applyForLoanResponse.setLoanCost( applyForLoanDto.getLoanCost() );

        return applyForLoanResponse;
    }
}
