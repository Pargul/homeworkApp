package com.homework;

import com.homework.entity.LoanEntity;
import org.springframework.data.repository.CrudRepository;

interface LoanDao extends CrudRepository<LoanEntity, Long> {
}
