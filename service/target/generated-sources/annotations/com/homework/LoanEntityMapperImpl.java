package com.homework;

import com.homework.entity.LoanEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-24T10:08:55+0100",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class LoanEntityMapperImpl extends LoanEntityMapper {

    @Override
    public LoanEntity toLoanEntity(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanEntity loanEntity = new LoanEntity();

        loanEntity.setLoanStartDate( loan.getLoanStartDate() );
        loanEntity.setTerm( loan.getTerm() );
        loanEntity.setAmount( loan.getAmount() );
        loanEntity.setLoanCost( loan.getLoanCost() );

        return loanEntity;
    }
}
