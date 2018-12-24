package com.homework;

import com.homework.entity.LoanAnnexEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface LoanAnnexDao extends CrudRepository<LoanAnnexEntity, Long> {
    List<LoanAnnexEntity> findByLoanEntityId(Long loanId);
}
