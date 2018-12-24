package com.homework;

import com.homework.entity.LoanApplicationEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-24T10:08:55+0100",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class LoanApplicationEntityMapperImpl implements LoanApplicationEntityMapper {

    @Override
    public LoanApplicationEntity toLoanApplicationEntity(LoanApplication loanApplication) {
        if ( loanApplication == null ) {
            return null;
        }

        LoanApplicationEntity loanApplicationEntity = new LoanApplicationEntity();

        loanApplicationEntity.setTerm( loanApplication.getTerm() );
        loanApplicationEntity.setAmount( loanApplication.getAmount() );

        return loanApplicationEntity;
    }
}
