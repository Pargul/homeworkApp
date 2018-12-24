package com.homework;

import com.homework.conf.LoanConfigurationProperties;
import com.homework.entity.LoanAnnexEntity;
import com.homework.entity.LoanEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanAnnexServiceImpl implements LoanAnnexService {

    private LoanAnnexDao loanAnnexDao;
    private LoanAnnexEntityMapper loanAnnexEntityMapper;

    public LoanAnnexServiceImpl(LoanAnnexDao loanAnnexDao, LoanAnnexEntityMapper loanAnnexEntityMapper) {
        this.loanAnnexDao = loanAnnexDao;
        this.loanAnnexEntityMapper = loanAnnexEntityMapper;
    }

    @Override
    public LoanAnnex save(LoanEntity loanEntity) {
        LoanAnnexEntity loanAnnexEntity = new LoanAnnexEntity();
        loanAnnexEntity.setAdditionalTerm(LoanConfigurationProperties.ADDITIONAL_TERM);
        loanAnnexEntity.setLoanEntity(loanEntity);
        loanAnnexEntity = loanAnnexDao.save(loanAnnexEntity);
        LoanAnnex loanAnnex = LoanAnnex.builder()
                .setAdditionalTerm(loanAnnexEntity.getAdditionalTerm())
                .setCreateDate(loanAnnexEntity.getCreateDate())
                .build();
        return loanAnnex;
    }

    public List<LoanAnnex> findAnnexByLoanId(Long loanId) {
        List<LoanAnnexEntity> loanAnnexEntityList = loanAnnexDao.findByLoanEntityId(loanId);
        List<LoanAnnex> loanAnnexList = new ArrayList<>();
        for (LoanAnnexEntity loanAnnexEntity : loanAnnexEntityList) {
            loanAnnexList.add(loanAnnexEntityMapper.toAnnex(loanAnnexEntity));
        }
        return loanAnnexList;
    }
}
