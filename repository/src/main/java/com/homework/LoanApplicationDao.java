package com.homework;

import com.homework.entity.LoanApplicationEntity;
import org.springframework.data.repository.CrudRepository;

interface LoanApplicationDao extends CrudRepository<LoanApplicationEntity, Long> {
}
