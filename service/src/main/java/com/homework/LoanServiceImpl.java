package com.homework;

import com.homework.conf.LoanConfigurationProperties;
import com.homework.entity.LoanEntity;
import com.homework.exception.LoanNotExistException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private LoanApplicationService loanApplicationService;
    private LoanEntityMapper loanEntityMapper;
    private LoanDao loanDao;
    private LoanAnnexService loanAnnexService;

    public LoanServiceImpl(LoanApplicationService loanApplicationService, LoanEntityMapper loanEntityMapper, LoanDao loanDao, LoanAnnexService loanAnnexService) {
        this.loanApplicationService = loanApplicationService;
        this.loanEntityMapper = loanEntityMapper;
        this.loanDao = loanDao;
        this.loanAnnexService = loanAnnexService;
    }

    @Override
    public Loan save(LoanApplication loanApplication) {
        Loan loan = Loan.builder()
                .setAmount(loanApplication.getAmount())
                .setLoanCost(LoanConfigurationProperties.LOAN_COST)
                .setTerm(loanApplication.getTerm())
                .setLoanStartDate(LocalDate.now())
                .setLoanAppilication(loanApplication)
                .build();

        LoanEntity loanEntity = loanEntityMapper.toLoanEntity(loan);
        loanEntity = loanDao.save(loanEntity);
        loanApplicationService.save(loanApplication, loanEntity);
        loan = Loan.builder()
                .copyOf(loan)
                .setLoanId(loanEntity.getId())
                .build();
        return loan;
    }

    @Override
    public LoanEntity findById(Long loanId) {
        Optional<LoanEntity> optionalLoanEntity = loanDao.findById(loanId);
        if (!optionalLoanEntity.isPresent()) {
            throw new LoanNotExistException();
        }
        return optionalLoanEntity.get();
    }

    public void createAnnexForLoan(Long loanId) {
        Optional<LoanEntity> optionalLoanEntity = loanDao.findById(loanId);
        if (!optionalLoanEntity.isPresent()) {
            throw new LoanNotExistException();
        }
        LoanEntity loanEntity = optionalLoanEntity.get();
        loanAnnexService.save(loanEntity);
    }
}
