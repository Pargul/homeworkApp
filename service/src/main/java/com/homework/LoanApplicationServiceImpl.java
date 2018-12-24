package com.homework;

import com.homework.entity.LoanApplicationEntity;
import com.homework.entity.LoanEntity;
import org.springframework.stereotype.Service;

@Service
class LoanApplicationServiceImpl implements LoanApplicationService {

    private LoanApplicationDao loanApplicationDao;
    private LoanApplicationEntityMapper loanApplicationEntityMapper;

    public LoanApplicationServiceImpl(LoanApplicationDao loanApplicationDao, LoanApplicationEntityMapper loanApplicationEntityMapper) {
        this.loanApplicationDao = loanApplicationDao;
        this.loanApplicationEntityMapper = loanApplicationEntityMapper;
    }

    @Override
    public void save(LoanApplication loanApplication, LoanEntity loanEntity) {
        LoanApplicationEntity loanApplicationEntity = loanApplicationEntityMapper.toLoanApplicationEntity(loanApplication);
        loanApplicationEntity.setLoanEntity(loanEntity);
        loanApplicationDao.save(loanApplicationEntity);
    }
}
