package com.homework;

import com.homework.dto.ExtendLoanDto;
import org.mapstruct.Mapper;

@Mapper
public interface ExtendLoanResponseMapper {

    ExtendLoanResponse toExtendLoanResponse(ExtendLoanDto extendLoanDto);
}
