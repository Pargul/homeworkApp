package com.homework;

import com.homework.dto.ApplyForLoanDto;
import com.homework.dto.ExtendLoanDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class LoanController {

    @Autowired
    private ApplyForLoanService applyForLoanService;

    @Autowired
    private ExtendLoanService extendLoanService;

    @RequestMapping("/apply_for_loan")
    public ApplyForLoanResponse applyForLoan(@RequestParam(value = "term") Integer term,
                                             @RequestParam(value = "amount") BigDecimal amount) {

        ApplyForLoanDto applyForLoanDto = applyForLoanService.applyForLoan(term, amount);
        ApplyForLoanResponseMapper mapper = Mappers.getMapper(ApplyForLoanResponseMapper.class);
        return mapper.toApplyForLoanResponse(applyForLoanDto);
    }

    @RequestMapping("/extend_loan")
    public ExtendLoanResponse extendLoan(@RequestParam(value = "loanId") Long loanId) {
        ExtendLoanDto extendLoanDto = extendLoanService.extendLoan(loanId);
        ExtendLoanResponseMapper mapper = Mappers.getMapper(ExtendLoanResponseMapper.class);
        return mapper.toExtendLoanResponse(extendLoanDto);
    }
}
