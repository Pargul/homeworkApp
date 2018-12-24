package com.homework.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class LoanApplicationEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Integer term;
    private BigDecimal amount;
    private LocalDateTime createDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "loan_entity_id")
    private LoanEntity loanEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LoanEntity getLoanEntity() {
        return loanEntity;
    }

    public void setLoanEntity(LoanEntity loanEntity) {
        this.loanEntity = loanEntity;
    }
}
