package com.homework;

import com.homework.entity.LoanAnnexEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-24T10:08:55+0100",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class LoanAnnexEntityMapperImpl extends LoanAnnexEntityMapper {

    @Override
    public LoanAnnexEntity toAnnexEntity(LoanAnnex loanAnnex) {
        if ( loanAnnex == null ) {
            return null;
        }

        LoanAnnexEntity loanAnnexEntity = new LoanAnnexEntity();

        loanAnnexEntity.setAdditionalTerm( loanAnnex.getAdditionalTerm() );
        loanAnnexEntity.setCreateDate( loanAnnex.getCreateDate() );

        return loanAnnexEntity;
    }
}
