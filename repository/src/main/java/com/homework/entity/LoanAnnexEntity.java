package com.homework.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoanAnnexEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Integer additionalTerm;
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

    public Integer getAdditionalTerm() {
        return additionalTerm;
    }

    public void setAdditionalTerm(Integer additionalTerm) {
        this.additionalTerm = additionalTerm;
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
