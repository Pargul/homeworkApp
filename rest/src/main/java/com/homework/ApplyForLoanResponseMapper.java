package com.homework;

import com.homework.dto.ApplyForLoanDto;
import org.mapstruct.Mapper;

@Mapper
public interface ApplyForLoanResponseMapper {

    ApplyForLoanResponse toApplyForLoanResponse(ApplyForLoanDto applyForLoanDto);
}
